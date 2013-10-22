package core.printing.table;

import java.awt.Color;

import core.printing.BasicElement;
import core.printing.SimpleText;
import core.printing.table.alignment.ClassicAlignement;

public class CellPrinter {
  private BasicElement content;
  private int colspan = 0;
  private ClassicAlignement.ALIGN colspantype = ClassicAlignement.ALIGN.CENTER;
  private Color color = Color.WHITE;
  
  

public BasicElement getContent() {
	return content;
}

public void setContent(BasicElement content) {
	this.content = content;
}

public Color getColor() {
	return color;
}

public void setColor(Color color) {
	this.color = color;
}

public int getColspan() {
	return colspan;
}

public void setColspan(int colspan) {
	this.colspan = colspan;
}

public ClassicAlignement.ALIGN  getColspantype() {
	return colspantype;
}

public void setColspantype(ClassicAlignement.ALIGN  colspantype) {
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
  

  
}
