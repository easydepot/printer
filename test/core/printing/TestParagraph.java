package core.printing;

import static org.junit.Assert.*;

import org.junit.Test;

import core.printing.table.alignment.ClassicAlignement.ALIGN;

public class TestParagraph {

	@Test
	public void test_that_default_alignement_is_left() {
		Paragraph sut = new Paragraph();
		assertEquals(ALIGN.LEFT, sut.getAlignement());
	}
	
	
	@Test
	public void test_that_set_alignement_change_the_alignement() {
		Paragraph sut = new Paragraph();
		sut.setAlignement(ALIGN.RIGHT);
		assertEquals(ALIGN.RIGHT, sut.getAlignement());
	}
	
	@Test
	public void test_has_children_returns_true_when_one_children_added() throws Exception {
		Paragraph sut = new Paragraph();
		sut.add(new SimpleText("text1"));
		assertTrue(sut.hasChildren());
	}
	
	@Test
	public void test_has_children_returns_false_when_no_child_added() throws Exception {
		Paragraph sut = new Paragraph();
		assertFalse(sut.hasChildren());
	}


}
