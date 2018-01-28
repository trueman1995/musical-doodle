package graph;

import java.util.Comparator;
import java.util.LinkedList;

/*
 * TODO edges als eigene klasse/2dimensionalen vector realisieren. Graphreder und konstruktor entsprechend anpassen. Identifikation von vertexes über ids und nicht mehr über indizes lösen. Unit tests schreiben, sammlung von beispielen anlegen. make files erstellen, dokumentation schreiben
 */

/**
 * @author Felix Armbruster felix_armbruster@t-online.de
 *
 *         This class represents a non weighted graph in object oriented Java/or
 *         allows only non-zero weights This Class currently is not very
 *         flexible, does not allow adding in vertex after creation etc. (maybe
 *         subject to change)
 *
 */
public class Graph {

	// TODO remove everything except list of vertexes
	// TODO refactoring of german names and identifiers
	private LinkedList<LinkedList<Vertex>> vorgaenger;
	private LinkedList<LinkedList<Vertex>> nachfolger;
	private LinkedList<Vertex> vertexlist;
	private int[][] edges;

	/**
	 * Constructor, creating a graph from a (weighted) Adjacency matrix
	 * 
	 * @param edges
	 *            matrix, containing ints representing connections between vertexes
	 */
	public Graph(int[][] edges) {
		this.vertexlist = new LinkedList<Vertex>();
		this.edges = edges;
		// initiales einfuegen aller knoten

		this.vorgaenger = new LinkedList<LinkedList<Vertex>>();
		this.nachfolger = new LinkedList<LinkedList<Vertex>>();

		for (int i = 0; i < edges.length; i++) {
			this.vertexlist.add(new Vertex(i));
			this.vorgaenger.add(new LinkedList<Vertex>());
			this.nachfolger.add(new LinkedList<Vertex>());

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
	 * Creates a graph from a file TODO create a regex for files
	 * 
	 * @param file
	 *            file to read from
	 */
	public Graph(String file) {
		this(GraphReader.getGraphFromFile(file));
	}

	/**
	 * @return returns a LinkedList of all vertexes of a graph
	 */
	public LinkedList<Vertex> getVertexlist() {
		return vertexlist;
	}

	/**
	 * @return returns a LinkedList containing all vorgaenger-LinkedLists
	 */
	public LinkedList<LinkedList<Vertex>> getvorgaenger() {
		return vorgaenger;
	}

	/**
	 * @return returns a LinkedList containing all nachfolger-LinkedLists
	 */
	public LinkedList<LinkedList<Vertex>> getNachfolger() {
		return nachfolger;
	}

	/**
	 * @param i
	 *            of the vertex in question
	 * @return a LinkedList of all vorgaengers of vertex i
	 */
	public LinkedList<Vertex> getvorgaenger(int i) {
		return vorgaenger.get(i);
	}

	/**
	 * @param i
	 *            of the vertex in question
	 * @return a LinkedList of all nachfolgers of vertex i
	 */
	public LinkedList<Vertex> getNachfolger(int i) {
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
		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		LinkedList<Vertex> visited = new LinkedList<Vertex>();
		queue.add(this.getVertexlist().get(start));
		this.vertexlist.get(start).setWaycost(0);

		while (!queue.isEmpty()) {
			queue.sort(Comparator.comparing(Vertex::getWaycost));
			Vertex currentVertex = queue.pop();
			visited.add(currentVertex);

			LinkedList<Vertex> currentNachfolger = this.getNachfolger(currentVertex.getNumber());
			for (int i = 0; i < currentNachfolger.size(); i++) {
				Vertex tmp_vertex = currentNachfolger.get(i);
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

		// TODO nice print

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

		LinkedList<LinkedList<Vertex>> tmp = this.getNachfolger();

		if (!tmp.get(start).isEmpty()) {

			Vertex current = tmp.get(start).get(0);
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

		LinkedList<LinkedList<Vertex>> tmp = this.getNachfolger();

		if (!tmp.get(start).isEmpty()) {
			Vertex current = tmp.get(start).get(0);

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

	// TODO kommentierung
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
		LinkedList<LinkedList<Vertex>> tmp = this.getNachfolger();

		if (!tmp.get(start).isEmpty()) {

			Vertex current = tmp.get(start).get(0);
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
