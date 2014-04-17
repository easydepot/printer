package core.printing;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestImage {

	@Test
	public void test_is_empty_always_return_false() {
		Image sut = new Image("");
		assertFalse(sut.isEmpty());
	}

}
