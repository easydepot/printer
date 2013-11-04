package core.printing;

import java.util.ArrayList;

import core.printing.visitor.PrintingVisitor;

public abstract class BasicElementWithChild extends BasicElementImplementation{
	
	
	protected ArrayList<BasicElement> children = new ArrayList<BasicElement>();
	
	public ArrayList<BasicElement> getChildren() {
		return children;
	}

	public void add(BasicElement e) throws Exception{
		
			if (e==null){throw new Exception("Try to add a Null element");}
			children.add(e);
		
	}
	
	@Override
	public String accept(PrintingVisitor visitor) throws Exception {
		String result_children_visit = "";
		for (BasicElement e:children){
			result_children_visit += e.accept(visitor)+ " ";
		}
		return result_children_visit;
	}

	public boolean hasChildren() {
		return getChildren().size()!=0;
	}
	
	@Override
	public boolean hasText(String text) {
		for (BasicElement child: this.children){
			if (child.hasText(text)){
				return true;
			}
		}
		return false;
	}

	


}
