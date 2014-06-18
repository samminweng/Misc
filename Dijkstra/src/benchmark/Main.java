package benchmark;

import model.DijkstraGraph;
import phase.DijkstraAlgorithm;
import phase.GenerateGraph;

public class Main {
	public static void main(String[] args) {
		for(int benchmark=1;benchmark<=20;benchmark++){
			//Starting time
			long startTime = System.currentTimeMillis();
			long numVertices = 1000 * 1000;
			GenerateGraph generateGraph = new GenerateGraph(numVertices,numVertices,10,16);
			DijkstraGraph graph = generateGraph.run();
			
			DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);
			algorithm.run();			
			algorithm.setBase(100000);
			algorithm.printPath();
			
			long endTime = System.currentTimeMillis();
			double elapseSecond = (endTime-startTime) / 1000.0;
			System.out.println("Benchmark:"+benchmark+"\tElapseTime:"+elapseSecond);
			generateGraph = null;
			algorithm = null;
		}

	}
}
