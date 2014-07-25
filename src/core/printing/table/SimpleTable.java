package core.printing.table;

import java.util.Vector;

import core.printing.BasicElement;
import core.printing.BasicElementWithChildren;
import core.printing.SimpleText;
import core.printing.visitor.PrintingVisitor;

public class SimpleTable extends BasicElementWithChildren  {
	
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



	public void add(BasicElement e) {
		this.addCell(new CellPrinter(e));
		
	}
	
	 public void addCell(CellPrinter cellPrinter){
		  if (currentline==null){
			  this.newline();
		  }
		  currentline.addCell(cellPrinter);
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

	public void add(String e) {
	  SimpleText element = new SimpleText(e);
	  this.add(element);
		
	}

	public int getMaxNumberOfCol() {
		if (isEmpty()) {return 0;}
		return this.lines.get(0).getNumberOfCells();
	}

	public boolean isEmpty() {
		return this.lines.size()==0;
	}
	
	@Override
	public String accept(PrintingVisitor visitor) throws Exception {
		return visitor.visit(this);
	}

	@Override
	public boolean hasSection(String sectionTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "";
	}
	  	  
}