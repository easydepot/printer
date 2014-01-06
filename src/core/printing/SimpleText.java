package core.printing;

import core.printing.visitor.PrintingVisitor;


public class SimpleText extends BasicElementImplementation{
	String text;
	boolean italic = false;
	boolean bold = false;
	boolean strikeTrough = false;
	String color;
	

	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isItalic() {
		return italic;
	}
	
	public boolean isStrikeThrough() {
		return strikeTrough;
	}
	
	public void setStrikeThough(){
		this.strikeTrough = true;
	}

	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	public boolean isBold() {
		return bold;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public SimpleText(String text) {
		super();
		this.text = text;
	}

	@Override
	public String accept(PrintingVisitor visitor) throws Exception {
		return visitor.visit(this);
	}

	@Override
	public boolean hasSection(String sectionTitle) {
		return false;
	}

	@Override
	public boolean hasText(String text) {
		
		return this.text.contains(text);
	}

	@Override
	public boolean isEmpty() {
		if (this.text.contentEquals("")){
			return true;
		}
		return false;
	}


	


	 
	 


	
	
	
	

}
