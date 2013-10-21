package core.printing.table.size;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestSpecialSize {

	@Test
	public void test() {
		SpecialSize sut = new SpecialSize("val1");
		sut.setType("val2");
		Assert.assertEquals("val2", sut.getType());
		
	}

}
