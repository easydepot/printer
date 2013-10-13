package core.printing.visitor;

import core.printing.Image;
import core.printing.NewLine;
import core.printing.NewPage;
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
	
	
	    String visit(SimpleTable simpleTable);
	    String visit(ListItem listPrint);
	    String visit(SimpleText engine);
	    String visit(TablePrinter body);
	    String visit(Sequence body);
		String visit(FixedSize fixedSize);
		String visit(SpecialSize specialSize);
		String visit(Section section);
		String visit(NewLine newLine);
		String visit(NewPage newPage);
		String visit(TableOfContent tableOfContent);
		String visit(Image image);
		String visit(Quote quote);
	

}
