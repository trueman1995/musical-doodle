package graph;

import java.io.File;
import java.util.LinkedList;

/**
 * @author felix
 *
 */
public class graph {

	private LinkedList<LinkedList<vertex>> vorgaenger;
	private LinkedList<LinkedList<vertex>> nachfolger;
	private LinkedList<vertex> vertexlist;
	private int[][] edges;

	public graph(File name) {

	}

	/**
	 * @param vertex_num
	 * @param edges
	 */
	public graph(int vertex_num, int[][] edges) {
		LinkedList<vertex> vertexlist = new LinkedList<vertex>();
		this.edges = edges;
		// initiales einfuegen aller knoten

		vorgaenger = new LinkedList<LinkedList<vertex>>();
		nachfolger = new LinkedList<LinkedList<vertex>>();

		for (int i = 0; i < vertex_num; i++) {
			vertexlist.add(new vertex(i));
			vorgaenger.add(new LinkedList<vertex>());
			nachfolger.add(new LinkedList<vertex>());

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
	 * @return
	 */
	public LinkedList<vertex> getVertexlist() {
		return vertexlist;
	}

	/**
	 * @return
	 */
	public LinkedList<LinkedList<vertex>> getvorgaenger() {
		return vorgaenger;
	}

	/**
	 * @return
	 */
	public LinkedList<LinkedList<vertex>> getNachfolger() {
		return nachfolger;
	}

	/**
	 * @param i
	 * @return
	 */
	public LinkedList<vertex> getvorgaenger(int i) {
		return vorgaenger.get(i);
	}

	/**
	 * @param i
	 * @return
	 */
	public LinkedList<vertex> getNachfolger(int i) {
		return nachfolger.get(i);
	}

	/**
	 * @param i
	 * @param j
	 * @return
	 */
	public int getEdgeWeight(int i, int j) {
		return edges[i][j];
	}

}
