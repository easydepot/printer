package core.printing.visitor;

import core.printing.BasicElementImplementation;
import core.printing.Image;
import core.printing.NewLine;
import core.printing.NewPage;
import core.printing.Paragraph;
import core.printing.Quote;
import core.printing.Section;
import core.printing.Sequence;
import core.printing.SimpleText;
import core.printing.TableOfContent;
import core.printing.list.ListItem;
import core.printing.table.SimpleTable;
import core.printing.table.TablePrinter;
import core.printing.table.size.FixedSize;
import core.printing.table.size.SpecialSize;

public interface PrintingVisitor {
	
	
	    String visit(SimpleTable simpleTable) throws Exception;
	    String visit(ListItem listPrint) throws Exception;
	    String visit(SimpleText engine) throws Exception;
	    String visit(TablePrinter body) throws Exception;
	    String visit(Sequence body) throws Exception;
		String visit(FixedSize fixedSize);
		String visit(SpecialSize specialSize);
		String visit(Section section) throws Exception;
		String visit(NewLine newLine);
		String visit(NewPage newPage);
		String visit(TableOfContent tableOfContent);
		String visit(Image image);
		String visit(Quote quote) throws Exception;
		String visit(BasicElementImplementation element) throws Exception;
		String visit(Paragraph element) throws Exception;
	

}
