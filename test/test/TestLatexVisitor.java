package test;

import static org.junit.Assert.fail;
import  org.junit.Assert;

import org.junit.Test;

import core.printing.Section;
import core.printing.Sequence;
import core.printing.SimpleText;
import core.printing.table.TablePrinter;
import core.printing.table.TestTableUtil;
import core.printing.table.alignment.ClassicAlignement;
import core.printing.table.alignment.ClassicAlignement.ALIGN;
import core.printing.table.alignment.SizedAlignement;
import core.printing.table.size.FixedSize;
import core.printing.table.size.SpecialSize;
import core.printing.visitor.LatexPrinter;

public class TestLatexVisitor {
	
	@Test
	public void test_Sequence_Empty() {
		LatexPrinter p = new LatexPrinter();
		Sequence s = new Sequence();
		Assert.assertEquals("",p.visit(s));
		
	}
	
	
	
	@Test
	public void test_SimpleText() {
		LatexPrinter p = new LatexPrinter();
		SimpleText s = new SimpleText("aaa");
		Assert.assertEquals("aaa",p.visit(s));
		
	}
	
	@Test
	public void test_SimpleText_italic() {
		LatexPrinter p = new LatexPrinter();
		SimpleText s = new SimpleText("aaa");
		s.setItalic(true);
		Assert.assertEquals("\\textit{aaa}",p.visit(s));
		
	}
	
	@Test
	public void test_SimpleText_bold() {
		LatexPrinter p = new LatexPrinter();
		SimpleText s = new SimpleText("aaa");
		s.setBold(true);
		Assert.assertEquals("\\textbf{aaa}",p.visit(s));
		
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
	public void test_FixedSize() {
		LatexPrinter p = new LatexPrinter();
		FixedSize s = new FixedSize(5);
		Assert.assertEquals("5cm",p.visit(s));
		
	}
	
	@Test
	public void test_SpecialSize() {
		LatexPrinter p = new LatexPrinter();
		SpecialSize s = new SpecialSize("linewidth");
		Assert.assertEquals("\\linewidth",p.visit(s));
		
	}
	
	@Test
	public void test_Sequence_Nominal() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Sequence s = new Sequence();
		s.add(new SimpleText("aaa"));
		s.add(new SimpleText("bbb"));
		Assert.assertEquals("aaa bbb ",p.visit(s));
		
	}
	
