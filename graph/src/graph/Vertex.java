package graph;

public class Vertex {

	private int number;
	// private int value = 0;
	private boolean visited = false;

	private int waycost = Integer.MAX_VALUE;
	private Vertex predecessor = null;
	private Vertex successor = null;

	public int getNumber() {
		return number;
	}

	public int getWaycost() {
		return waycost;
	}

	public void setWaycost(int waycost) {
		this.waycost = waycost;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex vorgänger) {
		this.predecessor = vorgänger;
	}

	public Vertex(int number) {
		this.number = number;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getSuccessor() {
		return successor;
	}

	public void setSuccessor(Vertex nachfolger) {
		this.successor = nachfolger;
	}
}
