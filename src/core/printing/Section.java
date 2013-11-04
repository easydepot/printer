package core.printing;

import core.printing.visitor.PrintingVisitor;

public class Section extends BasicElementWithChild {
	
	@Override
	public boolean hasSection(String sectionTitle) {
		if (this.title.equals(sectionTitle)){
			return true;
		}
		for (BasicElement e: this.children){
			if (e.hasSection(sectionTitle)){
				return true;
			}
		}
		return false;
	}






	String title;
	
	
	

	public SimpleText addText(String s) throws Exception {
		SimpleText result = new SimpleText(s);
		this.add(result);
		return result;
	}



	


	public Section addSection(String s) throws Exception {
		Section result = new Section(s);
		this.add(result);
		return result;
	}



	public Section(String title, Sequence content) {
		super();
		this.title = title;
		this.children.add(content);
	}



	public Section(String title) {
		super();
		this.title = title;
	}






	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}






	@Override
	public String accept(PrintingVisitor visitor) throws Exception {
		return visitor.visit(this);
	}







	



	

	

}
