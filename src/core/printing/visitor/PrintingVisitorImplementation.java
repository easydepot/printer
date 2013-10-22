package core.printing.visitor;

import core.printing.BasicElementImplementation;
import core.printing.Section;
import core.printing.SimpleText;
import core.printing.table.SimpleTable;

public abstract class PrintingVisitorImplementation implements PrintingVisitor{

	@Override
	public String visit(BasicElementImplementation element) throws Exception {
		if (element.getClass().equals(SimpleText.class)){
			return visit((SimpleText) element);
		}
		if (element.getClass().equals(SimpleTable.class)){
			return visit((SimpleTable) element);
		}
		
		if (element.getClass().equals(Section.class)){
			return visit((Section) element);
		}
		throw new Exception("Class" + element.getClass().getName() + " is not handled");
	
		
		
	}

}
