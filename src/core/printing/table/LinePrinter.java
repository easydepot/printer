package core.printing.table;

import java.util.Vector;


public class LinePrinter {
  Vector<CellPrinter> cells = new Vector<CellPrinter>();
  
  public void addCell(String s){
	  this.cells.add(new CellPrinter(s));
  }
  
  public void addCell(CellPrinter c){
	  this.cells.add(c);
  }
  
  public CellPrinter getLastElement(){
	 return this.cells.get(cells.size()-1);
  }

public int getNumberOfCells() {
	return cells.size();
}
  
  
  
}
