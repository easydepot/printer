package core.printing.table.size;

import core.printing.visitor.PrintingVisitor;

public class SpecialSize
 extends TableSize {
	
		  String type;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public SpecialSize(String type) {
			super();
			this.type = type;
		}

		@Override
		public String accept(PrintingVisitor visitor) {
			return visitor.visit(this);
		}

		
		  
	  }

