package graph;

import java.io.File;
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

}
