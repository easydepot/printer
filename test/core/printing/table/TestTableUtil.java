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
	
	public static core.printing.table.TablePrinter givenATableWithTwoCellAlignement() {
		TablePrinter t = givenATableWithAlignement();
		 t.addAlignement(new ClassicAlignement(ALIGN.CENTER));
		return t;
	}
	
	public static SimpleTable givenATableWithOneLineofTwoCellandOneLineOfOneCell() throws Exception{
		SimpleTable t = new SimpleTable();
		t.newline();
		t.lines.get(0).addCell("value1");
		t.lines.get(0).addCell("value2");
		t.newline();
		t.lines.get(1).addCell("v1");
		return t;
	}
	
	public static SimpleTable givenATableWithTwoLinesofTwoCells() throws Exception{
		SimpleTable t = new SimpleTable();
		t.newline();
		t.lines.get(0).addCell("value1");
		t.lines.get(0).addCell("value2");
		t.newline();
		t.lines.get(1).addCell("v1");
		t.lines.get(1).addCell("v2");
		return t;
	}
	
	
	public static SimpleTable givenATableWithOneLine()
			throws Exception {
		SimpleTable t = new SimpleTable();

		t.newline();
		t.lines.get(0).addCell("value1");
		t.lines.get(0).addCell("value2");
		return t;
	}

}
