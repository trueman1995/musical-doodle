package graph;

/**
 * @author Felix Armbruster felix_armbruster@t-online.de
 * 
 *         This class models Edges in a directed, weighted graph.
 *
 */
public class Edge {

	private int weight;
	private Vertex successor;

	/**
	 * Constructor, taking two parameters. Used in weighted graphs.
	 * 
	 * @param weight
	 *            the weight
	 * @param successor
	 *            the Vertex the Edge is pointing to
	 */
	public Edge(int weight, Vertex successor) {
		this.weight = weight;
		this.successor = successor;
	}

	/**
	 * Constructor, taking one parameter. Used for non-weighted graphs.
	 * 
	 * @param successor
	 *            the Vertex the Edge is pointing to
	 */
	public Edge(Vertex successor) {
		this(0, successor);
	}

	/**
	 * @return returns the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @return returns the Vertex the Edge is pointing to
	 */
	public Vertex getSuccessor() {
		return successor;
	}

	/**
	 * Sets the Vertex the Edge is ponting to
	 * 
	 * @param successor
	 *            the Vertex pointing to
	 */
	public void setSuccessor(Vertex successor) {
		this.successor = successor;
	}

	/**
	 * @return returns the ID of the Vertex this Edge is pointing to
	 */
	public String getID() {
		return this.successor.getID();
	}

	@Override
	public String toString() {
		return ("--> " + successor.getID());
	}
}
