package core.printing;

public abstract class DocCreator {

	protected Doc document = new Doc();
	protected Object sourceElement;

	public DocCreator(Object sourceElement) {
		super();
		this.sourceElement = sourceElement;
	}

	public void setDocument(Doc document) {
		this.document = document;
	}

	public Doc getDocument() {
		return document;
	}
	
	abstract public void processDocument() throws Exception;

	public Doc processAndGetDocument() throws Exception {
		processDocument();
		return document;
	}
  
}
