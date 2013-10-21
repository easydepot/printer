package core.printing.table;

import static org.junit.Assert.fail;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


import core.printing.table.TablePrinter;

public class TestTable extends TestSimpleTable{
	

	TablePrinter sut;
	
	@Before
	public void setUp() throws Exception {
		sut = new TablePrinter();
	}

	
	
	
	
	@Test
	public void test_addHeader_create_a_cell() throws Exception {
		sut.addHeader("value1");
		Assert.assertEquals(1, sut.getNumberOfRow());
		Assert.assertEquals(1, sut.getMaxNumberOfCol());
		Assert.assertEquals(true, sut.hasHeader());
	}
	
	@Test
	public void test_addCell_create_a_cell() throws Exception {
		sut.addCell("value1");
		Assert.assertEquals(1, sut.getNumberOfRow());
		Assert.assertEquals(1, sut.getMaxNumberOfCol());
		Assert.assertEquals(false, sut.hasHeader());
	}
	
	@Test 
	public void test_that_getNumberOfCol_returns_number_of_alignement_when_alignement_defined(){
		  core.printing.table.TablePrinter t = TestTableUtil.givenATableWithAlignement();
		  Assert.assertEquals(1, t.getMaxNumberOfCol());

	}
	
	@Test 
	public void test_that_getMaxNumberOfCol_is_not_defined_when_emptyTablePrinter(){
		  core.printing.table.TablePrinter t = new TablePrinter();
		  Assert.assertEquals(-1, t.getMaxNumberOfCol());

	}
	
	@Test 
	public void test_that_getMaxNumberOfCol_is_defined_when_table_with_alignement_defined(){
		  core.printing.table.TablePrinter t = TestTableUtil.givenATableWithAlignement();
		  Assert.assertEquals(1, t.getMaxNumberOfCol());

	}
	
	@Test
	public void test_addCell_fails_when_too_much_cells_are_added() throws Exception {
		sut.addCell("value1");
		sut.addCell("value2");
		sut.newline();
		sut.addCell("v1");
		sut.addCell("v2");
		try {
			sut.addCell("v3");
			fail("must fail on adding too much cell on the line");
		} catch (Exception e) {
			
		}
	}

}
