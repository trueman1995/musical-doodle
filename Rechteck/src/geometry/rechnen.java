/**
 * 
 */
package geometry;

/**
 * @author armb_9527
 *
 */
public class rechnen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle quer = new Rectangle(2, 7);
		Rectangle längs = new Rectangle(5, 3);


		System.out.println("Quer: " + quer.getHöhe() + " hoch," + quer.getBreite()
				+ " breit");
		System.out.println("Längs: " + längs.getHöhe() + " hoch," + längs.getBreite()
				+ " breit");

		int fläche_quer = quer.getHöhe() * quer.getBreite();
		int fläche_längs = längs.getHöhe() * längs.getBreite();

		System.out.println("Fläche Quer: " + fläche_quer);
		System.out.println("Fläche Längs: " + fläche_längs);
	}

}
