package core.printing.visitor;


import org.docx4j.jaxb.Context;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.wml.Br;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.P;
import org.docx4j.wml.STBrType;

import core.printing.BasicElementImplementation;
import core.printing.Box;
import core.printing.Image;
import core.printing.NewLine;
import core.printing.NewPage;
import core.printing.Paragraph;
import core.printing.Quote;
import core.printing.Section;
import core.printing.Sequence;
import core.printing.SimpleText;
import core.printing.TableOfContent;
import core.printing.list.ListItem;
import core.printing.table.SimpleTable;
import core.printing.table.TablePrinter;
import core.printing.table.size.FixedSize;
import core.printing.table.size.SpecialSize;

public class DocXPrinter implements PrintingVisitor {
	 WordprocessingMLPackage wordMLPackage;
	 String file = "helloworld";
	 
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public void GetIntro() throws Docx4JException{
     wordMLPackage = WordprocessingMLPackage.createPackage();
   
    // Save it
    wordMLPackage.save(new java.io.File(file +".docx") );
	}

	@Override
	public String visit(ListItem wheel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(SimpleText engine) {
		 wordMLPackage.getMainDocumentPart().addParagraphOfText(engine.getText());
		return null;
	}

	@Override
	public String visit(TablePrinter body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(Sequence body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(FixedSize fixedSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(SpecialSize specialSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(Section section) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(NewLine newLine) {
		Br objBr = new Br();
		objBr.setType(STBrType.PAGE);
		 ObjectFactory factory = Context.getWmlObjectFactory();
		// Create the paragraph
		org.docx4j.wml.P  para = factory.createP();
		
		para.getParagraphContent().add(objBr);
		wordMLPackage.getMainDocumentPart().addObject(para);
		return "";
	}

	@Override
	public String visit(NewPage newPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(TableOfContent tableOfContent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(Image image) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(Quote quote) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(SimpleTable simpleTable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(BasicElementImplementation element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(Paragraph element) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visit(Box element) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
