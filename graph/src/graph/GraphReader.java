package graph;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

class GraphReader {

	public static graph getGraphFromFile(String string) {
		// TODO 
		
		String fileName = string;

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			String[] file=stream.toArray(String[]::new);
			for (int i=0; i<file.length; i++)
				//TODO hier ist die file
				System.out.println(file[i]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}