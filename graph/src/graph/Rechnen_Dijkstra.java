package graph;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Felix Armbruster felix_armbruster@t-online.de
 *
 *         This class implements the Dijkstra algorithm It reads a graph from a
 *         file, and preforms a fast waysearch from an vertex to another. These
 *         vertexes a specified in the file.
 *
 */
public class Rechnen_Dijkstra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		graph graph = GraphReader.getGraphFromFile("graph.txt");

		int start = 6;
		int ziel = 0;

		graph.getVertexlist().get(start).setWaycost(0);
		dijkstra(start, ziel, graph);

	}

	/**
	 * performs a waysearch using the dijkstra algorithm, on graph graph from vertex
	 * start to vertex ziel. Prints best way to console.
	 * 
	 * @param start
	 *            the vertex where to start
	 * @param ziel
	 *            the vertex where to end
	 * @param graph
	 *            the graph this is performed on
	 */
	private static void dijkstra(int start, int ziel, graph graph) {

		LinkedList<vertex> queue = new LinkedList<vertex>();
		LinkedList<vertex> visited = new LinkedList<vertex>();
		queue.add(graph.getVertexlist().get(start));
		graph.getVertexlist().get(start).setWaycost(0);

		while (!queue.isEmpty()) {
			queue.sort(Comparator.comparing(vertex::getWaycost));
			vertex currentVertex = queue.pop();
			visited.add(currentVertex);

			LinkedList<vertex> currentNachfolger = graph.getNachfolger(currentVertex.getNumber());
			for (int i = 0; i < currentNachfolger.size(); i++) {
				if (!visited.contains(currentNachfolger.get(i))) {
					int tmpEdgeweight = graph.getEdgeWeight(currentVertex.getNumber(),
							currentNachfolger.get(i).getNumber());
					int tmpWaycost = currentVertex.getWaycost() + tmpEdgeweight;
					if (currentNachfolger.get(i).getWaycost() > tmpWaycost) {
						currentNachfolger.get(i).setWaycost(tmpWaycost);
						queue.add(currentNachfolger.get(i));
						currentNachfolger.get(i).setVorgänger(currentVertex);
					}
				}
			}
		}

		System.out.println(ziel);
		vertex tmpVertex = graph.getVertexlist().get(ziel).getVorgänger();

		while (tmpVertex != null) {
			System.out.println(tmpVertex.getNumber());
			tmpVertex = tmpVertex.getVorgänger();
		}

	}

}
