package core.printing.table;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLinePrinter {

	@Test
	public void test_addCell() {
		LinePrinter sut = new LinePrinter();
		CellPrinter c = new CellPrinter("val1");
		sut.addCell(c);
		assertEquals(c, sut.getLastElement());
	}

}
