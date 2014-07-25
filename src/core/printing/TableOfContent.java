package core.printing;

import core.printing.visitor.PrintingVisitor;

public class TableOfContent  extends TokenElement {

	@Override
	public String accept(PrintingVisitor visitor) {
		  return visitor.visit(this);
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return "";
	}



	

	




}
