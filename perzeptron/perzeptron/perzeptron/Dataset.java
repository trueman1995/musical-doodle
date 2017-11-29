package perzeptron;

public class Dataset {
	private int anzahlBeispiele;

	public double[] input0;
	public double[] input1;
	
	public int[] output;
	
	public int getAnzahlBeispiele() {
		return anzahlBeispiele;
	}

	public Dataset(int anzahlBeispiele) {
		this.anzahlBeispiele=anzahlBeispiele;

		//Arraylänge angeben
		input0 = new double[anzahlBeispiele];
		input1 = new double[anzahlBeispiele];
		output = new int[anzahlBeispiele];

		// Set Klasse 0 - Zufallszahlen generieren
		for (int i = 0; i < anzahlBeispiele ; i+=2) {
			input0[i] = zufallsZahl(-0.5, 0); 
			input1[i] = zufallsZahl(0, 1);
			output[i] = 0;

		}
		// Set Klasse 1 - Zufallszahlen generieren
		for (int i = 1; i < anzahlBeispiele; i+=2) {
			input0[i] = zufallsZahl(0.01, 0.5);
			input1[i] = zufallsZahl(0, 1);
			output[i] = 1;

		}


	}

    private static double zufallsZahl(double min, double max){
        return  min+Math.random()*(max-min);
    }

}
