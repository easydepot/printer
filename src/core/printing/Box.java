package core.printing;

import core.printing.visitor.PrintingVisitor;

public class Box extends BasicElementImplementation {
	BasicElement content;
	String title;
	public Box(BasicElement content, String title) {
		super();
		this.content = content;
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public BasicElement getContent() {
		return this.content;
	}
	@Override
	public String accept(PrintingVisitor visitor) throws Exception {
	
		return visitor.visit(this);
	}
	@Override
	public boolean hasSection(String sectionTitle) {
		return this.content.hasSection(sectionTitle);
	}
	@Override
	public boolean hasText(String text) {
		
		return content.hasText(text);
	}
	
	

}
