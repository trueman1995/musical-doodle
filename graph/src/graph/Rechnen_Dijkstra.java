package graph;

import java.util.Iterator;
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

	static LinkedList<vertex> not_visited = new LinkedList<vertex>();
	static LinkedList<vertex> visited = new LinkedList<vertex>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Reader fertig machen

		graph graph = GraphReader.getGraphFromFile("/local/armbruster/downloads/dijkstra/graph.txt");

		int start = 8;
		int ziel = 1;

		not_visited.addAll(graph.getVertexlist());

		graph.getVertexlist().get(start).setWaycost(0);
		dijkstra(start, ziel, graph);

		// printout visited list

	}

	/**
	 * performs a waysearch using the dijkstra algorithm, on graph graph from vertex
	 * start to vertex ziel
	 * 
	 * @param start
	 *            the vertex where to start
	 * @param ziel
	 *            the vertex where to end
	 * @param graph
	 *            the graph this is performed on
	 */
	private static void dijkstra(int start, int ziel, graph graph) {

		vertex start_vertex = graph.getVertexlist().get(start);
		start_vertex.setVisited(true);
		visited.add(not_visited.remove(start_vertex.getNumber()));

		if (start_vertex.getNumber() == ziel) {
			return;
		}

		while (!not_visited.isEmpty()) {

			LinkedList<vertex> tmp = graph.getNachfolger(start);

			for (Iterator<vertex> iterator = tmp.iterator(); iterator.hasNext();) {
				vertex vertex = (vertex) iterator.next();

				if (!vertex.isVisited()) {
					int tmp_waycost = start_vertex.getWaycost() + graph.getEdgeWeight(ziel, vertex.getNumber());

					if (vertex.getWaycost() == -1 || tmp_waycost < vertex.getWaycost()) {
						vertex.setWaycost(tmp_waycost);
					}
				}

			}

		}

	}

}
