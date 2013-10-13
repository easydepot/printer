package test;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.junit.Test;

import core.printing.visitor.DocXPrinter;

public class TestDocXVisitor {

	@Test
	public void testGetIntro() throws Docx4JException {
		DocXPrinter doc = new DocXPrinter();
		doc.GetIntro();
	}

}
