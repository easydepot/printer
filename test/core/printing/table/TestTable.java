package core.printing.table;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	public void test_Table_alignement_centered_one_columns_addOneCellMore() throws Exception {
	  core.printing.table.TablePrinter t = TestTableUtil.givenATableWithAlignement();
	  t.addCell("h1");
	  try {
		  t.addCell("h2");
		  fail("SHALL throw an exception");
	  }
	  catch (Exception e){
		  
	  }
	}
	
	@Test
	public void test_Table_alignement_centered_one_columns_assertthat_getMaxNumberOfCol_is_alignement_size() throws Exception {
	  core.printing.table.TablePrinter t = TestTableUtil.givenATableWithAlignement();
	  Assert.assertEquals(1, t.getMaxNumberOfCol());
	}
	
	@Test
	public void test_that_givenTable_alignement_centered_one_columns_assertthat_isOutofBound_returns_false() throws Exception {
	  core.printing.table.TablePrinter t = TestTableUtil.givenATableWithAlignement();
	  Assert.assertFalse(t.isOutOfBoundCellAdding());
	}
	
	@Test
	public void test_that_givenTable_alignement_centered_one_columns_assertthat_isOutofBound_returns_true() throws Exception {
	  core.printing.table.TablePrinter t = TestTableUtil.givenATableWithAlignement();
	  t.addCell("cell1");
	  Assert.assertTrue(t.isOutOfBoundCellAdding());
	}
	
	
	
	@Test
	public void test_that_isOutOfBoundCellAdding_returns_false_when_table_is_empty() throws Exception {
	  core.printing.table.TablePrinter t = new TablePrinter();
	  Assert.assertFalse(t.isOutOfBoundCellAdding());
	 
	
	}
	
	@Test
	public void test_when_givenATableWithtwoCellAlignement_that_getMaxNumberOfCol_returns_alignement_size() throws Exception {
	  core.printing.table.TablePrinter t = TestTableUtil.givenATableWithTwoCellAlignement();
	  Assert.assertEquals(2, t.getMaxNumberOfCol());
	}
	
	@Test
	public void test_that_getNumberOfCellsCurrentline_returns_zero_when_table_empty() throws Exception {
	  core.printing.table.TablePrinter t = new TablePrinter();
	  Assert.assertEquals(0, t.getNumberOfCellsCurrentline());
	 
	
	}
	
	@Test
	public void test_that_getNumberOfCellsCurrentline_returns_one_when_firstline_has_one_cell() throws Exception {
	  core.printing.table.TablePrinter t = new TablePrinter();
	  t.addCell("cell1");
	  Assert.assertEquals(1, t.getNumberOfCellsCurrentline());
	 
	
	}
	
	@Test
	public void test_that_gisOutOfBoundCellAdding_returns_false_when_firstline_has_one_cell() throws Exception {
	  core.printing.table.TablePrinter t = new TablePrinter();
	  t.addCell("cell1");
	  Assert.assertEquals(false, t.isOutOfBoundCellAdding());
	 
	
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
		  Assert.assertEquals(0, t.getMaxNumberOfCol());

	}
	
	@Test 
	public void test_that_getMaxNumberOfCol_is_defined_when_table_with_alignement_defined(){
		  core.printing.table.TablePrinter t = TestTableUtil.givenATableWithAlignement();
		  Assert.assertEquals(1, t.getMaxNumberOfCol());

	}
	
	

}
