package core.printing;

import junit.framework.Assert;

import org.junit.Test;


public class TestSimpleText {
	
	@Test
	public void test_setText(){
		SimpleText sut = new SimpleText("text1");
		sut.setText("text2");
		Assert.assertEquals("text2", sut.getText());
		
	}

}
