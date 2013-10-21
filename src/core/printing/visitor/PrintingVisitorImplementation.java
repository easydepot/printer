package core.printing.visitor;

import core.printing.BasicElementImplementation;
import core.printing.SimpleText;
import core.printing.table.SimpleTable;

public abstract class PrintingVisitorImplementation implements PrintingVisitor{

	@Override
	public String visit(BasicElementImplementation element) {
		if (element.getClass().equals(SimpleText.class)){
			visit((SimpleText) element);
		}
		if (element.getClass().equals(SimpleTable.class)){
			visit((SimpleTable) element);
		}
	
		
		return null;
	}

}
