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

@Override
public void add(BasicElement e) throws Exception {
	// TODO Auto-generated method stub
	
}

public File getFile() {
	return file;
}

public void setFile(File file) {
	this.file = file;
}



}