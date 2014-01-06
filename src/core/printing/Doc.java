

package core.printing;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

import core.printing.list.ListItem;
import core.printing.visitor.HTMLPrinter;
import core.printing.visitor.LatexPrinter;

public class Doc {
	
	public static final String CRYPTOSTD = "cryptostd";
	String title;
	String subtitle;
	Sequence mainSeq = new Sequence();
	Stack<BasicElementWithChildren> stackElement = new Stack<BasicElementWithChildren>();
	boolean Landscape = false; 
	String documentClass = "scrartcl";
	Bibliography bibliography = new Bibliography();
	
	
	class Bibliography {
	  HashMap<String,String> normativeReference = new HashMap<String,String>(); 
	  
	

	  public boolean isEmpty() {
		return normativeReference.isEmpty();
	  }



	  public boolean containsKey(Object key) {
		return normativeReference.containsKey(key);
	}



	public String get(Object key) {
		return normativeReference.get(key);
	}



	public Set<String> keySet() {
		return normativeReference.keySet();
	}



	public int size() {
		return normativeReference.size();
	}



	public String putReference(String key, String title) {
		return normativeReference.put(key, title);
      }
	}

	class DocProperty{
		String key;
		String value;
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public DocProperty(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
		
	}
	
	ArrayList<DocProperty> listProperty = new ArrayList<DocProperty>(); 
	ArrayList<String> specificcommands = new ArrayList<String>();
	
	
	
	PrintWriter writer;
	
	
	String path;
	
	
	
	public String getPath() {
		return path;
	}





	public void setPath(String path) {
		this.path = path;
	}





	public void print() throws Exception{
	  try {
		writer = new PrintWriter(new BufferedWriter(new FileWriter(this.getPath())));
		writer.write(this.getLatex());
		writer.close();
	  } catch (IOException e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
	  }
	}
	
	public void printHTML() throws Exception{
		  try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(this.getPath())));
			writer.write(this.getHTML());
			writer.close();
		  } catch (IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
		  }
		}
			
	


	
	public boolean add(DocProperty e) {
		return listProperty.add(e);
	}
	
	public boolean add(String key,String value) {
		return listProperty.add(new DocProperty(key,value));
	}


	public DocProperty get(int index) {
		return listProperty.get(index);
	}


	public int size() {
		return listProperty.size();
	}


	public boolean isLandscape() {
		return Landscape;
	}


	public void setLandscape(boolean landscape) {
		Landscape = landscape;
	}


	public boolean empty() {
		return stackElement.empty();
	}


	public void setDocumentClass(String documentClass) {
		this.documentClass = documentClass;
	}


	public BasicElementWithChildren getCurrentElement() {
		return stackElement.peek();
	}


	public BasicElement pop() throws Exception {
		return stackElement.pop();
	}


	public BasicElement push(BasicElementWithChildren item) {
		return stackElement.push(item);
	}


	public String getSubtitle() {
		return subtitle;
	}


	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Doc() {
		super();
		push(this.mainSeq);
	}
	
	
	
	
	public boolean addSpecificCommand(String e) {
		return specificcommands.add(e);
	}
	
	public void clearSpecificCommand() {
		specificcommands.clear();
	}

	private String getLatexIntro(){
		if(!this.documentClass.contentEquals(CRYPTOSTD)) {
			  this.specificcommands.add("\\maketitle");
			} else {
				this.specificcommands.add("\\maketitlec");
			}
		
		String result="";
		if (this.Landscape){
		  result += "\\documentclass[francais,landscape]{" + this.documentClass + "}\n";
		}else {
		  result += "\\documentclass[francais]{" + this.documentClass + "}\n";
		}
		result += "\\usepackage{longtable,colortbl,color}\n";
		result += "\\usepackage{ifthen}\n";
		result += "\\usepackage{multirow}\n";
		result += "\\usepackage[utf8]{inputenc}\n";
		result += "\\usepackage{tabularx}\n";
		result += "\\usepackage[pdftex]{graphicx}\n";
		result += "\\usepackage[table]{xcolor}\n";
		result += "\\usepackage{fancybox}\n";
		result += "\\usepackage{geometry}\n"; 
		result += "\\usepackage{ulem}\n"; 
		result += "\\title{" + title + "}\n";
		for (int i = 0; i < this.listProperty.size();i++){
			result += "\\" + this.get(i).getKey() + "{" + this.get(i).getValue() + "}\n";
		}
		result += "\\subtitle{" + subtitle + "}\n";
		result += "\\begin{document}\n";
		
		int startindex = 0;
		if (this.titlePageDisabled){
			startindex = 1;
		}
		for (int i = startindex; i < this.specificcommands.size();i++){
			result += this.specificcommands.get(i) +"\n";
		}
		
		
		result += "\\newpage\n";
		return result;
	}
	
	private String getLatexOutro(){
		String result="";

		result += "\\end{document}\n";

		return result;
	}

	

	public void add(BasicElement e) throws Exception {
		  this.getCurrentElement().add(e);
	}

	public SimpleText addText(String s) throws Exception {
		if (this.getCurrentElement() == mainSeq){
			return this.mainSeq.addText(s);
			
		}
		return ((Section) this.getCurrentElement()).addText(s);
	}
	
	public Image addImage(String s) throws Exception {
		Image img = new Image(s);
		this.getCurrentElement().add(img);
		return img;
	}
	
	public Quote addQuote(String s) throws Exception{
		Quote q = new Quote(s);
		this.getCurrentElement().add(q);
		return q;
	}

	public void addSection(String s) throws Exception {
		if (this.getCurrentElement().getClass().equals(core.printing.Section.class)){
		  push(((Section)this.getCurrentElement()).addSection(s));
		}
		if (this.getCurrentElement().getClass().equals(core.printing.Sequence.class)){
			  push(((Sequence)this.getCurrentElement()).addSection(s));
			}
		
	}
	
	public void newLine() throws Exception{
		this.getCurrentElement().add(new NewLine());
	}
	
	public void newPage() throws Exception{
		this.getCurrentElement().add(new NewPage());
	}
	
	public void addTableOfContents() throws Exception{
		this.getCurrentElement().add(new TableOfContent());
	}
	
	public String getLatex() throws Exception{
		String result="";
		LatexPrinter v = new LatexPrinter();
		result += this.getLatexIntro();
		result += this.mainSeq.accept(v);
		result += this.getLatexOutro();
		return result;
	}

	public String getHTML() throws Exception{
		String result="";
		HTMLPrinter v = new HTMLPrinter();
		//result += this.getLatexIntro();
		result += this.mainSeq.accept(v);
		//result += this.getLatexOutro();
		return result;
	}



	public boolean hasSection(String sectionTitle) {
		
		for (int i = 0; i < this.mainSeq.size();i++){
			if (this.mainSeq.get(i).getClass().equals(Section.class)){
			  Section s = (Section) this.mainSeq.get(i);
			  if (s.getTitle().contentEquals(sectionTitle)) {
				return true;
			  }
			}
			if (this.mainSeq.get(i).hasSection(sectionTitle)){
					return true;
			}
			
		}
		return false;
	}





	public boolean hasText(String text) {
		for (int i = 0; i < this.mainSeq.size();i++){
			if (this.mainSeq.get(i).hasText(text)){
				return true;
				
		}
		}
		return false;
	}



    boolean titlePageDisabled = false;

	public void disableTitlePage() {
		titlePageDisabled = true;	
		
	}





	public core.printing.list.ListItem addListItem() throws Exception {
		ListItem l = new ListItem();
		this.getCurrentElement().add(l);
		return l;
	}






	
	
	
	

}
