package core.printing.table;

import java.util.ArrayList;
import java.util.Vector;

import core.printing.BasicElement;
import core.printing.table.alignment.ClassicAlignement;
import core.printing.table.alignment.ClassicAlignement.ALIGN;
import core.printing.table.alignment.SizedAlignement;
import core.printing.table.alignment.TableAlignement;
import core.printing.table.size.FixedSize;
import core.printing.table.size.SpecialSize;
import core.printing.table.size.TableSize;
import core.printing.visitor.PrintingVisitor;

public class TablePrinter extends SimpleTable implements BasicElement{
	
	// Table Format
	TableSize size = new SpecialSize("linewidth");
	ArrayList<TableAlignement> listOfAlignements = new ArrayList<TableAlignement>();
	boolean longtable = false;
	boolean hasHeader =false;

	public boolean isLongtable() {
		return longtable;
	}



	public void setLongtable(boolean longtable) {
		this.longtable = longtable;
	}

	// table content
	
   
    
  
  public TablePrinter() {
	super();
	//this.newline();
}
  
  public boolean addAlignementSize(int size) {
		return listOfAlignements.add(new SizedAlignement(size));
	} 
  
  

public boolean addAlignement(TableAlignement e) {
	return listOfAlignements.add(e);
}

public boolean addAlignementLeft() {
  return addAlignement(new ClassicAlignement(ALIGN.LEFT));
}

public boolean addAlignementCenter() {
	return addAlignement(new ClassicAlignement(ALIGN.CENTER));
}

public boolean addAlignementRight() {
	return addAlignement(new ClassicAlignement(ALIGN.RIGHT));
}

public boolean addAlignementExtend() {
	return addAlignement(new ClassicAlignement(ALIGN.EXTEND));
}


public TableAlignement getAlignement(int i) {
	if (0 == listOfAlignements.size()){
		return null;
	} else {
	  return listOfAlignements.get(i);
	}
}






public boolean hasHeader() {
	return hasHeader;
}

public void setHeader() {
	this.hasHeader = true;
}

public void removeHeader() {
	this.hasHeader = true;
}

  
 

  

  
  
  public void addHeader(String h) throws Exception{
	  this.hasHeader = true;
	  this.addCell(h);
  }
  
  
  
  
 
  
  public void addCell(String cellPrinter) throws Exception{
	  createFirstLineIfFirstCell(); 
	  checkLineLengthAndThrowException(cellPrinter);
	  currentline.addCell(cellPrinter);
  }



private void checkLineLengthAndThrowException(String cellPrinter)
		throws Exception {
	if (isOutOfBoundCellAdding()){
		  throw new Exception("Can't add cell " + cellPrinter +": maximum number of cell per line is reached");
	  }
}



protected boolean isOutOfBoundCellAdding() {
	return this.getNumberOfRow()!=1 && this.getNumberOfCellsCurrentline()==this.getMaxNumberOfCol();
}



private void createFirstLineIfFirstCell() {
	if (currentline==null){
		  this.newline();
	  }
}
  
  
  
public int getMaxNumberOfCol() {
	if (this.listOfAlignements.isEmpty()){
	  return getNumberOfColsWhenNoAlignementDefined();
	}
	else {
		return this.listOfAlignements.size();
	}
}



private int getNumberOfColsWhenNoAlignementDefined() {
	if (this.getNumberOfRow()==0){
	  	return -1;
	  } else {
	      return this.lines.get(0).getNumberOfCells();
	  }
}

public TableSize getSize() {
	return size;
}

public void setSize(int size) {
	this.size = new FixedSize(size);
}

public void setSize(String size) {
	this.size = new SpecialSize(size);
}

@Override
public String accept(PrintingVisitor visitor) throws Exception {
	return visitor.visit(this);
}
  
}
