package core.printing.table;

import java.util.Vector;

import core.printing.BasicElement;
import core.printing.BasicElementImplementation;
import core.printing.BasicElementWithChild;

public class SimpleTable extends BasicElementImplementation implements BasicElementWithChild {
	
	Vector<LinePrinter> lines = new Vector<LinePrinter>();
	LinePrinter currentline;


	public SimpleTable() {
		super();
	}

	public int getNumberOfCellsCurrentline() {
		if (this.currentline ==null){return 0;}
		return currentline.getNumberOfCells();
	}

	public int getNumberOfRow() {
		return this.lines.size();
	}

	void addLine(LinePrinter l) {
		  lines.add(l);
	  }



	@Override
	public void add(BasicElement e) {
		this.currentline.addCell(new CellPrinter(e));
		
	}
	
	

	
	public void newline(){
		  currentline = new LinePrinter();
		  this.lines.add(currentline);
	  }

	  
	  public BasicElement getLastElement() {
	  	return currentline.getLastElement().getContent();
	  }

	  public BasicElement getCellContent(int row,int col) throws Exception{
		  throwAnExceptionIfRowGreaterThanTableLength(row);
		  
	  	  return this.getCell(row, col).getContent();
	  }
	  
	  public CellPrinter getCell(int row,int col) throws Exception{
		  throwAnExceptionIfRowGreaterThanTableLength(row);
		  
	  	  return this.lines.get(row).cells.get(col);
	  }

	private void throwAnExceptionIfRowGreaterThanTableLength(int row)
			throws Exception {
		if (row >= this.lines.size()){
			  throw new Exception("Row " + row + "is not defined" );
		  }
	}
	  	  
}