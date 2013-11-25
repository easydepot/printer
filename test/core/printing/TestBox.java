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
		Box sut = givenABoxWithTitleAndContent();
		assertEquals(CONTENT,sut.getContent());
	}
	
	

	public static Box givenABoxWithTitleAndContent() {
		
		Box sut = new Box(CONTENT, TITLE);
		return sut;
	}
	


}
