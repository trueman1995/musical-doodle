package cycleDetection;

import java.io.IOException;

public class GraphSearch {

	public static void main(String[] args) throws IOException {
		
		/* Beispiele ohne File-Reader*/
		
//		/* Beispiel 1: Beispiel von Blatt */
//		Graph graph1 = new Graph(5);
//		graph1.setAdjacency(0, 1);
//		graph1.setAdjacency(0, 2);
//		graph1.setAdjacency(1, 3);
//		graph1.setAdjacency(2, 3);
//		graph1.setAdjacency(3, 4);
//		graph1.setAdjacency(4, 1);
//		graph1.searchCycle();
//		if(graph1.hasCycleBeenDetected()){
//			System.out.println("Zyklus wurde gefunden!");
//		}else{
//			System.out.println("Zyklus wurde nicht gefunden!");
//		}
//		
//		/* Beispiel 2: Beispiel von Blatt ohne Knoten E */
//		Graph graph2 = new Graph(5);
//		graph2.setAdjacency(0, 1);
//		graph2.setAdjacency(0, 2);
//		graph2.setAdjacency(1, 3);
//		graph2.setAdjacency(2, 3);
//		graph2.searchCycle();
//		if(graph2.hasCycleBeenDetected()){
//			System.out.println("Zyklus wurde gefunden!");
//		}else{
//			System.out.println("Zyklus wurde nicht gefunden!");
//		}
//		
//		/* Beispiel 3: A -> B -> C -> D -> E -> A*/
//		Graph graph3 = new Graph(5);
//		graph3.setAdjacency(0, 1);
//		graph3.setAdjacency(1, 2);
//		graph3.setAdjacency(2, 3);
//		graph3.setAdjacency(3, 4);
//		graph3.setAdjacency(4, 0);
//		graph3.searchCycle();
//		if(graph3.hasCycleBeenDetected()){
//			System.out.println("Zyklus wurde gefunden!");
//		}else{
//			System.out.println("Zyklus wurde nicht gefunden!");
//		}
		
		
		/* Beispiele mit File-Reader */
		Input input = new Input();
		input.readTextFile("text.txt");
		Graph graph = input.getGraph();
		
		graph.searchCycle();
		if(graph.hasCycleBeenDetected()){
			System.out.println("Zyklus wurde gefunden!");
		}else{
			System.out.println("Zyklus wurde nicht gefunden!");
		}
		
		Input input2 = new Input();
		input2.readTextFile("text1.txt");
		Graph graph2 = input2.getGraph();
		
		graph2.searchCycle();
		if(graph2.hasCycleBeenDetected()){
			System.out.println("Zyklus wurde gefunden!");
		}else{
			System.out.println("Zyklus wurde nicht gefunden!");
		}
		
		Input input3 = new Input();
		input3.readTextFile("text2.txt");
		Graph graph3 = input3.getGraph();
		
		graph3.searchCycle();
		if(graph3.hasCycleBeenDetected()){
			System.out.println("Zyklus wurde gefunden!");
		}else{
			System.out.println("Zyklus wurde nicht gefunden!");
		}
		
		Input input4 = new Input();
		input4.readTextFile("text3.txt");
		Graph graph4 = input4.getGraph();
		
		graph4.searchCycle();
		if(graph4.hasCycleBeenDetected()){
			System.out.println("Zyklus wurde gefunden!");
		}else{
			System.out.println("Zyklus wurde nicht gefunden!");
		}
		
	}

}
