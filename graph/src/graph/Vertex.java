package graph;

/**
 * @author felix
 *
 */
public class Vertex {

	// TODO umstellen auf liste ausgehender kanten.
	// TODO number --> ID
	private int number;
	private boolean visited = false;
	private int waycost = Integer.MAX_VALUE;
	// TODO remove
	private Vertex predecessor = null;
	private Vertex successor = null;

	/**
	 * @return
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @return
	 */
	public int getWaycost() {
		return waycost;
	}

	/**
	 * @param waycost
	 */
	public void setWaycost(int waycost) {
		this.waycost = waycost;
	}

	/**
	 * @return
	 */
	public Vertex getPredecessor() {
		return predecessor;
	}

	/**
	 * @param vorgänger
	 */
	public void setPredecessor(Vertex vorgänger) {
		this.predecessor = vorgänger;
	}

	/**
	 * @param number
	 */
	public Vertex(int number) {
		this.number = number;
	}

	/**
	 * @return
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * @param visited
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * @return
	 */
	public Vertex getSuccessor() {
		return successor;
	}

	/**
	 * @param nachfolger
	 */
	public void setSuccessor(Vertex nachfolger) {
		this.successor = nachfolger;
	}
}
