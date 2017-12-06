package common;

public class Field {

	
	private Matchbox next;

	private int probability = -1;
	private int player = 0;




	public Field(int player) {
		this.player = player;
	}
	
	public Field(Matchbox next) {
		this.next = next;
		this.probability = 1;
	}
	

	public Field() {
	}

	public boolean hasNext() {
		if (next != null) {
			return true;
		}
		return false;
	}

	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Field other = (Field) obj;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (probability != other.probability)
			return false;
		return true;
	}

}