	@Test
	public void test_Sequence_Section() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Sequence s = new Sequence();
		s.add(new SimpleText("aaa"));
		s.add(new Section("bbb"));
		Assert.assertEquals("aaa \n\\section{bbb}\n ",p.visit(s));
		
	}
	

	
	
	
	@Test
	public void test_Section() {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
	
		Assert.assertEquals("\n\\section{title}\n",p.visit(s));
		
	}
	
	@Test
	public void test_Sectiob_SubSection() throws Exception {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		Section s2 = new Section("subtitle");
		s.add(s2);
	  
		Assert.assertEquals("\n\\section{title}\n\n\\subsection{subtitle}\n ",p.visit(s));
		
	}
	
	@Test
	public void test_SubSection() {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		p.setSectionlevel(1);
	    
	  
		Assert.assertEquals("\n\\subsection{title}\n",p.visit(s));
		
	}
	
	@Test
	public void test_SubSubSection() {
		LatexPrinter p = new LatexPrinter();
		Section s = new Section("title");
		p.setSectionlevel(2);
	    
	  
		Assert.assertEquals("\n\\subsubsection{title}\n",p.visit(s));
		
	}
	
	@Test
	public void test_Paragraph() {
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
	
	@Test
	public void test_Table() throws Exception {
	core.printing.table.TablePrinter t = new TablePrinter();
	t.addHeader("h1");
	t.addHeader("h2");
	t.addHeader("h3");
	t.addCell("c1");
	t.addCell("c2");
	t.addCell("c3");
	
	LatexPrinter p = new LatexPrinter();
	p.visit(t);
	}
	
	@Test
	public void test_Table_noAlignement() throws Exception {
	core.printing.table.TablePrinter t = new TablePrinter();
	t.addHeader("h1");
	t.addHeader("h2");
	t.addHeader("h3");
	t.newline();
	t.addCell("c1");
	t.addCell("c2");
	t.addCell("c3");
	LatexPrinter p = new LatexPrinter();
	Assert.assertTrue(p.visit(t).contains("|X|"));
	
	}
	
	
	
	@Test
	public void test_Table_alignement_centered() throws Exception {
	core.printing.table.TablePrinter t = TestTableUtil.givenATableWithAlignement();
	t.addAlignement(new ClassicAlignement(ALIGN.CENTER));
	t.addAlignement(new ClassicAlignement(ALIGN.CENTER));
	t.addHeader("h1");
	t.addHeader("h2");
	t.addHeader("h3");
	t.newline();
	t.addCell("c1");
	t.addCell("c2");
	t.addCell("c3");
	LatexPrinter p = new LatexPrinter();
	Assert.assertTrue(p.visit(t).contains("|c|"));
	
	}
	
	
	@Test
	public void test_Table_alignement_centered_one_columns() throws Exception {
	  core.printing.table.TablePrinter t = TestTableUtil.givenATableWithAlignement();
	  t.addHeader("h1");
	
	  t.newline();
	  t.addCell("c1");
	
	  LatexPrinter p = new LatexPrinter();
	  Assert.assertTrue(p.visit(t).contains("|c|"));
	
	}
	
	
	
	@Test
	public void test_Table_alignement_centered_one_columns_addOneHeaderMore() throws Exception {
	  core.printing.table.TablePrinter t = TestTableUtil.givenATableWithAlignement();
	  t.addHeader("h1");
	  try {
		  t.addHeader("h2");
		  fail("SHALL throw an exception");
	  }
	  catch (Exception e){
		  
	  }
	 
	
	}



	
	
	@Test
	public void test_Table_alignement_left() throws Exception {
	core.printing.table.TablePrinter t = new TablePrinter();
	t.addAlignement(new ClassicAlignement(ALIGN.LEFT));
	t.addAlignement(new ClassicAlignement(ALIGN.LEFT));
	t.addAlignement(new ClassicAlignement(ALIGN.LEFT));
	t.addHeader("h1");
	t.addHeader("h2");
	t.addHeader("h3");
	t.newline();
	t.addCell("c1");
	t.addCell("c2");
	t.addCell("c3");
	LatexPrinter p = new LatexPrinter();
	Assert.assertTrue(p.visit(t).contains("|l|"));
	
	}
	
	@Test
	public void test_Table_alignement_right() throws Exception {
	core.printing.table.TablePrinter t = new TablePrinter();
	t.addAlignement(new ClassicAlignement(ALIGN.RIGHT));
	t.addAlignement(new ClassicAlignement(ALIGN.RIGHT));
	t.addAlignement(new ClassicAlignement(ALIGN.RIGHT));
	t.addHeader("h1");
	t.addHeader("h2");
	t.addHeader("h3");
	t.newline();
	t.addCell("c1");
	t.addCell("c2");
	t.addCell("c3");
	LatexPrinter p = new LatexPrinter();
	Assert.assertTrue(p.visit(t).contains("|r|"));
	
	}
	
	@Test
	public void test_Table_alignement_sized() throws Exception {
	core.printing.table.TablePrinter t = new TablePrinter();
	t.addAlignement(new SizedAlignement(2));
	t.addAlignement(new SizedAlignement(2));
	t.addAlignement(new SizedAlignement(2));
	t.addHeader("h1");
	t.addHeader("h2");
	t.addHeader("h3");
	t.newline();
	t.addCell("c1");
	t.addCell("c2");
	t.addCell("c3");
	LatexPrinter p = new LatexPrinter();
	
	Assert.assertTrue(p.visit(t).contains("|p{2cm}|"));
	
	}


}
