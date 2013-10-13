package core.printing;

import core.printing.visitor.PrintingVisitor;

public interface BasicElement {
	
	  public String accept(PrintingVisitor visitor);
	  
	  void add(BasicElement e) throws Exception;


	
	 
  
}
