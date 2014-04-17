package core.printing;

import core.printing.visitor.PrintingVisitor;

public class Box extends BasicElementWithChildren {
	String title;
	public Box(BasicElement content, String title) {
		super();
		this.children.add(content);
		this.title = title;
	}
	public Box(BasicElement content) {
		super();
		this.children.add(content);
	}
	
	public Box(Sequence content) {
		super();
		this.children.add(content);
	}
	public Box() {
		super();
		
	}
	public String getTitle() {
		return title;
	}
	@Override
	public String accept(PrintingVisitor visitor) throws Exception {
	
		return visitor.visit(this);
	}
	
	//@deprecated
	public BasicElement getContent() {
		return this.getChildren().get(0);
	}

	
	

}
