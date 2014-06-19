package core.printing;

public abstract class TokenElement implements BasicElement {
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
		return true;
	}
}
