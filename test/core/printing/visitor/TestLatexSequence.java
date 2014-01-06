package core.printing.visitor;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import core.printing.BasicElementWithChildren;
import core.printing.Section;
import core.printing.Sequence;
import core.printing.SimpleText;

public class TestLatexSequence {

	@Test
	public void test_Sequence_Empty() throws Exception {
		LatexPrinter p = new LatexPrinter();
		BasicElementWithChildren s = new Sequence();
		Assert.assertEquals("",p.visit(s));
		
	}
	
	@Test
	public void test_Sequence_OneElement() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Sequence s = new Sequence();
		s.addText("zzz");
		Assert.assertEquals("zzz ",p.visit(s));
		
	}
	
	@Test
	public void test_Sequence_SeveralElement() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Sequence s = new Sequence();
		s.addText("zzz");
		s.addText("zzz");
		Assert.assertEquals("zzz zzz ",p.visit(s));
		
	}
	
	@Test
	public void test_Sequence_Nominal() throws Exception {
		LatexPrinter p = new LatexPrinter();
		BasicElementWithChildren s = new Sequence();
		s.add(new SimpleText("aaa"));
		s.add(new SimpleText("bbb"));
		Assert.assertEquals("aaa bbb ",p.visit(s));
		
	}
	
	@Test
	public void test_Sequence_Section() throws Exception {
		LatexPrinter p = new LatexPrinter();
		BasicElementWithChildren s = new Sequence();
		s.add(new SimpleText("aaa"));
		s.add(new Section("bbb"));
		Assert.assertEquals("aaa \n\\section{bbb}\n ",p.visit(s));
		
	}
}
