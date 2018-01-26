package cycleDetection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input {

	Graph graph;
	
	public Graph getGraph(){
		return graph;
	}
	
	public void readTextFile(String path) throws IOException{
		FileReader fileReader = new FileReader(path);
		
	    @SuppressWarnings("resource")
		BufferedReader bufferedReader = new BufferedReader(fileReader);
	    
	    String line = bufferedReader.readLine();
	    //line splitten
	    String vertices[] = line.split(",");
	    
	    graph = new Graph(vertices.length);
	    
	    while(true) {
			line = bufferedReader.readLine();
			if(line==null){
				break;
			}
			String predeccesor = line.substring(0 , 1);
			int indexOfPredeccesor = 0;
			for (int i = 0; i < vertices.length; i++) {
				if(predeccesor.equals(vertices[i])){
					indexOfPredeccesor = i;
				}
			}
			
			line = line.substring(2, line.length()); //ohne A:, B: usw.
			String successors[] = line.split(",");
			
			for (int i = 0; i < successors.length; i++) {
				for (int j = 0; j < vertices.length; j++) {
					if(successors[i].equals(vertices[j])){
						graph.setAdjacency(indexOfPredeccesor, j);
					}					
				}
			}			
		}	    
	}
	
	
}
