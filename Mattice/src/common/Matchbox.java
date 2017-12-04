package common;

public class Matchbox {
	
	private Field[][] field;
	
	public Matchbox(Matchbox box) {
		this();
		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				this.setField(new Field(box.getPlayerAt(i, j)), i, j);
			}
		}
	}
	
	public Matchbox() {
		this.field = new Field[3][3];
		
		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				this.field[i][j] = new Field();
			}
		}
	}

	public Field getField(int i, int j) {
		return field[i][j];
	}

	public void setField(Field field, int i, int j) {
		this.field[i][j] = field;
	}
	
	public int getPlayerAt(int i, int j) {
		return field[i][j].getPlayer();
	}
	
	public Matchbox getNext(int i, int j) {
		return field[i][j].getNext();
	}
	
	public String toString() {
		String tmp= "";
		
		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				tmp = tmp + field[i][j].getPlayer();
			}
			tmp = tmp + "\n";
		}
		
		return tmp;
	}
	
	public Matchbox rotate() {
		
		Matchbox tmp = this.clone(); //TODO implementieren
		
		tmp.setField(this.getField(0, 0), 0, 2);
		tmp.setField(this.getField(0, 1), 1, 2);
		tmp.setField(this.getField(0, 2), 2, 2);
		
		tmp.setField(this.getField(1, 0), 0, 1);
		//tmp.setField(this.getField(1, 1), 0, 2);
		tmp.setField(this.getField(1, 2), 2, 1);
		
		tmp.setField(this.getField(2, 0), 0, 0);
		tmp.setField(this.getField(2, 1), 1, 0);
		tmp.setField(this.getField(2, 2), 2, 0);
		
		return tmp;
	}
	
	public Matchbox mirror() {
		
		Matchbox tmp = this.clone();
		
		//TODO
		tmp.setField(this.getField(0, 0), 0, 2);
		tmp.setField(this.getField(1, 0), 1, 2);
		tmp.setField(this.getField(2, 0), 2, 2);
		
		tmp.setField(this.getField(0, 2), 0, 0);
		tmp.setField(this.getField(1, 2), 1, 0);
		tmp.setField(this.getField(2, 2), 2, 0);
		
		
		return tmp;
	}
	
	public Matchbox clone() {
		Matchbox tmp = new Matchbox();
		
		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				tmp.setField(this.getField(i, j), i, j);
			}
		}
		
		return tmp;
	}
	
	public boolean equals(Object box) {
		if(box == null | box.getClass() != this.getClass()) {
			return false;
		}
		
		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				if(this.getPlayerAt(i, j) != ((Matchbox) box).getPlayerAt(i, j)) {
					return false;
				}
			}
		}
		
		return true;
	}

	public boolean finished() {
		// TODO implementieren
		
		if(!this.hasWinner()) {
			return false;
		}
		
		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				if(this.getPlayerAt(i, j) == 0) {
					return false;
				}
			}
		}
		
		return true;
	}

	private boolean hasWinner() {
		// TODO Auto-generated method stub
		
		
		
		return false;
	}
}
