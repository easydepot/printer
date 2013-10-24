package core.printing;

import java.util.Iterator;

import core.printing.visitor.PrintingVisitor;

public class Sequence extends BasicElementWithChild {
	
	
	public BasicElement get(int index) {
		return children.get(index);
	}

	

	public int size() {
		return children.size();
	}

	
	
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



	


}
