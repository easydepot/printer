package core.printing.table.size;

import core.printing.BasicElement;
import core.printing.visitor.PrintingVisitor;

public class FixedSize extends TableSize {
	
		  int size;

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public FixedSize(int size) {
			super();
			this.size = size;
		}

		@Override
		public String accept(PrintingVisitor visitor) {
			
			return visitor.visit(this);
		}

		@Override
		public void add(BasicElement e) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		  
	  }

