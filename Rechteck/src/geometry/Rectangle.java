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
	private int h�he;
	

	public Rectangle(int breite, int h�he) {
		this.setBreite(breite);
		this.setH�he(h�he);
	}
	
	public Rectangle(){
		this(1, 1);
	}
	
	public Rectangle(int kantenl�nge){
		this(kantenl�nge, kantenl�nge);
	}

	public void print() {
		System.out.println(this.h�he + " hoch," + this.breite + " breit");
	}

	public int getFlaeche() {
		return (this.breite * this.h�he);

	}

	public void anpassenGroesse(int dh�he, int dbreite) {
		this.h�he += dh�he;
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
		
		return breite*breite*h�he*h�he;
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

	public int getH�he() {
		return h�he;
	}

	public void setH�he(int h�he) {
		if (h�he >= 0) {
			this.h�he = h�he;
		}else {
			this.h�he = 0;
		}
	}

}
