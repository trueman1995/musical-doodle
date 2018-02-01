package graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * 
 * @author Felix Armbruster felix_armbruster@t-online.de
 *
 *         This class represents a weighted, directed graph in object oriented
 *         Java.
 *
 */
public class Graph {

	private LinkedList<Vertex> vertexlist;
	// global variable, to stop recursion if needed
	private boolean stopRecursion = false;
	private boolean hasCycles = false;

	/**
	 * Constructor, creating a graph from a (weighted) Adjacency matrix. Usage is
	 * discouraged.
	 * 
	 * @param edges
	 *            matrix, containing ints representing connections between vertices
	 */
	@Deprecated
	public Graph(int[][] edges) {
		this.vertexlist = new LinkedList<Vertex>();
		// initiales einfuegen aller knoten

		for (int i = 0; i < edges.length; i++) {
			this.vertexlist.add(new Vertex(Integer.toString(i)));
		}

		// einfuegen der nachfolger/vorgaengerliste
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[0].length; j++) {
				if (edges[i][j] != 0) {
					getVertex(Integer.toString(i)).addSuccessor(new Edge(edges[i][j], getVertex(Integer.toString(j))));
				}
			}
		}
	}

	/**
	 * Creates a graph from a file. TODO: create a template/example/regex for valid
	 * files.
	 * 
	 * @param file
	 *            file to read from
	 */
	public Graph(String file) {
		this.vertexlist = new LinkedList<Vertex>();
		this.fillGraphFromFile(file);

	}

	/**
	 * @return returns a LinkedList of all vertices of a graph
	 */
	public LinkedList<Vertex> getVertexlist() {
		return vertexlist;
	}

	/**
	 * @param i
	 *            vertex at start
	 * @param j
	 *            vertex at end
	 * @return returns the weight of the edge connecting vertex i with vertex j
	 *         NOTE: in a directed graph is does matter where the edge starts, and
	 *         where it ends, in a non directed it doesn't
	 */
	public int getEdgeWeight(String ID_start, String ID_end) {
		return getVertex(ID_start).getEdge(ID_end).getWeight();
	}

	/**
	 * Resets the Waycosts of all vertices in this graph (sets them to
	 * Integer.MAX_VALUE)
	 */
	private void resetWaycost() {
		for (int i = 0; i < vertexlist.size(); i++) {
			vertexlist.get(i).resetWaycost();
		}
	}

	/**
	 * Resets the visited of all vertices in this graph (sets them to false)
	 
	private void resetVisited() {
		for (int i = 0; i < vertexlist.size(); i++) {
			vertexlist.get(i).setVisited(false);
		}
	}*/

	/**
	 * Performs a waysearch starting from vertex with index 'start' ending at vertex
	 * with index 'end' using the greedy dijkstra algorithm.
	 * 
	 * As a result the predecessor and successor values of all vertex visited in the
	 * process are set
	 * 
	 * Prints the result to the console.
	 * 
	 * 
	 * @param start
	 *            index of the vertex at the start
	 * @param end
	 *            index of the vertex at the end
	 */
	public void dijkstra(String ID_start, String ID_end) {

		this.resetWaycost();

		LinkedList<Vertex> queue = new LinkedList<Vertex>();
		LinkedList<Vertex> visited = new LinkedList<Vertex>();
		queue.add(this.getVertex(ID_start));
		getVertex(ID_start).setWaycost(0);

		while (!queue.isEmpty()) {
			queue.sort(Comparator.comparing(Vertex::getWaycost));
			Vertex currentVertex = queue.pop();
			visited.add(currentVertex);

			LinkedList<Edge> currentSuccessor = currentVertex.getSuccessor();

			for (Edge edge : currentSuccessor) {
				Vertex tmp_Vertex = edge.getSuccessor();
				if (!visited.contains(tmp_Vertex)) {
					int tmpWaycost = currentVertex.getWaycost() + edge.getWeight();
					if (tmp_Vertex.getWaycost() > tmpWaycost) {
						tmp_Vertex.setWaycost(tmpWaycost);
						tmp_Vertex.setPredecessor(currentVertex);
						queue.add(tmp_Vertex);
					}
				}
			}
		}
		// printout
		Vertex tmp_vertex = getVertex(ID_end);
		String tmp = tmp_vertex.getID();
		tmp_vertex = tmp_vertex.getPredecessor();
		while (tmp_vertex != null) {
			tmp = tmp_vertex.getID() + " --> " + tmp;
			tmp_vertex = tmp_vertex.getPredecessor();
		}
		System.out.println(tmp);
	}

	/**
	 * Performs a deepsearch on this graph, starting on the first vertex , ending at
	 * vertex with index 'end'. If there are cycles in this graph this method does
	 * NOT terminate. All edges leading from 'start' to 'end' get printed to the
	 * commandline.
	 * 
	 * @param end
	 *            index of vertex at end (if end < -1 or doesn't fit a existing
	 *            vertex, all edges get printed)
	 */
	public void deepSearch(String ID_end) {
		stopRecursion = false;
		deepSearch(vertexlist.getFirst().getID(), ID_end);
	}

	/**
	 * Performs a broadsearch on this graph, starting on vertex with index 'start',
	 * ending at vertex with index 'end'. If there are cycles in this graph this
	 * method does NOT terminate. All edges leading from 'start' to 'end' get
	 * printed to the commandline. This method is not to be invoked directly
	 * 
	 * @param start
	 *            index of vertex at start
	 * 
	 * @param end
	 *            index of vertex at end (if end < -1 or doesn't fit a existing
	 *            vertex, all edges get printed)
	 */
	private void deepSearch(String ID_start, String ID_end) {

		LinkedList<Edge> tmpEgdes = getVertex(ID_start).getSuccessor();
		for (Edge tmp_edge : tmpEgdes) {
			if (!stopRecursion) {
				System.out.println(ID_start + " " + tmp_edge.toString());
				if (!tmp_edge.getID().equals(ID_end)) {
					deepSearch(tmp_edge.getID(), ID_end);
				} else {
					stopRecursion = true;
				}

			}
		}

	}

	/**
	 * Performs a broadsearch on this graph, starting on the first vertex , ending
	 * at vertex with index 'end'. If there are cycles in this graph this method
	 * does NOT terminate. All edges leading from 'start' to 'end' get printed to
	 * the commandline.
	 * 
	 * @param end
	 *            index of vertex at end (if end < -1 or doesn't fit a existing
	 *            vertex, all edges get printed)
	 */
	public void broadSearch(String ID_end) {
		stopRecursion = false;
		broadSearch(vertexlist.getFirst().getID(), ID_end);
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
	private void broadSearch(String ID_start, String ID_end) {
		LinkedList<Edge> tmpEgdes = getVertex(ID_start).getSuccessor();

		for (Edge tmp_edge : tmpEgdes) {

			System.out.println(ID_start + " " + tmp_edge.toString());

			if (tmp_edge.getID().equals(ID_end)) {
				stopRecursion = true;
				break;
			}

		}
		if (!stopRecursion) {
			for (Edge tmp_edge : tmpEgdes) {

				broadSearch(tmp_edge.getID(), ID_end);
			}

		}
	}

	/**
	 * Searches for cycles in this graph, using deepsearch, starting a the first
	 * vertex.
	 * 
	 * @return true if cycles present, false otherwise
	 */
	public boolean cycleSearch() {
		// resets all visited fields in all vertices, also both global variables
		this.resetWorkinProgress();
		stopRecursion = false;
		hasCycles = false;
		// calls the recursive cycleSearch on the first vertex of this graph
		this.cycleSearch(vertexlist.getFirst().getID());
		return hasCycles;
	}

	private void resetWorkinProgress() {
		// TODO Auto-generated method stub
		for (Vertex vertex : vertexlist) {
			vertex.setWorkInProgress(0);
		}
	}

	/**
	 * Searches for cycles in this graph, using deepsearch, starting at the vertex
	 * with ID ID_start.
	 * 
	 * @param start
	 *            index of the starting vertex
	 *
	 * @return true if cycles present, false otherwise
	 */
	private void cycleSearch(String ID_start) {
		// takes all outgoing Edges of the starting vertex
		LinkedList<Edge> tmpEgdes = getVertex(ID_start).getSuccessor();
		Vertex tmp = getVertex(ID_start);
		// Iterates over all outgoing edges, if a already encountered vertex is
		// encountered again while currently being not finished, we have a cycle. The
		// hasCycles flag is set since we don't need to look further.
		// A While loop would fit better probably but in that case an Iterator or a
		// counter variable would be needed, so not much is gained from this
		// optimization.
		if (tmp.getWorkInProgress() == 0) {
			for (Edge tmp_edge : tmpEgdes) {
				if (!hasCycles) {
					tmp.setWorkInProgress(1);
					cycleSearch(tmp_edge.getID());
				}
			}
			
		} else if (tmp.getWorkInProgress() == 1) {
			hasCycles = true;
		}

		tmp.setWorkInProgress(2);
	}

	/**
	 * Returns the vertex with the corresponding ID or null, if none is found.
	 * 
	 * @param ID
	 *            the ID of the vertex we look for
	 * @return either the vertex looked for or null if none found
	 */
	public Vertex getVertex(String ID) {
		for (int i = 0; i < vertexlist.size(); i++) {
			Vertex result = vertexlist.get(i);
			if (result.getID().equals(ID)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Adds a vertex to this graph.
	 * 
	 * @param vertex
	 *            vertex to be added
	 */
	public void addVertex(Vertex vertex) {
		vertexlist.add(vertex);
	}

	/**
	 * Adds an Edge to a specific Vertex.
	 * 
	 * @param ID
	 *            The ID of the Vertex to which the Edge will be added
	 * @param edge
	 *            the Edge to be added
	 */
	public void addEdge(String ID, Edge edge) {
		getVertex(ID).addSuccessor(edge);
	}

	/**
	 * Fills this graph with information from a file. TODO: maybe to be made public,
	 * it should be possible to add information from a file to an already existing
	 * graph.
	 * 
	 * @param string
	 *            the filename/Path to the file
	 */
	private void fillGraphFromFile(String string) {
		String fileName = string;

		// read file into stream, try-with-resources
		// this expects a very strict pattern for the file content. It's also very far
		// from fail safe, but it should work
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			String[] file = stream.toArray(String[]::new);
			String[] vertices = file[0].split(",|;");
			// inserting all vertices specified in the file
			for (String vertexID : vertices) {
				this.addVertex(new Vertex(vertexID));
			}

			for (int i = 1; i < file.length; i++) {
				String[] tmp_line = file[i].split(":|,|;");
				String tmp_ID = tmp_line[0];
				for (int j = 1; j < tmp_line.length; j++) {
					String[] tmp_element = tmp_line[j].split("\\(|\\)");
					if (tmp_element.length > 1) {
						this.addEdge(tmp_ID,
								new Edge(Integer.parseInt(tmp_element[1]), this.getVertex(tmp_element[0])));
					} else {
						this.addEdge(tmp_ID, new Edge(this.getVertex(tmp_element[0])));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		String tmp = "[";
		for (Vertex vertex : vertexlist) {
			tmp = tmp + vertex.toString() + " ";
		}
		tmp = tmp + "]";
		return tmp;
	}
}
