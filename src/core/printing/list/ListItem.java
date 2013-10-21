package core.printing.list;

import java.util.Vector;

import core.printing.BasicElement;
import core.printing.BasicElementWithChild;
import core.printing.Sequence;
import core.printing.SimpleText;
import core.printing.visitor.PrintingVisitor;

public class ListItem implements BasicElementWithChild{
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

public String accept(PrintingVisitor visitor)
   {
       return visitor.visit(this);
   }



@Override
public void add(BasicElement e) throws Exception {
  this.addItem(e);	
}




}
