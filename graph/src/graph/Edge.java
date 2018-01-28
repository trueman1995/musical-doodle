package graph;

/**
 * @author felix
 *
 */
public class Edge {

	private int weight;
	private Vertex successor;

	/**
	 * @param weight
	 * @param successor
	 */
	public Edge(int weight, Vertex successor) {
		this.weight = weight;
		this.successor = successor;
	}

	/**
	 * @param successor
	 */
	public Edge(Vertex successor) {
		this(0, successor);
	}

	/**
	 * @return
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @param deltaWeight
	 */
	public void increaseWeight(int deltaWeight) {
		this.weight += deltaWeight;
	}

	/**
	 * @return
	 */
	public Vertex getSuccessor() {
		return successor;
	}

	/**
	 * @param successor
	 */
	public void setSuccessor(Vertex successor) {
		this.successor = successor;
	}

}
