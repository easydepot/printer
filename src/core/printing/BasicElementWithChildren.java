package core.printing;

import java.util.ArrayList;

import core.printing.visitor.PrintingVisitor;

public abstract class BasicElementWithChildren extends BasicElementImplementation{
	
	
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

	public BasicElement get(int index) {
		return children.get(index);
	}

	public int size() {
		return children.size();
	}

	@Override
	public boolean isEmpty() {
		for (BasicElement e: this.children){
			if (!e.isEmpty()){return false;}
		}
		return true;
	}
	@Override
	public boolean hasSection(String sectionTitle) {
		for (BasicElement e: this.children){
			if (e.hasSection(sectionTitle)){
				return true;
			}
		}
		return false;
	}
	


}
