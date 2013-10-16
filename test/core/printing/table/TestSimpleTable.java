package core.printing.table;

 

import static org.junit.Assert.fail;

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
	public void test_newLine() {
		sut.newline();
		Assert.assertEquals(1, sut.getNumberOfRow());
	}
	
	@Test
	public void test_addCell() throws Exception {
		
		sut.add(new SimpleText("truc"));
		Assert.assertEquals(1, sut.getNumberOfRow());
	}
	
	@Test
	public void test_that_getNumberOfCellsCurrentline_returns_one_when_firstline_has_two_cells_and_the_second_has_one_cell() throws Exception {
		SimpleTable t = TestTableUtil.givenATableWithOneLine();
	  t.newline();
	  t.addCell("cellline2");
	  Assert.assertEquals(1, t.getNumberOfCellsCurrentline());
	 
	
	}
	
	@Test
	public void test_that_getNumberOfCellsCurrentline_returns_two_when_firstline_has_two_cell() throws Exception {
		SimpleTable t = TestTableUtil.givenATableWithOneLine();
	  Assert.assertEquals(2, t.getNumberOfCellsCurrentline());
	 
	
	}
	
	@Test
	public void test_that_getNumberOfCellsCurrentline_returns_zero_when_firstline_has_two_cells_and_the_second_is_empty() throws Exception {
	  SimpleTable t = TestTableUtil.givenATableWithOneLine();
	  t.newline();
	  Assert.assertEquals(0, t.getNumberOfCellsCurrentline());
	 
	
	}
	
	@Test
	public void test_that_givenATableWithOneLineoftwoCells_getMaxNumberOfCol_returns_two() throws Exception {
	  SimpleTable t = TestTableUtil.givenATableWithOneLine();
	  t.newline();
	  Assert.assertEquals(2, t.getMaxNumberOfCol());
	 
	
	}
	
	@Test
	public void test_that_givenAEmptyTable_getMaxNumberOfCol_returns_zero() throws Exception {
	  SimpleTable t = new SimpleTable();
	  
	  Assert.assertEquals(0, t.getMaxNumberOfCol());
	 
	
	}
	
	@Test
	public void test_that_givenAEmptyTable_isOutOfBound_returns_false() throws Exception {
	  SimpleTable t = new SimpleTable();
	  
	  Assert.assertEquals(false, t.isOutOfBoundCellAdding());
	 
	
	}
	@Test
	public void test_that_givenAEmptyTableWithNewLine_isOutOfBound_returns_false() throws Exception {
	  SimpleTable t = new SimpleTable();
	  t.newline();
	  Assert.assertEquals(false, t.isOutOfBoundCellAdding());
	 
	
	}
	
	@Test
	public void test_that_givenATableWithOneLine_isOutOfBound_returns_false() throws Exception {
	  SimpleTable t = TestTableUtil.givenATableWithOneLine();
	  
	  Assert.assertEquals(false, t.isOutOfBoundCellAdding());
	 
	
	}
	
	@Test
	public void test_that_givenATableWithOneLineofTwoCellandOneLineOfOneCell_isOutOfBound_returns_false() throws Exception {
	  SimpleTable t = TestTableUtil.givenATableWithOneLineofTwoCellandOneLineOfOneCell();
	  Assert.assertEquals(false, t.isOutOfBoundCellAdding());
	}
	
	@Test
	public void test_that_givenATableWithTwoLinesofTwoCells_isOutOfBound_returns_true() throws Exception {
	  SimpleTable t = TestTableUtil.givenATableWithTwoLinesofTwoCells();
	  Assert.assertEquals(true, t.isOutOfBoundCellAdding());
	}
	
	
	@Test
	public void test_when_givenATableWithOneLineofTwoCellandOneLineOfOneCell_that_getMaxNumberOfCol_returns_two() throws Exception {
	  SimpleTable t = TestTableUtil.givenATableWithOneLineofTwoCellandOneLineOfOneCell();
	  
	  Assert.assertEquals(2, t.getMaxNumberOfCol());
	 
	
	}
	
	
	
	@Test
	public void test_addCell_fails_when_too_much_cells_are_added() throws Exception {
		sut = TestTableUtil.givenATableWithTwoLinesofTwoCells();
		try {
			sut.addCell("v3");
			fail("must fail on adding too much cell on the line");
		} catch (Exception e) {
			
		}
	}


}
