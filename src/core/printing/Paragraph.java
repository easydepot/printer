package core.printing;

import core.printing.table.alignment.ClassicAlignement.ALIGN;

public class Paragraph extends BasicElementWithChild {
	
	ALIGN alignement = ALIGN.LEFT;

	public ALIGN getAlignement() {
		return alignement;
	}

	public void setAlignement(ALIGN alignement) {
		this.alignement = alignement;
	} 
	
   
	
	}
