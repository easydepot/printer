package core.printing.visitor;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import core.printing.BasicElement;
import core.printing.BasicElementImplementation;
import core.printing.BasicElementWithChildren;
import core.printing.Section;
import core.printing.SimpleText;

public class TestLatexSection implements TestSection {

	/* (non-Javadoc)
	 * @see core.printing.visitor.TestSection#test_Section()
	 */
	@Override
	@Test
	public void test_Section() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
	
		Assert.assertEquals("\n\\section{title}\n",p.visit(s));
		
	}
	
	/* (non-Javadoc)
	 * @see core.printing.visitor.TestSection#test_Section_as_BasicElementImplementation()
	 */
	@Override
	@Test
	public void test_Section_as_BasicElementImplementation() throws Exception {
		LatexPrinter p = new LatexPrinter();
		BasicElementImplementation s = new Section("title");
	
		Assert.assertEquals("\n\\section{title}\n",p.visit(s));
		
	}
	
	/* (non-Javadoc)
	 * @see core.printing.visitor.TestSection#test_Section_as_BasicElementWithChild()
	 */
	@Override
	@Test
	public void test_Section_as_BasicElementWithChild() throws Exception {
		LatexPrinter p = new LatexPrinter();
		BasicElementWithChildren s = new Section("title");
	
		Assert.assertEquals("\n\\section{title}\n",p.visit(s));
		
	}
	
	
	
	/* (non-Javadoc)
	 * @see core.printing.visitor.TestSection#test_Section_with_latexprotectedcharacter()
	 */
	@Override
	@Test
	public void test_Section_with_latexprotectedcharacter() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title_suitetitle");
	
		Assert.assertNotSame("\n\\section{title_suitetitle}\n",p.visit(s));
		
	}
	
	/* (non-Javadoc)
	 * @see core.printing.visitor.TestSection#test_Sectiob_SubSection()
	 */
	@Override
	@Test
	public void test_Sectiob_SubSection() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		Section s2 = new Section("subtitle");
		s.add(s2);
	    System.out.print(p.visit(s));
	  
		Assert.assertEquals("\n\\section{title}\n\n\\subsection{subtitle}\n ",p.visit(s));
		
	}
	
	/* (non-Javadoc)
	 * @see core.printing.visitor.TestSection#test_SubSection()
	 */
	@Override
	@Test
	public void test_SubSection() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		p.setSectionlevel(1);
	    
	  
		Assert.assertEquals("\n\\subsection{title}\n",p.visit(s));
		
	}
	
	/* (non-Javadoc)
	 * @see core.printing.visitor.TestSection#test_SubSubSection()
	 */
	@Override
	@Test
	public void test_SubSubSection() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		p.setSectionlevel(2);
	    
	  
		Assert.assertEquals("\n\\subsubsection{title}\n",p.visit(s));
		
	}
	
	/* (non-Javadoc)
	 * @see core.printing.visitor.TestSection#test_Paragraph()
	 */
	@Override
	@Test
	public void test_Paragraph() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		p.setSectionlevel(3);
	    
	  
		Assert.assertEquals("\n\\paragraph{title}\n",p.visit(s));
		
	}
	
	/* (non-Javadoc)
	 * @see core.printing.visitor.TestSection#test_Section_withText()
	 */
	@Override
	@Test
	public void test_Section_withText() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		s.add(new SimpleText("aaa"));
		Assert.assertEquals("\n\\section{title}\naaa ",p.visit(s));
		
	}
	
	/* (non-Javadoc)
	 * @see core.printing.visitor.TestSection#test_Section_withTwoText()
	 */
	@Override
	@Test
	public void test_Section_withTwoText() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		s.add(new SimpleText("aaa"));
		s.add(new SimpleText("bbb"));
		Assert.assertEquals("\n\\section{title}\naaa bbb ",p.visit(s));
		
	}

}
