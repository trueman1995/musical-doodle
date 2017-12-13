/**
 * 
 */
package geometry;

/**
 * @author armb_9527
 *
 */
public class Rectangle {

	private int breite;
	private int höhe;
	

	public Rectangle(int breite, int höhe) {
		this.setBreite(breite);
		this.setHöhe(höhe);
	}
	
	public Rectangle(){
		this(1, 1);
	}
	
	public Rectangle(int kantenlänge){
		this(kantenlänge, kantenlänge);
	}

	public void print() {
		System.out.println(this.höhe + " hoch," + this.breite + " breit");
	}

	public int getFlaeche() {
		return (this.breite * this.höhe);

	}

	public void anpassenGroesse(int dhöhe, int dbreite) {
		this.höhe += dhöhe;
		this.breite += dbreite;
	}

	public int minbreite(Rectangle zwei) {
		if (this.breite <= zwei.breite) {
			return this.breite;
		} else {
			return zwei.breite;
		}
	}
	
	public int getUmfang(){
		
		return breite*breite*höhe*höhe;
	}


	public int getBreite() {
		return breite;
	}

	public void setBreite(int breite) {
		if (breite >= 0) {
			this.breite = breite;
		}else {
			this.breite = 0;
		}
		
	}

	public int getHöhe() {
		return höhe;
	}

	public void setHöhe(int höhe) {
		if (höhe >= 0) {
			this.höhe = höhe;
		}else {
			this.höhe = 0;
		}
	}

}
