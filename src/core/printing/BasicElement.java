package core.printing;

import core.printing.visitor.PrintingVisitor;

public interface BasicElement {
	
	  public String accept(PrintingVisitor visitor) throws Exception;

	public boolean hasSection(String sectionTitle);
	public boolean hasText(String text);
	public boolean isEmpty();
	  


	
	 
  
}
