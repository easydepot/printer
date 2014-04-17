package core.printing.list;

import java.util.Vector;

import core.printing.BasicElement;
import core.printing.BasicElementWithChildren;
import core.printing.Sequence;
import core.printing.SimpleText;
import core.printing.visitor.PrintingVisitor;

public class ListItem extends BasicElementWithChildren{
   Vector<Sequence> itemPrint = new Vector<Sequence>();
   
   public void addItem(String t) throws Exception{
	 
	   SimpleText tmp = new SimpleText(t);
	   this.addItem(tmp);
	   
   }
   
   
   
   public void addItem(BasicElement t) throws Exception{
	   Sequence s = new Sequence();
	   s.add(t);
	   this.itemPrint.add(s);
	   
   }
   
   public void continueItem(BasicElement t) throws Exception{
	   if (this.itemPrint.size() == 0){
		   this.addItem(t);
	   } else {
	     this.itemPrint.get(this.itemPrint.size()-1).add(t);
	   }
   }
   
   public BasicElement get(int i){
	   return this.itemPrint.get(i);
   }
   
   
   public int size() {
	return itemPrint.size();
}

public String accept(PrintingVisitor visitor) throws Exception
   {
       return visitor.visit(this);
   }



@Override
public void add(BasicElement e) throws Exception {
  this.addItem(e);	
}



@Override
public boolean hasSection(String sectionTitle) {
	
	return false;
}



public SimpleText addText(String text) throws Exception {
	SimpleText s = new SimpleText(text);
	this.addItem(s);
	return s;
	
}








}
