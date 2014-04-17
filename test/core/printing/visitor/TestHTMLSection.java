package core.printing.visitor;

import core.printing.BasicElementWithChildren;
import core.printing.Section;

public class TestHTMLSection implements TestSection {

	@Override
	public void test_Section() throws Exception {
		LatexPrinter p = new LatexPrinter();
		BasicElementWithChildren s = new Section("title");

	}

	@Override
	public void test_Section_as_BasicElementImplementation() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void test_Section_as_BasicElementWithChild() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void test_Section_with_latexprotectedcharacter() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void test_Sectiob_SubSection() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void test_SubSection() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void test_SubSubSection() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void test_Paragraph() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void test_Section_withText() throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void test_Section_withTwoText() throws Exception {
		// TODO Auto-generated method stub

	}

}
