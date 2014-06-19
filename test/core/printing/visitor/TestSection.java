package core.printing.visitor;

import org.junit.Test;

public interface TestSection {

	public abstract void test_Section() throws Exception;

	public abstract void test_Section_as_BasicElementImplementation()
			throws Exception;

	public abstract void test_Section_as_BasicElementWithChild()
			throws Exception;

	public abstract void test_Section_with_latexprotectedcharacter()
			throws Exception;

	public abstract void test_Sectiob_SubSection() throws Exception;

	public abstract void test_SubSection() throws Exception;

	public abstract void test_SubSubSection() throws Exception;

	public abstract void test_Paragraph() throws Exception;

	public abstract void test_Section_withText() throws Exception;

	public abstract void test_Section_withTwoText() throws Exception;

}