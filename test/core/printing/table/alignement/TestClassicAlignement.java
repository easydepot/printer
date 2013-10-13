package core.printing.table.alignement;

import junit.framework.Assert;

import org.junit.Test;

import core.printing.table.alignment.ClassicAlignement;


public class TestClassicAlignement {
	
	@Test
	public void test_setAlignement() throws Exception {
		ClassicAlignement sut =  new ClassicAlignement(ClassicAlignement.ALIGN.CENTER);
		sut.setAlignement(ClassicAlignement.ALIGN.LEFT);
		Assert.assertEquals(ClassicAlignement.ALIGN.LEFT, sut.getAlignement());
		
	}
	
	@Test
	public void test_setAlignement_CENTER() throws Exception {
		ClassicAlignement sut =  new ClassicAlignement(ClassicAlignement.ALIGN.CENTER);
		sut.setAlignement(ClassicAlignement.ALIGN.CENTER);
		Assert.assertEquals(ClassicAlignement.ALIGN.CENTER, sut.getAlignement());
		
	}
	
	@Test
	public void test_setAlignement_RIGHT() throws Exception {
		ClassicAlignement sut =  new ClassicAlignement(ClassicAlignement.ALIGN.CENTER);
		sut.setAlignement(ClassicAlignement.ALIGN.RIGHT);
		Assert.assertEquals(ClassicAlignement.ALIGN.RIGHT, sut.getAlignement());
		
	}
	
	@Test
	public void test_setAlignement_EXTEND() throws Exception {
		ClassicAlignement sut =  new ClassicAlignement(ClassicAlignement.ALIGN.CENTER);
		sut.setAlignement(ClassicAlignement.ALIGN.EXTEND);
		Assert.assertEquals(ClassicAlignement.ALIGN.EXTEND, sut.getAlignement());
		
	}

}
