package core.printing.table;

import static org.junit.Assert.*;

import java.awt.Color;

import core.printing.SimpleText;
import core.printing.table.alignment.ClassicAlignement;
import core.printing.table.alignment.ClassicAlignement.ALIGN;

import org.junit.Test;



public class TestCellPrinter {
	
	
	CellPrinter sut = new CellPrinter("content");

	@Test
	public void test_setContent() {
		SimpleText text2 = new SimpleText("text2");
		sut.setContent(text2);
		assertEquals(text2,sut.getContent());
		
	}
	
	@Test
	public void test_Color_default() {
		
		
		assertEquals(Color.WHITE,sut.getColor());
		
	}
	
	@Test
	public void test_setColor_default() {
		
		sut.setColor(Color.BLACK);
		assertEquals(Color.BLACK,sut.getColor());
		
	}
	
	@Test
	public void test_getColspantype_default() {
		assertEquals(ClassicAlignement.ALIGN.CENTER,sut.getColspantype());
		
	}
	
	@Test
	public void test_setColspantype_default() {
		sut.setColspantype(ALIGN.LEFT);
		assertEquals(ClassicAlignement.ALIGN.LEFT,sut.getColspantype());
		
	}
	
	
	@Test
	public void test_setColspan_default() {
		
		assertEquals(0,sut.getColspan());
		
	}
	
	@Test
	public void test_setColspan_value() {
		sut.setColspan(4);
		assertEquals(4,sut.getColspan());
		
	}


}
