package bank;

import java.util.*;

public class BankMain {
	
  // Hilfsmethode zum Erweitern einer Kontonummer auf 10 Stellen mit führenden Nullen
  public static String getKonto10(String kontoNr){
	  
	  // Sofern die Zusatzaufgabe 5a nicht bearbeitet wurde hier einfach die folgende Zeile aktivieren
	  // return kontoNr;
	  
	  // mit 5a:
	  String ext ="";
	  for(int i=0; i<(10-kontoNr.length()); i++){
		  ext += "0";
	  }
	  return ext+kontoNr;
  }
  
  public static void main(String[] args) {
    // neue Bank mit max. 3 Konten anlegen
    Bank karlsruher = new Bank("Karlsruher Testbank", "70090100", 3);

    // Testkonten anlegen
    String kNr;
    kNr = karlsruher.neuesKonto("Hugo", 124.76);
    kNr = karlsruher.neuesKonto("Fritz", 666.99);

    karlsruher.print();

    // interaktiven Test beginnen
    boolean ende = false;
    Scanner sc = new Scanner(System.in);

    while (!ende) {
      String kontoNr;
      double betrag;

      System.out.println("Ihre Auswahl? (n,l,u,p,i,v,e)");
      String eingabe = sc.nextLine();
      if (eingabe.length() > 0) {
        char auswahl = eingabe.charAt(0);

        switch (auswahl) {
        case 'n': // neues Konto anlegen
          System.out.println("neuer Inhaber?");
          String inhaber = sc.nextLine();

          System.out.println("Startguthaben?");
          betrag = sc.nextDouble();
          String nr = karlsruher.neuesKonto(inhaber, betrag);
          if (nr != null) {
            System.out.println("neue Kontonummer: " + nr);
          }
          break;
        case 'l': // Löschen bestehendes Konto
          System.out.println("Löschen Kontonummer? ");
          kontoNr = getKonto10(sc.nextLine());
          if (karlsruher.loescheKonto(kontoNr)) {
            System.out.println("Konto erfolgreich gelöscht");
          } else {
            System.out.println("Fehler bei löschen Konto:"
                + kontoNr);
          }
          break;
        case 'u': // Ueberweisung
          System.out.println("Überweisung auf Konto? ");
          kontoNr = getKonto10( sc.nextLine());
          System.out.println("Überweisungsbetrag?");
          betrag = sc.nextDouble();

          if (karlsruher.ueberweise(betrag, kontoNr)) {
            System.out.println("Überweisung erfolgreich");
          } else {
            System.out.println("Fehler bei Überweisung auf Konto"
                + kontoNr);
          }
          break;
        case 'p':
          karlsruher.print();
          break;
		// Sofern Zusatzaufgabe nicht bearbeitet folgenden case-Fall auskommentieren
        case 'i':
          System.out.println("IBAN von Konto?");
          kontoNr = getKonto10( sc.nextLine());
          GiroKonto test = new GiroKonto("Test", kontoNr, 0.0);
          System.out.println( test.getIBAN("de", karlsruher.getBLZ() ) );
          break;
        // Sofern Zusatzaufgabe nicht bearbeitet folgenden case-Fall auskommentieren
        case 'v':
          System.out.println("Bitte IBAN zur Validierung eingeben:");
          String iban = sc.nextLine();
          System.out.println( karlsruher.isValid(iban));
          break;
        case 'e':
          System.out.println("Ende Testprogramm...");
          ende = true;
          break;
        default:
          System.out.println("Falsche Auswahl");
          System.out.println(" n : neues Konto");
          System.out.println(" l : loeschen Konto");
          System.out.println(" u : Ueberweisung");
          System.out.println(" p : print Bankdaten");
          System.out.println(" i : IBAN ");
          System.out.println(" v : validiere IBAN");
          System.out.println(" e : Ende");
          break;
        }
      }
    }
  }
}
