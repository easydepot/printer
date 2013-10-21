package core.printing.table;

import core.printing.table.TablePrinter;
import core.printing.table.alignment.ClassicAlignement;
import core.printing.table.alignment.ClassicAlignement.ALIGN;

public class TestTableUtil {
	
	public static core.printing.table.TablePrinter givenATableWithAlignement() {
		core.printing.table.TablePrinter t = new TablePrinter();
		  t.addAlignement(new ClassicAlignement(ALIGN.CENTER));
		return t;
	}

}
