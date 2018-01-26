package graph;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author Felix Armbruster felix_armbruster@t-online.de
 *
 *         This class represents a non weighted graph in object oriented Java/or
 *         allows only non-zero weights This Class currently is not very
 *         flexible, does not allow adding in vertex after creation etc. (maybe
 *         subject to change)
 *
 */
public class graph {

	private LinkedList<LinkedList<vertex>> vorgaenger;
	private LinkedList<LinkedList<vertex>> nachfolger;
	private LinkedList<vertex> vertexlist;
	private int[][] edges;

	/**
	 * Constructor
	 *
	 * @param edges
	 *            matrix, containing ints representing connections between vertexes
	 */
	public graph(int[][] edges) {
		this.vertexlist = new LinkedList<vertex>();
		this.edges = edges;
		// initiales einfuegen aller knoten

		this.vorgaenger = new LinkedList<LinkedList<vertex>>();
		this.nachfolger = new LinkedList<LinkedList<vertex>>();

		for (int i = 0; i < edges.length; i++) {
			this.vertexlist.add(new vertex(i));
			this.vorgaenger.add(new LinkedList<vertex>());
			this.nachfolger.add(new LinkedList<vertex>());

		}

		// einfuegen der nachfolger/vorgaengerliste
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[0].length; j++) {
				if (edges[i][j] != 0) {
					nachfolger.get(i).add(vertexlist.get(j));
					vorgaenger.get(j).add(vertexlist.get(i));
				}
			}
		}
	}

	/**
	 * @param file
	 */
	public graph(String file) {
		this(GraphReader.getGraphFromFile(file));
	}

	/**
	 * @return returns a LinkedList of all vertexes of a graph
	 */
	public LinkedList<vertex> getVertexlist() {
		return vertexlist;
	}

	/**
	 * @return returns a LinkedList containing all vorgaenger-LinkedLists
	 */
	public LinkedList<LinkedList<vertex>> getvorgaenger() {
		return vorgaenger;
	}

	/**
	 * @return returns a LinkedList containing all nachfolger-LinkedLists
	 */
	public LinkedList<LinkedList<vertex>> getNachfolger() {
		return nachfolger;
	}

	/**
	 * @param index
	 *            of the vertex in question
	 * @return a LinkedList of all vorgaengers of vertex i
	 */
	public LinkedList<vertex> getvorgaenger(int i) {
		return vorgaenger.get(i);
	}

	/**
	 * @param index
	 *            of the vertex in question
	 * @return a LinkedList of all nachfolgers of vertex i
	 */
	public LinkedList<vertex> getNachfolger(int i) {
		return nachfolger.get(i);
	}

	/**
	 * @param i
	 *            vertex at start
	 * @param j
	 *            vertex at end
	 * @return returns the weight of the edge connecting vertex i with vertex j
	 *         NOTE: in a directioned graph is does matter wehre the edge starts,
	 *         and where it ends, in a non directioned it doesn't
	 */
	public int getEdgeWeight(int i, int j) {
		return edges[i][j];
	}

	/**
	 * resets the Waycosts of all vertexes in this graph (sets them to
	 * Integer.MAX_VALUE)
	 */
	private void resetWaycost() {
		for (int i = 0; i < vertexlist.size(); i++) {
			vertexlist.get(i).setWaycost(Integer.MAX_VALUE);
		}
	}

	/**
	 * resets the visited of all vertexes in this graph (sets them to false)
	 */
	private void resetVisited() {
		for (int i = 0; i < vertexlist.size(); i++) {
			vertexlist.get(i).setVisited(false);
		}
	}

	/**
	 * resets all predecessor and successor values of all vertexes in this graph
	 * (sets the to null)
	 */
	private void resetSuccessorPredecessor() {
		for (int i = 0; i < vertexlist.size(); i++) {
			vertexlist.get(i).setSuccessor(null);
			vertexlist.get(i).setPredecessor(null);
		}
	}

	/**
	 * Performs a waysearch starting from vertex with index 'start' ending at vertex
	 * with index 'end' using the greedy dijkstra algorithm.
	 * 
	 * As a result the predecessor and successor values of all vertex visited in the
	 * process are set.
	 * 
	 * 
	 * @param start
	 *            index of the vertex at the start
	 * @param end
	 *            index of the vertex at the end
	 */
	public void dijkstra(int start, int end) {

		this.resetWaycost();
		this.resetSuccessorPredecessor();
		LinkedList<vertex> queue = new LinkedList<vertex>();
		LinkedList<vertex> visited = new LinkedList<vertex>();
		queue.add(this.getVertexlist().get(start));
		this.vertexlist.get(start).setWaycost(0);

		while (!queue.isEmpty()) {
			queue.sort(Comparator.comparing(vertex::getWaycost));
			vertex currentVertex = queue.pop();
			visited.add(currentVertex);

			LinkedList<vertex> currentNachfolger = this.getNachfolger(currentVertex.getNumber());
			for (int i = 0; i < currentNachfolger.size(); i++) {
				vertex tmp_vertex = currentNachfolger.get(i);
				if (!visited.contains(tmp_vertex)) {
					int tmpEdgeweight = this.getEdgeWeight(currentVertex.getNumber(), tmp_vertex.getNumber());
					int tmpWaycost = currentVertex.getWaycost() + tmpEdgeweight;
					if (tmp_vertex.getWaycost() > tmpWaycost) {
						tmp_vertex.setWaycost(tmpWaycost);
						queue.add(tmp_vertex);
						tmp_vertex.setPredecessor(currentVertex);
						currentVertex.setSuccessor(tmp_vertex);
					}
				}
			}
		}

		/*
		 * System.out.println(ziel); vertex tmpVertex =
		 * graph.getVertexlist().get(ziel).getVorgänger();
		 * 
		 * while (tmpVertex != null) { System.out.println(tmpVertex.getNumber());
		 * tmpVertex = tmpVertex.getVorgänger(); }
		 */

	}

	/**
	 * Performs a broadsearch on this graph, starting on vertex with index 'start',
	 * ending at vertex with index 'end'. If there are cycles in this graph this
	 * method does NOT terminate, it recureses infinitely. All edges leading from
	 * 'start' to 'end' get printed to the commandline.
	 * 
	 * @param start
	 *            index of vertex at start
	 * 
	 * @param end
	 *            index of vertex at end (if end < -1 or doesn't fit a existing
	 *            vertex, all edges get printed)
	 */
	public void deepSearch(int start, int end) {

		LinkedList<LinkedList<vertex>> tmp = this.getNachfolger();

		if (!tmp.get(start).isEmpty()) {

			vertex current = tmp.get(start).get(0);
			for (int i = 0; i < tmp.get(start).size(); i++) {
				System.out.println(current.getNumber() + "-->" + (tmp.get(start).get(i).getNumber() + 1));
				deepSearch(tmp.get(start).get(i).getNumber(), end);
			}
		}
	}

	/**
	 * Performs a deepsearch on this graph, starting on vertex with index 'start',
	 * ending at vertex with index 'end'. If there are cycles in this graph this
	 * method does NOT terminate, it recureses infinitely. All edges leading from
	 * 'start' to 'end' get printed to the commandline.
	 * 
	 * @param start
	 *            index of vertex at start
	 * 
	 * @param end
	 *            index of vertex at end (if end < -1 or doesn't fit a existing
	 *            vertex, all edges get printed)
	 */
	public void broadSearch(int start, int end) {

		LinkedList<LinkedList<vertex>> tmp = this.getNachfolger();

		if (!tmp.get(start).isEmpty()) {
			vertex current = tmp.get(start).get(0);

			for (int i = 0; i < tmp.get(start).size(); i++) {
				System.out.println(current.getNumber() + "-->" + (tmp.get(start).get(i).getNumber() + 1));
			}

			for (int i = 0; i < tmp.get(start).size(); i++) {
				broadSearch(tmp.get(start).get(i).getNumber(), end);
			}
		}
	}

	/**
	 * Searches for cycles in this graph, using deepsearch.
	 * 
	 * @return true if cycles present, false otherwise
	 */
	public boolean cycleSearch() {
		return this.cycleSearch(0);
	}

	/**
	 * Searches for cycles in this graph, using deepsearch, starting at the first
	 * vertex of this graph.
	 * 
	 * @param start
	 *            index of the starting vertex
	 *
	 * @return true if cycles present, false otherwise
	 */
	public boolean cycleSearch(int start) {

		this.resetVisited();
		LinkedList<LinkedList<vertex>> tmp = this.getNachfolger();

		if (!tmp.get(start).isEmpty()) {

			vertex current = tmp.get(start).get(0);
			if (current.isVisited()) {
				return true;
			} else {
				for (int i = 0; i < tmp.get(start).size(); i++) {
					System.out.println(current.getNumber() + "-->" + (tmp.get(start).get(i).getNumber() + 1));
					cycleSearch(tmp.get(start).get(i).getNumber());
				}
			}
		}
		return false;
	}
}
