package graph;

public class vertex {

	private int number;
	// private int value = 0;
	private boolean visited = false;

	private int waycost = -1;
	private vertex vorgänger;

	public int getNumber() {
		return number;
	}

	public int getWaycost() {
		return waycost;
	}

	public void setWaycost(int waycost) {
		this.waycost = waycost;
	}

	public vertex getVorgänger() {
		return vorgänger;
	}

	public void setVorgänger(vertex vorgänger) {
		this.vorgänger = vorgänger;
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
}
