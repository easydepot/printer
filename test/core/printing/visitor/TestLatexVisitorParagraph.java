package core.printing.visitor;

import org.junit.Assert;
import org.junit.Test;

import core.printing.Paragraph;
import core.printing.SimpleText;
import core.printing.table.alignment.ClassicAlignement.ALIGN;

public class TestLatexVisitorParagraph {
	
	@Test
	public void test_Empty_paragraph_returns_nothing() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Paragraph s = new Paragraph();
		Assert.assertEquals("",p.visit(s));
		
	}
	
	@Test
	public void test_Empty_centered_paragraph_returns_nothing() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Paragraph s = new Paragraph();
		s.setAlignement(ALIGN.CENTER);
		Assert.assertEquals("",p.visit(s));
		
	}
	
	@Test
	public void test_paragraph_with_one_element_returns_the_element() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Paragraph s = new Paragraph();
		s.add(new SimpleText("text1"));
		Assert.assertEquals("text1 ",p.visit(s));
		
	}
	
	@Test
	public void test_paragraph_with_centered_one_element_returns_the_element_enclosed_in_center_environment() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Paragraph s = new Paragraph();
		s.setAlignement(ALIGN.CENTER);
		s.add(new SimpleText("text1"));
		//flushright
		Assert.assertTrue(p.visit(s).contains("\\begin{center}"));
		Assert.assertTrue(p.visit(s).contains("text1"));
		Assert.assertTrue(p.visit(s).contains("\\end{center}"));
	}
	
	@Test
	public void test_paragraph_with_rightaligment_one_element_returns_the_element_enclosed_in_rightaligment_environment() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Paragraph s = new Paragraph();
		s.setAlignement(ALIGN.RIGHT);
		s.add(new SimpleText("text1"));
		
		Assert.assertTrue(p.visit(s).contains("\\begin{flushright}"));
		Assert.assertTrue(p.visit(s).contains("text1"));
		Assert.assertTrue(p.visit(s).contains("\\end{flushright}"));
	}
	
	



}
