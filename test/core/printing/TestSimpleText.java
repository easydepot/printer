package core.printing;


import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class TestSimpleText {
	
	@Test
	public void test_setText(){
		SimpleText sut = new SimpleText("text1");
		sut.setText("text2");
		Assert.assertEquals("text2", sut.getText());
		
	}
	
	@Test
	public void test_isEmpty_returns_true_when_empty_string(){
		SimpleText sut = new SimpleText("");
		assertTrue(sut.isEmpty());
		
	}
	
	@Test
	public void test_isEmpty_returns_true_when_the_text_contains_something(){
		SimpleText sut = new SimpleText("aaa");
		assertFalse(sut.isEmpty());
		
	}
	
	@Test
	public void test_isStrikeThroughReturnsFalseByDefault(){
		SimpleText sut = new SimpleText("aaa");
		assertFalse(sut.isStrikeThrough());
		
	}
	
	@Test
	public void test_isStrikeThroughReturnsTrueWhenSetted(){
		SimpleText sut = new SimpleText("aaa");
		sut.setStrikeThough();
		assertTrue(sut.isStrikeThrough());
		
	}

}
