package core.printing;

import java.io.File;

import core.printing.visitor.PrintingVisitor;

public class Image implements BasicElement {
  File file;
  int scale;



public int getScale() {
	return scale;
}

public void setScale(int scale) {
	this.scale = scale;
}

public Image(File file) {
	super();
	this.file = file;
}

public Image(String s) {
	super();
	this.file = new File(s);
}


@Override
public String accept(PrintingVisitor visitor) {
	return visitor.visit(this);
}


public File getFile() {
	return file;
}

public void setFile(File file) {
	this.file = file;
}

@Override
public boolean hasSection(String sectionTitle) {
	return false;
}

@Override
public boolean hasText(String text) {
	
	return false;
}

@Override
public boolean isEmpty() {
	
	return false;
}



}
