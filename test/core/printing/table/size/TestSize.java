package core.printing.table.size;

import junit.framework.Assert;

import org.junit.Test;

public class TestSize {
	
	@Test
	public void test_setSize() throws Exception {
		FixedSize sut = new FixedSize(10);
		sut.setSize(5);
		Assert.assertEquals(5,sut.getSize());
		
	}

}
