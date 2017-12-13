package bank;

public class Bank {
	
	private String Name;
	private String Bankleitzahl;
	private GiroKonto[] GiroKonten;
	private String currentnumber = "111110";
	
	
	public Bank(String name, String bankleitzahl) {
		this(name, bankleitzahl, 10);
	}
	
	public Bank(String name, String bankleitzahl, int menge) {
		this.Name = name;
		this.Bankleitzahl = bankleitzahl;
		this.GiroKonten = new GiroKonto[menge];
	}
	
	public String neuesKonto(String inhaber, double betrag){
		
		for (int i = 1; i < GiroKonten.length; i++) {
			if (GiroKonten[i] == null){
				this.currentnumber = Integer.toString(Integer.parseInt(currentnumber)+1);
				GiroKonten[i] = new GiroKonto(inhaber, currentnumber, betrag);
				return currentnumber;
			}
		}
		return null;
	}
	
	public boolean loescheKonto(String nummer){
		
		for (int i = 0; i < GiroKonten.length; i++) {
			if(GiroKonten[i] != null &&nummer.equals(GiroKonten[i].getNummer())){
				GiroKonten[i] = null;
				return true;
			}
		}
		
		return false;
	}
	
	public boolean ueberweise(double betrag, String nummer){
		
		for (int i = 0; i < GiroKonten.length; i++) {
			if(GiroKonten[i] != null && nummer.equals(GiroKonten[i].getNummer())){
				//TODO addGuthaben() bauen
				GiroKonten[i].setGuthaben(GiroKonten[i].getGuthaben()+betrag);
				return true;
			}
		}
		
		return false;
	}

	
	public void print(){
		for (int i = 0; i < GiroKonten.length; i++) {
			if(GiroKonten[i] != null){
				GiroKonten[i].print();
			}
		}	
	}

	public String getBLZ() {
		// TODO Auto-generated method stub
		return this.Bankleitzahl;
	}

	public String isValid(String iban) {
		// TODO Auto-generated method stub
		return "valid";
	}
	
	
}
