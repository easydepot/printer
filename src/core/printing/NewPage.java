package core.printing;

import core.printing.visitor.PrintingVisitor;

public class NewPage  extends TokenElement  {

	@Override
	public String accept(PrintingVisitor visitor) {
		  return visitor.visit(this);
	}

	

	public void newline() {
	}



	





}
