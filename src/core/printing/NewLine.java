package core.printing;

import core.printing.visitor.PrintingVisitor;

public class NewLine  extends TokenElement  {

	@Override
	public String accept(PrintingVisitor visitor) {
		  return visitor.visit(this);
	}

	



	




}
