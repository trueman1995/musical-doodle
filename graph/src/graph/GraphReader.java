package graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Felix Armbruster felix_armbruster@t-online.de
 * 
 *         This class implements simple filereader an parser that reads an input
 *         file and creates a graph based on it
 *
 *         A few prerequisites for the file: No comments, empty lines, correct form
 *
 */
public class GraphReader {

	/**
	 * @param string
	 *            path to file
	 * @return returns graph created from file
	 */
	public static int[][] getGraphFromFile(String string) {
		// TODO

		String fileName = string;

		// read file into stream, try-with-resources
		// this expects a very strict pattern for the file content. It's also very far from fail safe, but it should work
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			String[] file = stream.toArray(String[]::new);
			int[][] tmp_array = new int[file.length][file.length];
 			for (int i = 0; i < file.length; i++) {
				String[] tmp_line = file[i].split("\\s");
				for (int j = 1; j < tmp_line.length; j++) {
					//System.out.println(tmp_line[j]);
					String[] tmp_element = tmp_line[j].split("(\\(|\\))");
					tmp_array[Integer.parseInt(tmp_line[0])][Integer.parseInt(tmp_element[0])] = Integer.parseInt(tmp_element[1]);
				}
				//System.out.println(file[i]);
			}
 			return tmp_array;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
