package core.printing.visitor;


import core.printing.Image;
import core.printing.NewLine;
import core.printing.NewPage;
import core.printing.Quote;
import core.printing.Section;
import core.printing.Sequence;
import core.printing.SimpleText;
import core.printing.TableOfContent;
import core.printing.list.ListItem;
import core.printing.table.CellPrinter;
import core.printing.table.SimpleTable;
import core.printing.table.TablePrinter;
import core.printing.table.alignment.ClassicAlignement;
import core.printing.table.alignment.ClassicAlignement.ALIGN;
import core.printing.table.alignment.SizedAlignement;
import core.printing.table.alignment.TableAlignement;
import core.printing.table.size.FixedSize;
import core.printing.table.size.SpecialSize;

public class LatexPrinter extends PrintingVisitorImplementation implements PrintingVisitor{
	
	int sectionlevel=0;
	
  public int getSectionlevel() {
		return sectionlevel;
	}

	public void setSectionlevel(int sectionlevel) {
		this.sectionlevel = sectionlevel;
	}

	public static String latexize(String s) throws Exception{
		if (s==null){throw new Exception("Try to print a null value");}
		return s.replace("_", "\\_\\-");
	}
	
public String visit(ListItem l) throws Exception{
	  String result = "";
	  if (l.size()==0){return result;}
	  result += "\\begin{itemize}\n";
	  for (int i = 0; i < l.size();i++){
		  result += "\\item " + l.get(i).accept(this) + "\n";
	  }
	  result += "\\end{itemize}\n";
	  return result;
  }
  
  public String visit(SimpleText t) throws Exception{
	  if (t.isBold()) return "\\textbf{" + latexize(t.getText()) +"}";
	  if (t.isItalic()) return "\\textit{" + latexize(t.getText()) +"}";
	  if (t.getColor()!=null) return "\\textcolor{" + t.getColor() + "}{" + latexize(t.getText()) +"}";
	  return  latexize(t.getText());
  }
  
  public String visit(Sequence s) throws Exception{
	  String result="";
	  if (s == null){throw new Exception("Sequence is null");}
	  for (int i = 0; i < s.size();i++){
		  
		  result += s.get(i).accept(this) +" ";
	  }
	  return result;
	  
  }
  
  
  public String print(TableAlignement e){
	  if (e == null){return "X";}
	  if (e.getClass().equals(ClassicAlignement.class)){
		  if (((ClassicAlignement) e).getAlignement().equals(ALIGN.CENTER)){
			  return "c";
		  }
		  if (((ClassicAlignement) e).getAlignement().equals(ALIGN.LEFT)){
			  return "l";
		  }
		  if (((ClassicAlignement) e).getAlignement().equals(ALIGN.RIGHT)){
			  return "r";
		  }
		  if (((ClassicAlignement) e).getAlignement().equals(ALIGN.EXTEND)){
			  return "X";
		  }
	  }
	  if (e.getClass().equals(SizedAlignement.class)){
		  return "p{"+(((SizedAlignement) e).getSize()) + "cm}";
			  
	  }
	  return "X";
  }

  
  public String visit(TablePrinter t) throws Exception{
	  String result = getTabularOpen(t);
	 
	  
	  result+=getAlignement(t);;
	
	  
	
	  result +=  getContent(t);;
	  result +=  getClosing(t);;
	  return result;
  }

private String getContent(TablePrinter t) throws Exception {
	String returned ="";
	  returned += "\\hline\n";
	  for (int j=0;j<t.getNumberOfCellsCurrentline();j++){
	  // introduce colspan
	  CellPrinter c =  t.getCell(0, j);
	  
	  returned += printCell(c);
	  if (j==t.getMaxNumberOfCol()-1){returned+="\\\\ \n";}
	  else {returned+=" & ";}
	  }
	  returned += "\\hline\n";
	  returned += "\\hline\n";
	  for (int i = 1; i < t.getNumberOfRow();i++){
		  for (int j = 0; j < t.getNumberOfCellsCurrentline()-1;j++){
			  returned += printCell(t.getCell(i, j));
			  returned += " & ";
		  }
		  returned += printCell(t.getCell(i, t.getNumberOfCellsCurrentline()-1));
		  returned += " \\\\  \\hline \n";
		  
		  
	  }
	return returned;
}

private String getClosing(TablePrinter t) {
	String returned = "";
	  if (t.isLongtable()){
		  returned += "\\end{longtable}\n\n";
	  }else{
		  returned += "\\end{tabularx}\n\n";
	  }
	return returned;
}

private String getAlignement(TablePrinter t) {
	String returned = "";
	  returned +=  "{|" + print(t.getAlignement(0)) + "|";
	  for (int j=1;j<t.getMaxNumberOfCol();j++){
		  returned += print(t.getAlignement(j))+"|"; 
	  }
	  returned += "}\n";
	return returned;
}

private String getTabularOpen(TablePrinter t) throws Exception {
	String returnval ="";
	  if (t.isLongtable()){
		  returnval +=  "\\begin{longtable}";
	  }
	  else{
		  returnval +=  "\\begin{tabularx}{"+ t.getSize().accept(this)  + "}";
	  }
	return returnval;
}

/**
 * @param c The cell to print in LAtex
 * @return A String containing the latex representation of the cell.
 * @throws Exception 
 */
private String printCell(CellPrinter c) throws Exception {
	String result ="";
	if (c.getColspan()!=0){
		  result += "\\multicolumn{" + c.getColspan() + "}{|" + c.getColspantype() + "|}{";  
	  }
		  
	  if (c.getColor()!=null){
		  result +=  "\\cellcolor{" + c.getColor() + "} ";
	  }
	  result +=  c.getContent().accept(this) ;
	  if (c.getColspan()!=0){
		  result += "}";  
	  }
	return result;
}


public String visit(FixedSize fixedSize) {
	
	return fixedSize.getSize()+"cm";
}

@Override
public String visit(Section section) throws Exception {
	String result = "";
	if (this.sectionlevel==0) {result += "\n\\section{"+ latexize(section.getTitle()) + "}\n";}
	if (this.sectionlevel==1) {result += "\n\\subsection{"+ latexize(section.getTitle()) + "}\n";}
	if (this.sectionlevel==2) {result += "\n\\subsubsection{"+ latexize(section.getTitle()) + "}\n";}
	if (this.sectionlevel==3) {result += "\n\\paragraph{"+ latexize(section.getTitle()) + "}\n";}
	
	this.sectionlevel++;
	result += section.getContent().accept(this);
	this.sectionlevel--;
	return result;
}

@Override
public String visit(SpecialSize specialSize) {
	
	return "\\" +specialSize.getType();
}

@Override
public String visit(NewLine newLine) {
	
	return "\\\\\n";
}

@Override
public String visit(NewPage newPage) {
	
	return "\\newpage";
}

@Override
public String visit(TableOfContent tableOfContent) {
	 return "\\tableofcontents \n\n";
}

@Override
public String visit(Image image) {
	String result = "\\includegraphics";
	if (image.getScale()!=0){result += "[scale=0." + image.getScale() + "]";};
	result += "{" + image.getFile().getPath() +"}\n";
	return result;
}

@Override
public String visit(Quote quote) throws Exception {
	return "\\quote{" + quote.getContent().accept(this) + "} " ;
}

@Override
public String visit(SimpleTable simpleTable) {

	
	return null;
}


}
