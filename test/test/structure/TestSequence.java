package test.structure;

import junit.framework.Assert;

import org.junit.Test;

import core.printing.Sequence;
import core.printing.SimpleText;
import core.printing.visitor.LatexPrinter;

public class TestSequence {

	@Test
	public void test() throws Exception {
		Sequence s = new Sequence();
		s.addText("zzzz");
		
	}
	
	@Test
	public void test_Sequence_addText() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Sequence s = new Sequence();
		SimpleText res = s.addText("aaa");
		Assert.assertEquals("aaa",res.getText());
		
	}

}
