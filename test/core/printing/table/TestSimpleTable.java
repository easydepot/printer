package core.printing.table;



import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import core.printing.SimpleText;

public class TestSimpleTable {
	
	SimpleTable sut = new SimpleTable();;

	
	@Test
	public void test_that_initial_number_of_row_is_zero() {
		Assert.assertEquals(0, sut.getNumberOfRow());
	}
	
	@Test
	public void test_that_first_addCell_does_not_need_a_call_to_newline() {
		sut.addCell(new CellPrinter("text1"));
	}
	
	@Test
	public void test_that_first_add_does_not_need_a_call_to_newline() {
		sut.add(new SimpleText("text1"));
	}
	
	@Test
	public void test_that_getMaxNumberOfCol_returns_first_line_number_of_col(){
		
		sut.add(new SimpleText("text1"));
		sut.add(new SimpleText("text1"));
		sut.newline();
		sut.add(new SimpleText("text1"));
		Assert.assertEquals(2, sut.getMaxNumberOfCol());
	}
	

	@Test
	public void test_newLine() {
		sut.newline();
		Assert.assertEquals(1, sut.getNumberOfRow());
	}
	
	@Test
	public void test_addline() {
		LinePrinter l = new LinePrinter();
		sut.addLine(l);
		Assert.assertEquals(l, sut.lines.get(0));
	}
	
	@Test
	public void test_getNumberOfCellsCurrentline_return_zero_when_nothing_defined() {
		Assert.assertEquals(0, sut.getNumberOfCellsCurrentline());
	}
	
	@Test
	public void test_getNumberOfCellsCurrentline_return_numberofcell_when_at_least_one_line_is_defined() {
		sut.newline();
		sut.add(new SimpleText("val1"));
		Assert.assertEquals(1, sut.getNumberOfCellsCurrentline());
	}
	
	@Test
	public void test_getLastElement_return_last_inserted_element() {
		sut.newline();
		SimpleText p = new SimpleText("text1");
		sut.add(p);
		Assert.assertEquals(p, sut.getLastElement());
	}
	
	@Test
	public void test_getCell_throws_an_exception_when_the_cell_does_not_exists_case_second_row() {
		sut.newline();
		sut.add(new SimpleText("text1"));
		try {
			sut.getCell(1, 0);
			fail("must throw an exception");
		} catch (Exception e) {
			

		}
		
	}
	
	@Test
	public void test_addStringContent() throws Exception {
		sut.newline();
		String e = "text1";
		sut.add(e);
		Assert.assertEquals(e, ((SimpleText)sut.getCellContent(0, 0)).getText());
			
		
	}
	
	@Test
	public void test_getCell_positive_case() throws Exception {
		sut.newline();
		SimpleText e = new SimpleText("text1");
		sut.add(e);
		Assert.assertEquals(e, sut.getCellContent(0, 0));
			
		
	}
	
	@Test
	public void test_addCell_positive_case() throws Exception {
		sut.newline();
		CellPrinter e = new CellPrinter("text1");
		sut.addCell(e);
		Assert.assertEquals(e, sut.getCell(0, 0));
			
		
	}
	
	@Test
	public void test_getCell_throws_an_exception_when_the_cell_does_not_exists_case_out_of_line() {
		sut.newline();
		sut.add(new SimpleText("text1"));
		try {
			sut.getCell(0, 1);
			fail("must throw an exception");
		} catch (Exception e) {
			

		}
		
	}
	
	@Test
	public void test_getCell_throws_an_exception_when_the_cell_does_not_exists() {
		try {
			sut.getCell(0, 0);
			fail("must throw an exception");
		} catch (Exception e) {
			

		}
		
	}

}
