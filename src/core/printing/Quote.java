package core.printing;

import core.printing.visitor.PrintingVisitor;

public class Quote extends BasicElementWithChild {

	
	Sequence content = new Sequence();
	public Sequence getContent() {
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

	

	

}
