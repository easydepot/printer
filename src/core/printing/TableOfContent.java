package core.printing;

import core.printing.visitor.PrintingVisitor;

public class TableOfContent  implements BasicElement  {

	@Override
	public String accept(PrintingVisitor visitor) {
		  return visitor.visit(this);
	}

	@Override
	public boolean hasSection(String sectionTitle) {
		return false;
	}

	@Override
	public boolean hasText(String text) {
		// TODO Auto-generated method stub
		return false;
	}

	

	




}
