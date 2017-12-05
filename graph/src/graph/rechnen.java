package graph;

import java.util.LinkedList;

public class rechnen {

	public static void main(String[] args) {

		// graph mit Beispieldaten initialisieren und tiefen/breitensuche aufrufen

		final int num = 10;
		int[][] edges = new int[num][num];

		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges.length; j++) {
				edges[i][j] = 0;
			}
		}

		// an dieser stelle noch reader für textfile bauen
		// TODO
		// Javadoc machen
		edges[0][1] = 1;
		edges[0][4] = 1;
		edges[0][8] = 1;
		edges[1][2] = 1;
		edges[2][3] = 1;
		edges[4][5] = 1;
		edges[4][7] = 1;
		edges[5][6] = 1;
		edges[8][9] = 1;

		graph graph = new graph(num, edges);

		tiefensuche(graph, 0);

		System.out.println();

		breitensuche(graph, 0);

	}

	// ACHTUNG!! terminiert bei kreisen/ringen nicht!!!
	public static void tiefensuche(graph graph, int start) {

		LinkedList<LinkedList<vertex>> tmp = graph.getNachfolger();

		if (!tmp.get(start).isEmpty()) {

			vertex current = tmp.get(start).get(0);
			for (int i = 0; i < tmp.get(start).size(); i++) {
				System.out.println(current.number + "-->" + (tmp.get(start).get(i).number+1));
				tiefensuche(graph, tmp.get(start).get(i).number);
			}
		}
	}

	// ACHTUNG!! terminiert bei kreisen/ringen nicht!!!
	public static void breitensuche(graph graph, int start) {

		LinkedList<LinkedList<vertex>> tmp = graph.getNachfolger();

		if (!tmp.get(start).isEmpty()) {
			vertex current = tmp.get(start).get(0);

			for (int i = 0; i < tmp.get(start).size(); i++) {
				System.out.println(current.number + "-->" + (tmp.get(start).get(i).number+1));
			}

			for (int i = 0; i < tmp.get(start).size(); i++) {
				breitensuche(graph, tmp.get(start).get(i).number);
			}
		}
	}

}
