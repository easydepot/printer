package core.printing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestBox  {

	public static final String TEXT1 = "text1";
	public static final String TITLE = "title";
	private static final SimpleText CONTENT = new SimpleText(TEXT1);

	@Test
	public void test_getTitle() {
		Box sut = givenABoxWithTitleAndContent();
		assertEquals(TITLE,sut.getTitle());
	}
	
	@Test
	public void test_getContent() {
		BasicElementWithChild sut = givenABoxWithTitleAndContent();
		assertEquals(CONTENT,sut.getContent());
	}
	

	@Test
	public void test_isEmpty_returns_false_if_content_is_not_empty() {
		BasicElementWithChild sut = givenABoxWithTitleAndContent();
		assertFalse(sut.isEmpty());
	}
	
	@Test
	public void test_isEmpty_returns_true_if_content_is_empty() {
		BasicElementWithChild sut = new Box(new SimpleText(""), TITLE);
		assertTrue(sut.isEmpty());
	}
	
	
	
	

	public static Box givenABoxWithTitleAndContent() {
		
		Box sut = new Box(CONTENT, TITLE);
		return sut;
	}
	
   


}
