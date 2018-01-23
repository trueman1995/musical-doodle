package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
		// TODO Reader fertig machen

		graph graph = GraphReader.getGraphFromFile("/local/armbruster/downloads/dijkstra/graph.txt");

		int start = 6;
		int ziel = 0;

		graph.getVertexlist().get(start).setWaycost(0);
		dijkstra(start, ziel, graph);

		// printout visited list

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
		// TODO dijkstra implementieren
	}

}
