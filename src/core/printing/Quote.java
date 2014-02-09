package core.printing;

import core.printing.visitor.PrintingVisitor;

public class Quote extends BasicElementWithChildren {

	
	BasicElementWithChildren content = new Sequence();
	public BasicElementWithChildren getContent() {
		return content;
	}

	public Quote() {
		super();
	}
	
	public Quote(String s) {
		
		
		super();
		SimpleText t = new SimpleText(s);
		try {
			this.getContent().add(t);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void add(BasicElement e) throws Exception {
		
		content.add(e);
		
	}

	@Override
	public boolean hasSection(String sectionTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
