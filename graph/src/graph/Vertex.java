package graph;

import java.util.LinkedList;

/**
 * @author Felix Armbruster felix_armbruster@t-online.de
 * 
 *         This class models a vertex of a graph.
 *
 */
public class Vertex {

	private static final int WAYCOST_DEFAULT = Integer.MAX_VALUE;
	private String ID;
	private boolean visited;
	private int waycost;
	private LinkedList<Edge> successor;
	private Vertex predecessor;

	/**
	 * Constructor taking the ID of the graph as parameter.
	 * 
	 * @param ID
	 *            ID of the graph to create
	 */
	public Vertex(String ID) {
		this.ID = ID;
		successor = new LinkedList<Edge>();
		this.waycost = WAYCOST_DEFAULT;
		this.visited = false;
	}

	/**
	 * Returns a list of outgoing edges.
	 * 
	 * @return the list of all outgoing edges
	 */
	public LinkedList<Edge> getSuccessor() {
		return successor;
	}

	/**
	 * Returns the ID of this vertex
	 * 
	 * @return the ID
	 */
	public String getID() {
		return this.ID;
	}

	/**
	 * Returns the waycost calculated in the graph via dijkstra TODO: Subject to
	 * change, should be stored in graph rather than in vertex.
	 * 
	 * @return the waycost
	 */
	public int getWaycost() {
		return waycost;
	}

	/**
	 * Sets the waycost.
	 * 
	 * @param waycost
	 *            the waycost to set
	 */
	public void setWaycost(int waycost) {
		this.waycost = waycost;
	}

	/**
	 * Returns whether the vertex was visited during different graph operations.
	 * TODO: subject to change, will be stored in graph rather than here.
	 * 
	 * @return visited
	 */
	public boolean isVisited() {
		return visited;
	}

	/**
	 * Sets the visited attribute.
	 * 
	 * @param visited
	 *            whether the vertex was visited or not
	 */
	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	/**
	 * Adds a outgoing Edge to the list.
	 * 
	 * @param successor
	 *            Edge to be added
	 */
	public void addSuccessor(Edge successor) {
		this.successor.add(successor);
	}

	/**
	 * Looks for an outgoing Edge to a specific Vertex.
	 * 
	 * @param ID
	 *            Vertex to be looked for
	 * @return returns either the Edge in question, or null, if none found
	 */
	public Edge getEdge(String ID) {
		for (int i = 0; i < successor.size(); i++) {
			Edge result = successor.get(i);
			if (result.getID().equals(ID)) {
				return result;
			}
		}
		return null;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}

	/**
	 * Resets the waycost to the default value.
	 */
	public void resetWaycost() {
		this.waycost = WAYCOST_DEFAULT;
	}

	@Override
	public String toString() {
		String tmp = " [";
		for (Edge edge : successor) {
			tmp = tmp + edge.toString() + " ";
		}
		tmp = tmp + "]";
		return (this.ID + tmp);
	}

	/**
	 * Returns the predecessor attribute, only used in the Dijkstra algorithm in the
	 * Graph class. TODO: Subject to change, will be moved to the graph class.
	 * 
	 * @return retruns the predecessor
	 */
	public Vertex getPredecessor() {
		return predecessor;
	}

	/**
	 * Sets the predecessor attribute.
	 * 
	 * @param predecessor
	 *            the predecessor to be set
	 */
	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

}
