package common;

public class Matchbox {

	private Field[][] field;
	private int winner = 0;

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
		String tmp = "";

		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				tmp = tmp + field[i][j].getPlayer();
			}
			tmp = tmp + "\n";
		}

		return tmp;
	}

	public Matchbox rotate() {

		Matchbox tmp = this.clone();

		tmp.setField(this.getField(0, 0), 0, 2);
		tmp.setField(this.getField(0, 1), 1, 2);
		tmp.setField(this.getField(0, 2), 2, 2);

		tmp.setField(this.getField(1, 0), 0, 1);
		tmp.setField(this.getField(1, 2), 2, 1);

		tmp.setField(this.getField(2, 0), 0, 0);
		tmp.setField(this.getField(2, 1), 1, 0);
		tmp.setField(this.getField(2, 2), 2, 0);

		return tmp;
	}

	public Matchbox mirror() {

		Matchbox tmp = this.clone();

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

	public int hashCode() {
		int tmp = 0;

		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				tmp = tmp + (int) ((field[i][j].getPlayer()+1)*Math.pow(10, (i*3+j)));
			}
		}

		return tmp;
	}
	
	public int[] getallHashes() {
		int[] result = new int[8];
		Matchbox tmp = this.clone();

		result[0]=tmp.hashCode();
		tmp = tmp.mirror();
	    result[1] = tmp.hashCode();

		for (int i = 2; i < 8; i+=2) {

			tmp = tmp.rotate();
			result[i] = tmp.hashCode();

			tmp = tmp.mirror();
			result[i+1] = tmp.hashCode();
		}
		return result;
	}

	public boolean equals(Object box) {

		if (box == null | box.getClass() != this.getClass()) {
			return false;
		}

		boolean result = true;
		Matchbox tmp = (Matchbox) box;

		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				if (this.getPlayerAt(i, j) != tmp.getPlayerAt(i, j)) {
					result = false;
					;
				}
			}
		}

		tmp = tmp.mirror();
		if (this.equalsnocheck(tmp)) {
			return true;
		}

		for (int i = 0; i < 3; i++) {

			tmp = tmp.rotate();
			if (this.equalsnocheck(tmp)) {
				return true;
			}

			tmp = tmp.mirror();
			if (this.equalsnocheck(tmp)) {
				return true;
			}
		}

		return result;
	}

	private boolean equalsnocheck(Matchbox tmp) {

		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				if (this.getPlayerAt(i, j) != tmp.getPlayerAt(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean finished() {

		if (this.hasWinner()) {
			return true;
		}

		for (int j = 0; j < field.length; j++) {
			for (int i = 0; i < field.length; i++) {
				if (this.getPlayerAt(i, j) == 0) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean hasWinner() {

		if (field[0][0].getPlayer() != 0 && field[0][0].getPlayer() == field[0][1].getPlayer() && field[0][0].getPlayer() == field[0][2].getPlayer()) {
			this.winner = field[0][0].getPlayer();
			return true;
		}

		if (field[1][0].getPlayer() != 0 &&field[1][0].getPlayer() == field[1][1].getPlayer() && field[1][0].getPlayer() == field[1][2].getPlayer()) {
			this.winner = field[1][0].getPlayer();
			return true;
		}

		if (field[2][0].getPlayer() != 0 &&field[2][0].getPlayer() == field[2][1].getPlayer() && field[2][0].getPlayer() == field[2][2].getPlayer()) {
			this.winner = field[2][0].getPlayer();
			return true;
		}

		if (field[0][0].getPlayer() != 0 &&field[0][0].getPlayer() == field[1][0].getPlayer() && field[0][0].getPlayer() == field[2][0].getPlayer()) {
			this.winner = field[0][0].getPlayer();
			return true;
		}

		if (field[0][1].getPlayer() != 0 &&field[0][1].getPlayer() == field[1][1].getPlayer() && field[0][1].getPlayer() == field[2][1].getPlayer()) {
			this.winner = field[0][1].getPlayer();
			return true;
		}

		if (field[0][2].getPlayer() != 0 &&field[0][2].getPlayer() == field[1][2].getPlayer() && field[0][2].getPlayer() == field[2][2].getPlayer()) {
			this.winner = field[0][2].getPlayer();
			return true;
		}

		if (field[0][0].getPlayer() != 0 &&field[0][0].getPlayer() == field[1][1].getPlayer() && field[0][0].getPlayer() == field[2][2].getPlayer()) {
			this.winner = field[0][0].getPlayer();
			return true;
		}

		if (field[0][2].getPlayer() != 0 &&field[0][2].getPlayer() == field[1][1].getPlayer() && field[0][2].getPlayer() == field[2][0].getPlayer()) {
			this.winner = field[0][2].getPlayer();
			return true;
		}

		return false;
	}
}
