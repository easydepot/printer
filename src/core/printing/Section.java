package core.printing;

import core.printing.visitor.PrintingVisitor;

public class Section extends BasicElementWithChild {
	
	String title;
	Sequence content = new Sequence();
	
	
	

	public SimpleText addText(String s) throws Exception {
		return content.addText(s);
	}



	public Sequence getContent() {
		return content;
	}



	public void setContent(Sequence content) {
		this.content = content;
	}



	public Section addSection(String s) {
		return content.addSection(s);
	}



	public Section(String title, Sequence content) {
		super();
		this.title = title;
		this.content = content;
	}



	public Section(String title) {
		super();
		this.title = title;
	}



	public void add(BasicElement e) throws Exception {
		content.add(e);
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}







	



	

	

}
