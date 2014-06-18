package phase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import model.DijkstraGraph;
import model.Done;
import model.Edge;
import model.Estimate;
import model.Vertex;

public class DijkstraAlgorithm {
	
	private final DijkstraGraph graph;
	private List<Done> dones = new ArrayList<Done>();
	private PriorityQueue<Estimate> estimates = new PriorityQueue<Estimate>();
	private int base = 0;
	
	public DijkstraAlgorithm(DijkstraGraph graph){
		this.graph = graph;
	}
	
	public void run(){		
		
		for(int index=0;index<graph.getVertices().size();index++){
			Done done = new Done(index);
			if(index==0){
				done.setDistance(0);
				
			}else{
				done.setDistance(Integer.MAX_VALUE);
			}
			
			Estimate estimate = new Estimate(index,done);			
			dones.add(done);
			estimates.add(estimate);
		}
		
		while(!estimates.isEmpty()){
			Estimate estimate = estimates.poll();
			int u = estimate.getVertex();

			for(Edge adjEdge: graph.getAdjacentEdges(u)){
				int v = (int) adjEdge.getTo();
				
				if(dones.get(u).getDistance()==Integer.MAX_VALUE){
					break;
				}
				
				int distance = dones.get(u).getDistance() + adjEdge.getValue();
				Done v_done = dones.get(v);
				if(distance < v_done.getDistance()){
					v_done.setDistance(distance);
					v_done.setPrevious(u);
					dones.set(v, v_done);
				}
			}
			
		}		
		
	}
	
	
	public void printPath(){
		if(base !=0){
			for(Done done: dones){
				if(done.getVertex()%base == 0){
					System.out.println("Distance to "+ done.getVertex() + ": "+done.getDistance());
				}		
			}
		}
		else
		{
			for(Done done: dones){
			System.out.println("Distance to "+ done.getVertex() + ": "+done.getDistance());
			}
		}
		
	}

	public int getShortestPath(int vertex) {
		int path;
		path = dones.get(vertex).getDistance();		
		return path;
	}

	public void setBase(int base) {
		this.base = base;
	}
	
	
}
