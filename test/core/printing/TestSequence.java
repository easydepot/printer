package core.printing;


import static org.junit.Assert.*;

import org.junit.Assert;
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
	

	@Test
	public void test_isEmpty_returns_true_when_empty_sequence() throws Exception {
		
		BasicElementWithChildren s = new Sequence();
		assertTrue(s.isEmpty());
		
		
	}
	
	@Test
	public void test_isEmpty_returns_false_when_sequence_contains_a_non_empty_element() throws Exception {
		
		Sequence s = new Sequence();
		s.addText("blalba");
		assertFalse(s.isEmpty());
		
		
	}
	
	@Test
	public void test_isEmpty_returns_true_when_sequence_contains_only_empty_element() throws Exception {
		
		Sequence s = new Sequence();
		s.addText("");
		s.addText("");
		s.addText("");
		assertTrue(s.isEmpty());
		
		
	}

}
