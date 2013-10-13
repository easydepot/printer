package core.printing.table.alignment;

public class ClassicAlignement implements TableAlignement {
	public static enum ALIGN {
	    CENTER, LEFT, RIGHT, EXTEND 
	}
	
	ALIGN alignement = ALIGN.LEFT;

	public ALIGN getAlignement() {
		return alignement;
	}

	public void setAlignement(ALIGN alignement) {
		this.alignement = alignement;
	}

	public ClassicAlignement(ALIGN alignement) {
		super();
		this.alignement = alignement;
	}
	
	
}
