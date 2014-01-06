package core.printing;

import core.printing.visitor.PrintingVisitor;

public class Box extends BasicElementWithChild {
	String title;
	public Box(BasicElement content, String title) {
		super();
		this.content = content;
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	@Override
	public String accept(PrintingVisitor visitor) throws Exception {
	
		return visitor.visit(this);
	}
	
	

}
