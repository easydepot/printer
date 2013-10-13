package test.latex;

import junit.framework.Assert;

import org.junit.Test;

import core.printing.Section;
import core.printing.Sequence;
import core.printing.SimpleText;
import core.printing.WarningText;
import core.printing.table.TablePrinter;
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
	public void test_SimpleText_color() {
		LatexPrinter p = new LatexPrinter();
		SimpleText s = new SimpleText("aaa");
		s.setColor("red");
		Assert.assertEquals("\\textcolor{red}{aaa}",p.visit(s));
		
	}
	
	@Test
	public void test_WarningText() {
		LatexPrinter p = new LatexPrinter();
		WarningText s = new WarningText("aaa");
		Assert.assertEquals("\\textcolor{red}{aaa}",p.visit(s));
		
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
	public void test_latexize_idempotent_when_normal_text() {
		Assert.assertEquals("aaa", LatexPrinter.latexize("aaa"));
	}
	
	@Test
	public void test_latexize_when_underscore() {
		Assert.assertEquals("a\\_\\-a", LatexPrinter.latexize("a_a"));
	}
	
	@Test
	public void test_latexize_when_null() {
		Assert.assertEquals("", LatexPrinter.latexize(null));
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
	core.printing.table.TablePrinter t = new TablePrinter();
	t.addAlignement(new ClassicAlignement(ALIGN.CENTER));
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
	System.out.print(p.visit(t));
	Assert.assertTrue(p.visit(t).contains("|c|"));
	
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
	
	@Test
	public void test_Table_alignement_extend() throws Exception {
	core.printing.table.TablePrinter t = new TablePrinter();
	t.addAlignementExtend();
	t.addAlignementExtend();
	t.addAlignementExtend();

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
	public void test_Table_alignement_extend_sizedTable() throws Exception {
	core.printing.table.TablePrinter t = new TablePrinter();
	t.setSize(14);
	t.addAlignementSize(6);
	t.addAlignementExtend();
	t.addAlignementSize(6);
	
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


}
