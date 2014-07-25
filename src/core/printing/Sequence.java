package core.printing;

import java.util.Iterator;

import core.printing.visitor.PrintingVisitor;

public class Sequence extends BasicElementWithChildren {
	
	
	public SimpleText addText(String s) throws Exception{
		 SimpleText res = new SimpleText(s);
		 this.add(res);
		 return res;
	}
	
	public void newLine() throws Exception{
		 this.add(new NewLine());
	}
	
	public SimpleText addTextNL(String s) throws Exception{
		 SimpleText res =this.addText(s);
		 newLine();
		 return res;
	}
	
	public Section addSection(String s){
		Section result = new Section(s);
		children.add(result);
		return result;
	}

	@Override
	public String getText() {
		String result = "";
		for (BasicElement e:this.children){
			result += e.getText();
		}
		return result;
	}



	



	


}
