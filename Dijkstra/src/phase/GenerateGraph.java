package phase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.DijkstraGraph;
import model.Edge;
import model.Vertex;

public class GenerateGraph {
	private final long numVertices;
	private final long extraEdges;
	private final int maxLength;
	private final Random random;
	private DijkstraGraph graph;

	public GenerateGraph(long numVertices, long extraEdges, int maxLength, int seed) {
		this.numVertices = numVertices;
		this.extraEdges = extraEdges;
		this.maxLength = maxLength;
		this.random = new Random(seed);
		
	}

	public DijkstraGraph run(){
		graph = new DijkstraGraph(new ArrayList<Vertex>(), new ArrayList<Edge>());
		long totalEdges = numVertices + extraEdges;
		//Generate all the vertices and form a random connected tree with root node (id=0).  
		for(long id=0; id<this.numVertices; id++){
			//Generate the vertex and add it to the graph.
			Vertex to = new Vertex(id,"S"+id);
			graph.getVertices().add(to);
			//Generate a random edge to connect the current node with a random chosen existing node.
			if(id>0){
				long from = (long)(random.nextDouble()*this.numVertices);
				int len = random.nextInt(maxLength-1)+1;
				
				Edge edge = new Edge(from, id, len);
				graph.getEdges().add(edge);
			}
		}
		
		//Generate all of the extra edges, each of them connecting two random vertices.
		for(long id=this.numVertices;id<=totalEdges; id++){
			long from = (long)(random.nextDouble()*this.numVertices);
			long to = (long)(random.nextDouble()*this.numVertices);
			int len = random.nextInt(maxLength-1)+1;
			Edge edge = new Edge(from, to, len);
			graph.getEdges().add(edge);
		}
		
		return graph;
	}

	
	

}
