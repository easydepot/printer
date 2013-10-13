package core.printing.table.alignment;

public class SizedAlignement implements TableAlignement {
	public SizedAlignement(int size) {
		super();
		this.size = size;
	}

	int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
	
}
