package core.printing.visitor;




import core.printing.BasicElement;
import core.printing.BasicElementImplementation;
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
import core.printing.table.size.FixedSize;
import core.printing.table.size.SpecialSize;

public class HTMLPrinter extends PrintingVisitorImplementation {
	

	private int sectionlevel = 0;

	@Override
	public String visit(ListItem wheel) throws Exception {
		String result = "<ul>\n";
		for (int i = 0; i < wheel.size();i++){
			result += "<li>";
			result += wheel.get(i).accept(this);
			result += "</li>";
		}
		result += "</ul>\n";
		return result;
	}

	@Override
	public String visit(SimpleText engine) {
		String text = htmlize(engine.getText());
		
		if (engine.isStrikeThrough()){
			return "<strike>"+text+"</strike>";
		}
		return text;
	}

	@Override
	public String visit(TablePrinter simpleTable) throws Exception {
		if (simpleTable.getNumberOfRow()==0){
			return "";
		}
       String result = "<table border=\"1\" >\n";
		
		for (int i = 0; i < simpleTable.getNumberOfRow();i++){
			result += "<TR>";
			for (int j = 0; j < simpleTable.getMaxNumberOfCol();j++){
			  result += "<TD>";
			  result += printCell(simpleTable.getCell(i, j));
			  result += "</TD>";
			}
			result += "</TR>";
		}
		result += "</table>\n";
		return result;
	}
	
	private String printCell(CellPrinter c) throws Exception {
		return c.getContent().accept(this);
	}
	
	private String htmlize(String s){
		String result = s.replace("é", "&eacute;");
		result = result.replace("è", "&egrave;");
		result = result.replace("ê", "&ecirc;");
		result = result.replace("â", "&acirc;");
		return result;
		
	}

	@Override
	public String visit(BasicElementWithChildren s) throws Exception {
		 String result="";
		  if (s == null){throw new Exception("Sequence is null");}
		  for (int i = 0; i < s.size();i++){
			  
			  result += s.get(i).accept(this) +" ";
		  }
		  return result;
	}

	@Override
	public String visit(FixedSize fixedSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(SpecialSize specialSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(Section section) throws Exception {
		
		String result = "";
        result += "\n<h" + (this.sectionlevel+1) + ">"+ this.htmlize(section.getTitle()) + "</h"+ (this.sectionlevel+1) + ">";

		
		this.sectionlevel++;
		for (BasicElement e:section.getChildren()){
		  result += e.accept(this)+" ";
		}
		this.sectionlevel--;
		return result;
	
	
	}

	@Override
	public String visit(NewLine newLine) {

		return "<BR>";
	}

	@Override
	public String visit(NewPage newPage) {
		return "";
	}

	@Override
	public String visit(TableOfContent tableOfContent) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public String visit(Image image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(Quote quote) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(SimpleTable simpleTable) throws Exception {
	
		if (simpleTable.getNumberOfRow()==0){
			return "";
		}
       String result = "<table border=\"1\" >\n";
		
		for (int i = 0; i < simpleTable.getNumberOfRow();i++){
			result += "<TR>";
			for (int j = 0; j < simpleTable.getMaxNumberOfCol();j++){
			  result += "<TD>";
			  result += simpleTable.getCell(i, j).getContent().accept(this);
			  result += "</TD>";
			}
			result += "</TR>";
		}
		result += "</table>\n";
		return result;
	}

	

	@Override
	public String visit(Paragraph element) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(Box element) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
