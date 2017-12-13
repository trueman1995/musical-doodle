import java.util.Scanner;

/**
 * 
 */

/**
 * @author armb_9527
 *
 */
public class SSP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Variablen-Deklaration
		char spielerWahl;
		char pcWahl = '0';
		int PunkteSpieler = 0;
		int PunktePC = 0;

		// Spielablauf

		while (PunkteSpieler < 3 && PunktePC < 3) {
			// Eingabe und Zufallsgeneration

			System.out.println("Wählen Sie Ihre Waffe (P, S, X)");
			
			Scanner sc = new Scanner(System.in);
			spielerWahl = sc.nextLine().charAt(0);

			int tmp = (int) (Math.random() * 3);
			switch (tmp) {
			case 0:
				pcWahl = 'P';
				break;

			case 1:
				pcWahl = 'S';
				break;

			case 2:
				pcWahl = 'X';
				break;

			default:
				break;
			}
			// Ausgabe der Eingaben

			System.out.println("Spielerwahl: " + spielerWahl + "; "
					+ "PCWahl: " + pcWahl);

			// Entscheidung des Siegers
			if (pcWahl != spielerWahl) {

				if (compare(spielerWahl, pcWahl)) {
					PunkteSpieler++;
					
					System.out.println("Spieler siegt, Zwischenstand: "
							+ PunkteSpieler + " : " + PunktePC);
				} else {
					PunktePC++;
					
					System.out.println("PC siegt, Zwischenstand: "
							+ PunkteSpieler + " : " + PunktePC);
				}

			} else {
				// Ausgabe 'Unentschieden,zwischenstand'
				System.out.println("Unentschieden, Zwischenstand: "
						+ PunkteSpieler + " : " + PunktePC);

			}
		}
		
		System.out.println("Wir haben einen Sieger:");
		
		if(PunkteSpieler>PunktePC){
			System.out.println("Spieler war siegreich");
		}else{
			System.out.println("PC hat triumphiert");
		}

	}

	private static boolean compare(char spielerWahl, char pcWahl) {

		if ((spielerWahl == 'P' && pcWahl == 'X')
				| (spielerWahl == 'S' && pcWahl == 'P')
				| (spielerWahl == 'X' && pcWahl == 'S')) {
			return true;
		} else {
			return false;
		}

	}

}
