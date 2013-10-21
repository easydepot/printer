package core.printing;


import junit.framework.Assert;

import org.junit.Test;

import core.printing.Section;
import core.printing.SimpleText;


public class TestSection {

	@Test
	public void test() {
		Section s = new Section("aaaa");
		Assert.assertEquals("aaaa",s.getTitle());
	}
	
	@Test
	public void test_withcontent() throws Exception {
		Section s = new Section("aaaa");
		s.add(new SimpleText("bbbb"));
	
		Assert.assertEquals("aaaa",s.getTitle());
	}

}
