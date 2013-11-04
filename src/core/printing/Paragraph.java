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

	@Override
	public boolean hasSection(String sectionTitle) {
		
		return false;
	}

	@Override
	public boolean hasText(String text) {
		for (BasicElement child: this.children){
			if (child.hasText(text)){
				return true;
			}
		}
		return false;
	}

	
	
   
	
	}
