package core.printing;

import java.util.Iterator;
import java.util.Vector;

import core.printing.visitor.PrintingVisitor;

public class Sequence implements BasicElement {
	
	
	Vector<BasicElement> v = new Vector<BasicElement>();
	
	

	public BasicElement get(int index) {
		return v.get(index);
	}

	public Iterator<BasicElement> iterator() {
		return v.iterator();
	}

	public int size() {
		return v.size();
	}

	public void add(BasicElement e) throws Exception {
		if (e==null){throw new Exception("Try to add a Null element");}
		v.add(e);
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
		v.add(result);
		return result;
	}



	@Override
	public String accept(PrintingVisitor visitor) {
		
		
		return visitor.visit(this);
	}



}
