package fahrzeug;

import java.util.Scanner;

public class Spedition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fahrzeug brummi = new Fahrzeug("Brummi", 12000.0, 2.5);
		Fahrzeug flitzer = new Fahrzeug("Flitzer", 1000.0, 1.2);
		
		System.out.println("Preis bei 570km: "+ "Brummi: "+brummi.berechnePreis(570)+"€");
		System.out.println("Preis bei 570km: "+ "Flitzer: "+flitzer.berechnePreis(570)+"€");
		
		Fahrzeug[] array = new Fahrzeug[10];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = new Fahrzeug("Fahrzeug"+i, i*1000, i*1.75);
			//array[i].drucken();
		}
		
		System.out.println("gewicht?");
		Scanner sc = new Scanner(System.in);
		double gewicht = Double.parseDouble(sc.nextLine());
		
		System.out.println("wie weit?");
		double km = Double.parseDouble(sc.nextLine());
		sc.close();
		
		double bestpreis = -1;
		int fahrzeugindex = -1;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i].getZlg() >= gewicht && (bestpreis < 0 || array[i].berechnePreis(km) < bestpreis)){
				fahrzeugindex = i;
				bestpreis = array[i].berechnePreis(km);
			}
		}
		
		if (fahrzeugindex >= 0){
			array[fahrzeugindex].drucken();
		}else{
			System.out.println("Sorry, kein passendes Fahrzeug gefunden");
		}
		
	}

}
