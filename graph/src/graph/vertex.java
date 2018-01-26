package graph;

public class vertex {

	private int number;
	// private int value = 0;
	private boolean visited = false;

	private int waycost = Integer.MAX_VALUE;
	private vertex predecessor = null;
	private vertex successor = null;

	public int getNumber() {
		return number;
	}

	public int getWaycost() {
		return waycost;
	}

	public void setWaycost(int waycost) {
		this.waycost = waycost;
	}

	public vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(vertex vorgänger) {
		this.predecessor = vorgänger;
	}

	public vertex(int number) {
		this.number = number;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public vertex getSuccessor() {
		return successor;
	}

	public void setSuccessor(vertex nachfolger) {
		this.successor = nachfolger;
	}
}
