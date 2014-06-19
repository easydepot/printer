package core.printer.helper;

public class StringReplace {
	String input;
	
	

	public StringReplace(String input) {
		super();
		this.input = input;
	}
	
	public void replace(String oldText,String newText){
		this.input = this.input.replace(oldText, newText);
	}

	public String getResult() {
		return input;
	}
	
	
	
	
	
	
	
	
	

}
