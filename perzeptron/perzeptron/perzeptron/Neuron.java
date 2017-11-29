package perzeptron;

public class Neuron {

	private double[] gewicht = new double[3]; // gewicht[2] = bias => 2 Inputs für das Neuron

	private double schwellwert=0;
	private double lernrate=0.01;

	//Konstruktor - setze Gewichte mit Zufallszahlen 

	public Neuron() {
		this.gewicht[0] = Math.random();
		this.gewicht[1] = Math.random();
		this.gewicht[2] = Math.random();
	}

	// Getter für Gewichte
	public double[] getGewicht() {
		return gewicht;
	}

	//Lernalgorithmus
	public double trainiere(Dataset trainingsdaten) {
		double error, globalError=0;

		for (int i = 0; i < trainingsdaten.getAnzahlBeispiele(); i++) {


			// Unterschied zwischen gewünschtem und angenommenen Output
			error = trainingsdaten.output[i] - berechneOutput(trainingsdaten.input0[i], trainingsdaten.input1[i]);;

			// Gewichte verändern
			gewicht[0] += lernrate * error * trainingsdaten.input0[i];
			gewicht[1] += lernrate * error * trainingsdaten.input1[i];
			// Bias also gewicht[2] ändern
			gewicht[2] += lernrate * error;

			//Globaler Error berechnen
			globalError += error*error;

		}
		return globalError;
	}



	public double berechneOutput(double input0, double input1) {
		double summe =  input0* gewicht[0] + input1 * gewicht[1] + gewicht[2];
		if(summe >= schwellwert){
			return 1; 
		}
		else{
			return 0;
		}
	}

}