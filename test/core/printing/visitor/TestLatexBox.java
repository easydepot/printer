package core.printing.visitor;

import static org.junit.Assert.*;

import org.junit.Test;

import core.printing.BasicElementWithChild;
import core.printing.Box;
import core.printing.TestBox;

public class TestLatexBox {

	@Test
	public void test_that_latex_visitor_does_not_return_a_null_value() throws Exception {
		Box box = TestBox.givenABoxWithTitleAndContent();
		LatexPrinter p = new LatexPrinter();
		assertNotNull(box.accept(p));
		
	}

	@Test
	public void test_that_latex_visitor_does_return_a_latex_box_with_box_content() throws Exception {
		Box box = TestBox.givenABoxWithTitleAndContent();
		LatexPrinter p = new LatexPrinter();
		assertTrue(box.accept(p).contains(TestBox.TEXT1));
		
	}
	
	@Test
	public void test_that_latex_visitor_does_return_a_latex_shadowbox() throws Exception {
		Box box = TestBox.givenABoxWithTitleAndContent();
		LatexPrinter p = new LatexPrinter();
		assertTrue(box.accept(p).contains("\\shadowbox{\\begin{minipage}" + TestBox.TEXT1 + "\\end{minipage}}"));
		
	}
	
	@Test
	public void test_that_latex_visitor_does_return_boxtitle_within_a_white_colorbox() throws Exception {
		Box box = TestBox.givenABoxWithTitleAndContent();
		LatexPrinter p = new LatexPrinter();
		assertTrue(box.accept(p).contains("\\colorbox{white}{" + TestBox.TITLE + "}"));
		
	}
	
	@Test
	public void test_that_latex_visitor_does_not_return_boxtitle_within_a_white_colorbox_when_no_title_is_defined() throws Exception {
		Box box = TestBox.givenABoxWithoutTitleButContent();
		LatexPrinter p = new LatexPrinter();
		assertFalse(box.accept(p).contains("\\colorbox{white}{" + TestBox.TITLE + "}"));
		
	}
	
	@Test
	public void test_that_latex_visitor_does_contain_a_set_length() throws Exception {
		Box box = TestBox.givenABoxWithTitleAndContent();
		LatexPrinter p = new LatexPrinter();
		assertTrue(box.accept(p).contains("\\setlength{\\fboxsep}{6pt}"));
		
	}
	
	@Test
	public void test_that_latex_visitor_does_contain_bbox_imput() throws Exception {
		Box box = TestBox.givenABoxWithTitleAndContent();
		LatexPrinter p = new LatexPrinter();
		assertTrue(box.accept(p).contains("\\boxput*(0,1)"));
		
	}
	
/*
	document.addText("\\boxput*(0,1){");
	document.addText("\\colorbox{white}{Liste des Cartes à transférer}}");
	document.addText("{");
	document.addText("\\shadowbox{");
	document.add(par);
	document.addText("}}");*/
}
