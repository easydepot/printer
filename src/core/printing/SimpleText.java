package core.printing;


public class SimpleText extends BasicElementImplementation{
	String text;
	boolean italic = false;
	boolean bold = false;
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



	


	 
	 


	
	
	
	

}
