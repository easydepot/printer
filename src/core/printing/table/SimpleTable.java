package core.printing.table;

import java.util.Vector;

import core.printing.BasicElement;
import core.printing.visitor.PrintingVisitor;

public class SimpleTable implements BasicElement {
	
	Vector<LinePrinter> lines = new Vector<LinePrinter>();
	LinePrinter currentline;


	public SimpleTable() {
		super();
	}

	public int getNumberOfCellsCurrentline() {
		return currentline.getNumberOfCells();
	}

	public int getNumberOfRow() {
		return this.lines.size();
	}

	void addLine(LinePrinter l) {
		  lines.add(l);
	  }

	public String accept(PrintingVisitor visitor) {
	      return visitor.visit(this);
	  }

	@Override
	public void add(BasicElement e) {
		this.currentline.addCell(new CellPrinter(e));
		
	}

	
	public void newline(){
		  currentline = new LinePrinter();
		  this.lines.add(currentline);
	  }

	  
	  public CellPrinter getLastElement() {
	  	return currentline.getLastElement();
	  }

	  public CellPrinter getCell(int row,int col){
	  	  return this.lines.get(row).cells.get(col);
	  }
	  	  
}