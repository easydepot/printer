package core.printing.table;

import core.printing.BasicElement;
import core.printing.SimpleText;

public class CellPrinter {
  BasicElement content;
  int colspan = 0;
  String colspantype = "c";
  String color;
  
  

public BasicElement getContent() {
	return content;
}

public void setContent(BasicElement content) {
	this.content = content;
}

public String getColor() {
	return color;
}

public void setColor(String color) {
	this.color = color;
}

public int getColspan() {
	return colspan;
}

public void setColspan(int colspan) {
	this.colspan = colspan;
}

public String getColspantype() {
	return colspantype;
}

public void setColspantype(String colspantype) {
	this.colspantype = colspantype;
}

public CellPrinter(String content) {
	super();
	this.content = new SimpleText(content);
}

public CellPrinter(BasicElement content) {
	super();
	this.content = content;
}
  
  public BasicElement getText(){
	  return content;
  }
  
}
