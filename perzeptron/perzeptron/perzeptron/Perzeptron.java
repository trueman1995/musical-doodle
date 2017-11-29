package perzeptron;

public class Perzeptron {

	public static void main(String[] args) {

		Dataset trainingsdaten = new Dataset(10000);
		Dataset testdaten = new Dataset(100000);


		Neuron superNeuron = new Neuron();


		//Trainiere Neuron mit Trainingsdaten
		int anzahlEpochen = 0;
		double globalError;

		do{
			anzahlEpochen++;

			globalError = superNeuron.trainiere(trainingsdaten);

			System.out.println("Epoche "+anzahlEpochen+" : Fehler = "+Math.sqrt(globalError/trainingsdaten.getAnzahlBeispiele()));

		}while(globalError !=0 && anzahlEpochen < 200);

		//Überprüfe Neuron mit den Testdaten
		int treffer = 0;
		for(int i =0; i< testdaten.getAnzahlBeispiele();i++){
			if(superNeuron.berechneOutput(testdaten.input0[i], testdaten.input1[i]) == testdaten.output[i]){
				treffer++;
			}
		}
		//Anzahl von Treffern
		System.out.println("\nTreffer bei "+testdaten.getAnzahlBeispiele()+" Beispielen: "+ treffer);

	}

}