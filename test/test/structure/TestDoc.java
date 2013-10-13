package test.structure;

import junit.framework.Assert;

import org.junit.Test;

import core.printing.Doc;
import core.printing.SimpleText;

public class TestDoc {

	@Test
	public void test_addText() throws Exception {
		Doc doc = new Doc();
		SimpleText t = doc.addText("text");
		Assert.assertEquals("text", t.getText());
	}

}
