package model;

import java.util.ArrayList;
import java.util.List;

public class DijkstraGraph {
	private final List<Vertex> vertices;
	private final List<Edge> edges;
	
	public DijkstraGraph(List<Vertex> vertices, List<Edge> edges){
		this.vertices = vertices;
		this.edges = edges;
	}
	
	public void addVertex(Vertex vertex){
		this.vertices.add(vertex);
	}

	public List<Vertex> getVertices() {
		return vertices;
	}

	public void addEdge(Edge edge){
		this.edges.add(edge);
	}
	
	public List<Edge> getEdges() {
		return edges;
	}
	
	
	public List<Edge> getAdjacentEdges(long from){
		List<Edge> adjEdges = new ArrayList<Edge>();
		
		for(Edge edge: edges){
			if(edge.getFrom() == from){
				adjEdges.add(edge);
			}
		}		
		
		return adjEdges;
	}
	/**
	 * Display the graph in a DOT-formatted text.
	 */
	public void printGraph(){
		System.out.println("digraph DAG{");
		for (Edge edge: edges){
			Vertex from = vertices.get((int) edge.getFrom());
			Vertex to = vertices.get((int) edge.getTo());
			System.out.println(" "+from.getName()+" -> "+to.getName()
					+" [label="+edge.getValue()+"];");
		}
		
		System.out.println("}\n");
	}
}
