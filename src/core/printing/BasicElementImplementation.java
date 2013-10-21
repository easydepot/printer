package core.printing;

import core.printing.visitor.PrintingVisitor;

public abstract class BasicElementImplementation implements BasicElement {

	@Override
	public String accept(PrintingVisitor visitor) {
		 return visitor.visit(this);
	}
	
	

}
