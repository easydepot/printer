package core.printing.table.alignement;

import junit.framework.Assert;

import org.junit.Test;

import core.printing.table.alignment.SizedAlignement;


public class TestSizedAlignement {
	
	@Test
	public void test_setSize() throws Exception {
		SizedAlignement sut =  new SizedAlignement(1);
		sut.setSize(3);
		Assert.assertEquals(3, sut.getSize());
		
	}

}
