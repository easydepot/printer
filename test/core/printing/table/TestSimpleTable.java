package core.printing.table;

import junit.framework.Assert;

import org.junit.Test;

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

}
