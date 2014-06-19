package core.printing;

import org.junit.Assert;
import org.junit.Test;

import core.printing.Doc;
import core.printing.SimpleText;

public class TestDoc {

	private static final String ANOTHER_SECTION_NAME = "Another section name";
	private static final String SECTION_NAME = "SectionName";

	@Test
	public void test_addText() throws Exception {
		Doc doc = new Doc();
		SimpleText t = doc.addText("text");
		Assert.assertEquals("text", t.getText());
	}
	
	@Test
	public void test_thatAddBox_put_Box_at_current_element() throws Exception {
		Doc doc = new Doc();
		doc.addBox();
		Assert.assertEquals(Box.class, doc.getCurrentElement().getClass());
		
	}
	
	@Test
	public void test_thatAddBox_add_text_to_the_box_content() throws Exception {
		Doc doc = new Doc();
		doc.addBox();
		doc.addText("test");
		Assert.assertEquals(1, doc.getCurrentElement().getChildren().size());
		Assert.assertEquals("test", ((SimpleText)doc.getCurrentElement().get(0)).getText());
		
	}
	
	
	
	
	
	
	@Test
	public void test_hasSection_returns_false_when_no_section_is_defined() throws Exception {
		Doc doc = new Doc();
		
		Assert.assertFalse(doc.hasSection(SECTION_NAME));
	}
	
	@Test
	public void test_hasSection_returns_false_when_section_are_defined_but_not_matching_the_section_name() throws Exception {
		Doc doc = new Doc();
		doc.addSection(ANOTHER_SECTION_NAME);
		Assert.assertFalse(doc.hasSection(SECTION_NAME));
	}
	
	@Test
	public void test_hasSection_returns_true_when_first_section_is_matching_the_section_name() throws Exception {
		Doc doc = new Doc();
		doc.addSection(SECTION_NAME);
		Assert.assertTrue(doc.hasSection(SECTION_NAME));
	}
	
	@Test
	public void test_hasSection_returns_true_when_second_section_is_matching_the_section_name() throws Exception {
		Doc doc = new Doc();
		doc.addSection(ANOTHER_SECTION_NAME);
		doc.pop();
		doc.addSection(SECTION_NAME);
		Assert.assertTrue(doc.hasSection(SECTION_NAME));
	}
	
	@Test
	public void test_hasSection_returns_true_when_a_section_is_matching_the_section_name_and_some_other_element_are_preceding_the_section() throws Exception {
		Doc doc = new Doc();
		doc.addText("SimpleText");
		doc.addSection(SECTION_NAME);
		Assert.assertTrue(doc.hasSection(SECTION_NAME));
	}
	
	@Test
	public void test_hasSection_returns_true_when_a_subsection_has_that_name() throws Exception {
		Doc doc = new Doc();
		doc.addSection(ANOTHER_SECTION_NAME);
		doc.addSection(SECTION_NAME);
		Assert.assertTrue(doc.hasSection(SECTION_NAME));
	}
	
	@Test
	public void test_hasText_returns_true_doc_sequence_contains_the_text() throws Exception {
		Doc doc = new Doc();
		doc.addText("text1");
		
		Assert.assertTrue(doc.hasText("text1"));
	}
	
	@Test
	public void test_hasText_returns_true_doc_sequence_contains_the_text_within_a_section() throws Exception {
		Doc doc = new Doc();
		doc.addSection("section1");
		doc.addText("text1");
		
		Assert.assertTrue(doc.hasText("text1"));
	}
	
	


}
