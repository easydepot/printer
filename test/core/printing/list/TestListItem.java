package core.printing.list;

import junit.framework.Assert;

import org.junit.Test;

import core.printing.BasicElementWithChildren;
import core.printing.SimpleText;
import core.printing.visitor.LatexPrinter;


public class TestListItem {
	private static final String ITEM1 = "item1";
	ListItem sut = new ListItem();
	
	
	@Test
	public void test_that_initial_number_of_item_is_zero() {
		Assert.assertEquals(0, sut.size());
	}
	
	@Test
	public void test_that_addItem_increase_the_size() throws Exception {
		sut.addItem(ITEM1);
		Assert.assertEquals(1, sut.size());
	}
	
	@Test
	public void test_that_addItem_addTheItemto_the_list() throws Exception {
		sut.addItem(ITEM1);
		Assert.assertEquals(ITEM1, ((SimpleText)((BasicElementWithChildren)sut.get(0)).get(0)).getText());
	}
	
	@Test
	public void test_that_addItemBasicElement_addTheItemto_the_list() throws Exception {
		SimpleText simpleText = new SimpleText(ITEM1);
		sut.addItem(simpleText);
		Assert.assertEquals(ITEM1, ((SimpleText)((BasicElementWithChildren)sut.get(0)).get(0)).getText());
	}
	
	@Test
	public void test_that_continueItemBasicElement_addTheItemto_the_list() throws Exception {
		SimpleText simpleText = new SimpleText(ITEM1);
		sut.addItem(simpleText);
		SimpleText simpleText2 = new SimpleText("ITEM2");
		sut.continueItem(simpleText2);
		Assert.assertEquals(ITEM1, ((SimpleText)((BasicElementWithChildren)sut.get(0)).get(0)).getText());
		Assert.assertEquals("ITEM2", ((SimpleText)((BasicElementWithChildren)sut.get(0)).get(1)).getText());
	}
	
	@Test
	public void test_that_continueItemBasicElement_addTheItemto_emptylist() throws Exception {
		SimpleText simpleText = new SimpleText(ITEM1);
		sut.continueItem(simpleText);
		
		Assert.assertEquals(ITEM1, ((SimpleText)((BasicElementWithChildren)sut.get(0)).get(0)).getText());
	}
	
	@Test
	public void test_that_addBasicElement_addTheItemto_the_list() throws Exception {
		SimpleText simpleText = new SimpleText(ITEM1);
		sut.add(simpleText);
		Assert.assertEquals(ITEM1, ((SimpleText)((BasicElementWithChildren)sut.get(0)).get(0)).getText());
	}
	
	@Test
	public void test_visit() throws Exception {
		LatexPrinter visitor = new LatexPrinter();
		sut.accept(visitor);
		
	}


}
