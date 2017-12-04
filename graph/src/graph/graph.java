package graph;

import java.io.File;
import java.util.LinkedList;

public class graph {
	
	LinkedList<LinkedList<vertex>> vorgaenger;
	LinkedList<LinkedList<vertex>> nachfolger;
	
	public graph(File name){
		
	}
	
	public graph(int vertex_num, int[][] edges){
		LinkedList<vertex> tmp = new LinkedList<vertex>();
		//initiales einf�gen aller knoten
		

		vorgaenger = new LinkedList<LinkedList<vertex>>();
		nachfolger = new LinkedList<LinkedList<vertex>>();
		
		
		for (int i = 0; i < vertex_num; i++) {
			tmp.add(new vertex(i));
			
			
			vorgaenger.add(tmp);
			nachfolger.add(tmp);
		}
		
		//einf�gen der nachfolger/vorgaengerliste
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[0].length; j++) {
				if (edges[i][j] != 0) {
					nachfolger.get(i).add(tmp.get(j));
					vorgaenger.get(j).add(tmp.get(i));
				}
			}
		}
	}

	public LinkedList<LinkedList<vertex>> getvorgaenger() {
		return vorgaenger;
	}

	public LinkedList<LinkedList<vertex>> getNachfolger() {
		return nachfolger;
	}
	
	public LinkedList<vertex> getvorgaenger(int i) {
		return vorgaenger.get(i);
	}

	public LinkedList<vertex> getNachfolger(int i) {
		return nachfolger.get(i);
	}
	
	
}
