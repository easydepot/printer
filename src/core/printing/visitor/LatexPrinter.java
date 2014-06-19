package core.printing.visitor;


import java.awt.Color;

import core.printer.helper.StringReplace;
import core.printing.BasicElement;
import core.printing.BasicElementWithChildren;
import core.printing.Box;
import core.printing.Image;
import core.printing.NewLine;
import core.printing.NewPage;
import core.printing.Paragraph;
import core.printing.Quote;
import core.printing.Section;
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
	static boolean withoutfailuremode = true;
	
  public int getSectionlevel() {
		return sectionlevel;
	}

	public void setSectionlevel(int sectionlevel) {
		this.sectionlevel = sectionlevel;
	}

	public static String latexize(String s) throws Exception{
		
		if (s==null){
			if (withoutfailuremode){
				return "";
			}
			throw new Exception("Try to print a null value");}
		StringReplace sr = new StringReplace(s);
		sr.replace("_", "\\_\\-");
		sr.replace("%", "\\%");
		sr.replace("˚","°" );
		sr.replace("N°", "\\No");
		sr.replace("n°", "\\no");
		sr.replace("ﬁ", "fi");
		return sr.getResult();
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
	  if (t.isStrikeThrough()) return "\\sout{" + latexize(t.getText()) +"}";
	  if (t.getColor()!=null) return "\\textcolor{" + t.getColor() + "}{" + latexize(t.getText()) +"}";
	  return  latexize(t.getText());
  }
  
  public String visit(BasicElementWithChildren s) throws Exception{
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
	  int StartingRow = 1;
	  returned+= getPrinterTableContentFromRow(t, StartingRow);
	return returned;
}

private String getPrinterTableContentFromRow(SimpleTable simpleTable, int StartingRow)
		throws Exception {
	String resultTableContent = "";
	  for (int i = StartingRow; i < simpleTable.getNumberOfRow();i++){
		  String rowValue = printRowValue(simpleTable, i);
		  
		  resultTableContent +=rowValue;
		  
		  
	  }
	return resultTableContent;
}

protected String printRowValue(SimpleTable t, int i) throws Exception {
	String rowValue ="";
	  
	  for (int j = 0; j < t.getNumberOfCellsCurrentline()-1;j++){
		  rowValue += printCell(t.getCell(i, j));
		  rowValue += " & ";
	  }
	  rowValue += printCell(t.getCell(i, t.getNumberOfCellsCurrentline()-1));
	  rowValue += " \\\\  \\hline \n";
	return rowValue;
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

private String getAlignement(SimpleTable t) {
	String returned = "";
	  returned +=  "{|l|";
	  for (int j=1;j<t.getMaxNumberOfCol();j++){
		  returned += "l|"; 
	  }
	  returned += "}\n";
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

@Override
public String visit(SimpleTable simpleTable) throws Exception {
	if (simpleTable.getNumberOfRow()==0){
		return "";
	}
	String result = "\\begin{tabular}";
	result += getAlignement(simpleTable);		
	result += "\\hline\n";
	result += getPrinterTableContentFromRow(simpleTable, 0);
	result += "\\end{tabular}";
	return result;

	
	
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
		  
	  if (c.getColor()!=null && c.getColor()!= Color.WHITE){
		  result +=  "\\cellcolor{" + c.getColor() + "} ";
	  }
	  if (!c.getContent().getClass().equals(ListItem.class)){
	    result +=  c.getContent().accept(this) ;
	  } else {
		  result += "\\begin{minipage}{6cm}\n";
		  result += "\\begin{medskip}\n";
		  
		  result +=  c.getContent().accept(this) ;
		  result += "\\end{medskip}\n";
		  result += "\\end{minipage}\n";
	  }
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
	if (this.sectionlevel==4) {result += "\n\\textit{"+ latexize(section.getTitle()) + "}\n";}
	
	this.sectionlevel++;
	for (BasicElement e:section.getChildren()){
	  result += e.accept(this)+" ";
	}
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

public String beginEnvironment(String val){
	String result = "\\begin{";
	result+=val;
	result += "}\n";
	return result;
}

public String endEnvironment(String val){
	String result = "\\end{";
	result+=val;
	result += "}\n";
	return result;
}

public String encloseInEnvironement(String environement,String value){
	String result = "";
	result+= beginEnvironment(environement);
	result+= value;
	result+= "\n" + endEnvironment(environement);
	return result;
	
}

@Override
public String visit(Paragraph element) throws Exception {
	
	String content;
	if (!element.hasChildren()){
		return "";
	} else {
		content = element.accept(this);
	}
	if (element.getAlignement().equals(ALIGN.CENTER)){
		return encloseInEnvironement("center",content);
	}
	if (element.getAlignement().equals(ALIGN.RIGHT)){
		return encloseInEnvironement("flushright",content);
	}
	return content;
}

@Override
public String visit(Box element) throws Exception {
	String s = "";
	if (element.getTitle()!=null){
	 s += "\\boxput*(0,1){\\colorbox{white}{\\textbf{" + element.getTitle() + "}}}";
	 s += "{\\setlength{\\fboxsep}{12pt}";
	 s += visitInBox(element); 
	 s += "\\end{minipage}}}";
	} else {
		 s += visitInBox(element);
	}
	return s;
}

private String visitInBox(Box element) throws Exception {
	 String res = "\\shadowbox{\\begin{minipage}[c]{\\linewidth}";
	 for (BasicElement e: element.getChildren()){
	   res += e.accept(this);
	 }
	 res += "\\end{minipage}}";
	return res;
}








}
