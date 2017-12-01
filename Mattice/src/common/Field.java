package common;

public class Field {

	
	private Matchbox next;

	private int probability = -1;
	


	private Field() {}
	
	public Field(Matchbox next) {
		this.next = next;
		this.probability = 0;
	}
	
	

	public boolean hasNext() {
		if (next != null) {
			return true;
		}
		return false;
	}


	public Matchbox getNext() {
		return next;
	}



	public void setNext(Matchbox next) {
		this.next = next;
	}



	public int getProbability() {
		return probability;
	}



	public void setProbability(int probability) {
		this.probability = probability;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + probability;
		return result;
	}


	public boolean equals(Object field) {

		if (this.getClass() != field.getClass()) {
			return false;
		}
		
		Field tmp = (Field) field;
		
		if(this.probability > 0 && this.next != null) {
			if(this.probability == tmp.getProbability() & this.next.equals(tmp.getNext())) {
				return true;
			}
		}
		
		return false;
	}
	
	
}
