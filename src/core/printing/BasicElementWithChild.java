package core.printing;

import core.printing.visitor.PrintingVisitor;

public abstract class BasicElementWithChild implements BasicElement {

	protected BasicElement content;

	@Override
	public abstract String accept(PrintingVisitor visitor) throws Exception ;

	

	public BasicElement getContent() {
		return this.content;
	}

	@Override
	public boolean hasSection(String sectionTitle) {
		return this.content.hasSection(sectionTitle);
	}

	@Override
	public boolean hasText(String text) {
		
		return content.hasText(text);
	}

	@Override
	public boolean isEmpty() {
		return this.getContent().isEmpty();
	}

}
