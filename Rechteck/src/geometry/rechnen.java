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
		Rectangle l�ngs = new Rectangle(5, 3);


		System.out.println("Quer: " + quer.getH�he() + " hoch," + quer.getBreite()
				+ " breit");
		System.out.println("L�ngs: " + l�ngs.getH�he() + " hoch," + l�ngs.getBreite()
				+ " breit");

		int fl�che_quer = quer.getH�he() * quer.getBreite();
		int fl�che_l�ngs = l�ngs.getH�he() * l�ngs.getBreite();

		System.out.println("Fl�che Quer: " + fl�che_quer);
		System.out.println("Fl�che L�ngs: " + fl�che_l�ngs);
	}

}
