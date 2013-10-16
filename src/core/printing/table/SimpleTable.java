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
		if (this.currentline==null){return 0;}
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
	public void add(BasicElement e) throws Exception {
		 CellPrinter cell = new CellPrinter(e);
		 addCell(cell);
		
	}
	
	 public void addCell(CellPrinter cellPrinter) throws Exception{
		   createFirstLineIfFirstCell(); 
		  checkLineLengthAndThrowException(cellPrinter);
		  currentline.addCell(cellPrinter);
	  }
	 
	
	private void checkLineLengthAndThrowException(CellPrinter cellPrinter)
				throws Exception {
			if (isOutOfBoundCellAdding()){
				  throw new Exception("Can't add cell " + cellPrinter +": maximum number of cell per line is reached");
			  }
		}
	  
	  public void addCell(String cellPrinter) throws Exception{
		  CellPrinter cell = new CellPrinter(cellPrinter);
		  addCell(cell);
	  }
	  

	  protected boolean isOutOfBoundCellAdding() {
			if (this.getNumberOfRow()==0||this.getNumberOfRow()==1){return false;}
			return this.getNumberOfCellsCurrentline()>=this.getMaxNumberOfCol();
		}
	  
	  
	  public int getMaxNumberOfCol() {
		 if (this.lines.size()==0){
			 return 0;  
		 } else {
			 return this.lines.get(0).getNumberOfCells();
		 }
	  }


		private void createFirstLineIfFirstCell() {
			if (currentline==null){
				  this.newline();
			  }
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