package core.printing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNewLine {

	@Test
	public void test() {
		BasicElement newline = new NewLine();
		assertTrue(newline.isEmpty());
	}

}
