package bank;

public class TestEins {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank KarlsruheBank = new Bank("KarlsruheBank", "76131", 10);
		
		for (int i = 0; i < 10; i++) {
			KarlsruheBank.neuesKonto("inhaber "+i, 554*i);
		}
		
		KarlsruheBank.loescheKonto("111117");
		KarlsruheBank.ueberweise(80, "111114");
		KarlsruheBank.print();
	}

}
