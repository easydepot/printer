package core.printing.visitor;

import org.junit.Assert;
import org.junit.Test;

import core.printing.Section;
import core.printing.SimpleText;

public class TestLatexSection {

	@Test
	public void test_Section() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
	
		Assert.assertEquals("\n\\section{title}\n",p.visit(s));
		
	}
	
	@Test
	public void test_Section_with_latexprotectedcharacter() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title_suitetitle");
	
		Assert.assertNotSame("\n\\section{title_suitetitle}\n",p.visit(s));
		
	}
	
	@Test
	public void test_Sectiob_SubSection() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		Section s2 = new Section("subtitle");
		s.add(s2);
	    System.out.print(p.visit(s));
	  
		Assert.assertEquals("\n\\section{title}\n\n\\subsection{subtitle}\n ",p.visit(s));
		
	}
	
	@Test
	public void test_SubSection() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		p.setSectionlevel(1);
	    
	  
		Assert.assertEquals("\n\\subsection{title}\n",p.visit(s));
		
	}
	
	@Test
	public void test_SubSubSection() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		p.setSectionlevel(2);
	    
	  
		Assert.assertEquals("\n\\subsubsection{title}\n",p.visit(s));
		
	}
	
	@Test
	public void test_Paragraph() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		p.setSectionlevel(3);
	    
	  
		Assert.assertEquals("\n\\paragraph{title}\n",p.visit(s));
		
	}
	
	@Test
	public void test_Section_withText() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		s.add(new SimpleText("aaa"));
		Assert.assertEquals("\n\\section{title}\naaa ",p.visit(s));
		
	}
	
	@Test
	public void test_Section_withTwoText() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		s.add(new SimpleText("aaa"));
		s.add(new SimpleText("bbb"));
		Assert.assertEquals("\n\\section{title}\naaa bbb ",p.visit(s));
		
	}

}
