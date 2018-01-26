package cycleDetection;

import java.util.ArrayList;

public class Graph {
	
	private boolean[][] adjacencyMatrix;
	private int numberOfVertices;
	private boolean[] visited;
	private boolean[] finished;
	
	private boolean foundCycle = false;	
	
	public Graph(int numberOfVertices){
		adjacencyMatrix = new boolean[numberOfVertices][numberOfVertices];
		visited = new boolean[numberOfVertices];
		finished = new boolean[numberOfVertices];
		
		this.numberOfVertices = numberOfVertices;
		
		for(int i = 0; i < numberOfVertices; i++){
			for(int j = 0; j < numberOfVertices; j++){
				adjacencyMatrix[i][j] = false;
			}
			
			visited[i] = false;
			finished[i] = false;
		}		
	}
	
	/* Stellt Nachbarschaftsverbindung zwischen zwei Vertizes her:
	 * Wenn diese Methode aufgerufen wird, führt eine gerichtete Kante vom ersten Vertex zum zweiten Vertex. */
	public void setAdjacency(int predecessor, int successor){
		adjacencyMatrix[predecessor][successor] = true;		
	}
	
	/* Gibt eine Liste der Nachfolger-Vertizes zurück */
	public ArrayList<Integer> getSuccessors(int vertex){
		ArrayList<Integer> successors = new ArrayList<Integer>();
		
		for(int i = 0; i < numberOfVertices; i++){
			if(adjacencyMatrix[vertex][i] == true){
				successors.add(i);				
			}
		}	
		
		return successors;
	}
	
	/* Implementierung der modifizierten Tiefensuche */
	public void modifiedDFS(int vertex){
		if(finished[vertex]){
			return;
		}else if(visited[vertex]){
			foundCycle = true;
			return;
		}else{
			visited[vertex] = true;
			ArrayList<Integer> successors = getSuccessors(vertex);
			for(int i = 0; i < successors.size(); i++){
				modifiedDFS(successors.get(i));
			}
			finished[vertex] = true;			
		}
	}	
	
	/* Führt modifizierte Tiefensuche für alle Vertizes aus */
	public void searchCycle(){
		for(int i = 0; i < numberOfVertices; i++){
			modifiedDFS(i);
		}		
	}
	
	/* Gibt nach dem Durchlauf des Suchalgorithmus aus, ob ein Zyklus gefunden wurde */
	public boolean hasCycleBeenDetected(){
		return foundCycle;
	}
	
	

}
