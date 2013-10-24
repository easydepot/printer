package core.printing;

import core.printing.visitor.PrintingVisitor;

public abstract class BasicElementImplementation implements BasicElement {

	public abstract String accept(PrintingVisitor visitor) throws Exception;
}
