package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import model.DijkstraGraph;
import model.Edge;
import model.Vertex;

import org.junit.Test;

import phase.DijkstraAlgorithm;
import phase.GenerateGraph;

public class TestDijkstra {

	@Test
	public void testGenerateGraph() {
		GenerateGraph generateGraph = new GenerateGraph(10,10,10,16);
		DijkstraGraph graph = generateGraph.run();
		graph.printGraph();
		
		assertNotNull(graph);
		
		assertEquals(graph.getVertices().size(),10);
		assertEquals(graph.getEdges().size(), 20);
		
	}

	@Test
	public void testDijkstraAlgorithm(){
		List<Vertex> vertices = new ArrayList<Vertex>();		
		for(int index=0;index<5;index++){
			Vertex v = new Vertex(index,"S"+index);
			vertices.add(v);
		}
		
		List<Edge> edges = new ArrayList<Edge>();
		
		edges.add(new Edge(0,1,10));
		edges.add(new Edge(0,3,30));
		edges.add(new Edge(0,4,100));
		edges.add(new Edge(1,2,50));		
		edges.add(new Edge(3,2,20));
		edges.add(new Edge(2,4,10));
		edges.add(new Edge(3,4,60));
		
		DijkstraGraph graph = new DijkstraGraph(vertices, edges);
		
		assertEquals(graph.getVertices().size(), 5);
		assertEquals(graph.getEdges().size(), 7);
		assertEquals(graph.getAdjacentEdges(0).size(), 3);
		assertEquals(graph.getAdjacentEdges(1).size(), 1);
		assertEquals(graph.getAdjacentEdges(4).isEmpty(), true);
		
		graph.printGraph();
		
		DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);
		
		algorithm.run();
		
		assertEquals(algorithm.getShortestPath(1), 10);
		assertEquals(algorithm.getShortestPath(2), 50);
		assertEquals(algorithm.getShortestPath(3), 30);
		assertEquals(algorithm.getShortestPath(4), 60);
		
		
	}
	
	@Test
	public void testDijkstraAlgorithm2(){
		List<Vertex> vertices = new ArrayList<Vertex>();		
		for(int index=0;index<6;index++){
			Vertex v = new Vertex(index,"S"+index);
			vertices.add(v);
		}
		
		List<Edge> edges = new ArrayList<Edge>();
		
		edges.add(new Edge(0,1,7));
		edges.add(new Edge(0,2,9));
		edges.add(new Edge(0,5,14));
		edges.add(new Edge(1,2,10));		
		edges.add(new Edge(1,3,15));
		edges.add(new Edge(2,3,11));
		edges.add(new Edge(2,5,2));
		edges.add(new Edge(3,4,6));
		edges.add(new Edge(4,5,9));
		
		DijkstraGraph graph = new DijkstraGraph(vertices, edges);
		graph.printGraph();
		
		DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);
		
		algorithm.run();
		
		
		assertEquals(algorithm.getShortestPath(1), 7);
		assertEquals(algorithm.getShortestPath(2), 9);
		assertEquals(algorithm.getShortestPath(3), 20);
		assertEquals(algorithm.getShortestPath(4), 26);
		assertEquals(algorithm.getShortestPath(5), 11);

	}
	
	
	@Test
	public void test10nodes10edgesGraph(){
		
		List<Vertex> vertices = new ArrayList<Vertex>();		
		for(int index=0;index<10;index++){
			Vertex v = new Vertex(index,"S"+index);
			vertices.add(v);
		}
		
		List<Edge> edges = new ArrayList<Edge>();
		
		edges.add(new Edge(0,1,8));
		edges.add(new Edge(0,4,6));
		edges.add(new Edge(0,5,3));
		edges.add(new Edge(1,2,8));		
		edges.add(new Edge(1,3,5));
		edges.add(new Edge(5,6,3));
		edges.add(new Edge(5,8,5));
		edges.add(new Edge(6,7,6));
		edges.add(new Edge(6,9,7));
		
		DijkstraGraph graph = new DijkstraGraph(vertices, edges);
		
		graph.printGraph();
		
		DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);
		
		algorithm.run();
		
		algorithm.printPath();
		
		assertEquals(algorithm.getShortestPath(1), 8);
		assertEquals(algorithm.getShortestPath(2), 16);
		assertEquals(algorithm.getShortestPath(3), 13);
		assertEquals(algorithm.getShortestPath(4), 6);
		assertEquals(algorithm.getShortestPath(5), 3);
		assertEquals(algorithm.getShortestPath(6), 6);
		assertEquals(algorithm.getShortestPath(7), 12);
		assertEquals(algorithm.getShortestPath(8), 8);
		assertEquals(algorithm.getShortestPath(9), 13);
	
	}
	
	
	@Test
	public void test10nodes30edgesGraph(){
		
		List<Vertex> vertices = new ArrayList<Vertex>();		
		for(int index=0;index<10;index++){
			Vertex v = new Vertex(index,"S"+index);
			vertices.add(v);
		}
		
		List<Edge> edges = new ArrayList<Edge>();
		
		edges.add(new Edge(0,1,1));
		edges.add(new Edge(0,4,6));		
		edges.add(new Edge(0,5,3));
		
		edges.add(new Edge(1,2,1));
		edges.add(new Edge(1,2,8));
		edges.add(new Edge(1,3,5));
		
		edges.add(new Edge(2,3,1));
		
		edges.add(new Edge(3,4,1));
		edges.add(new Edge(3,8,2));
		
		edges.add(new Edge(4,5,1));
		edges.add(new Edge(4,3,3));
		
		edges.add(new Edge(5,6,1));
		edges.add(new Edge(5,5,2));
		edges.add(new Edge(5,6,3));
		edges.add(new Edge(5,8,5));		
		edges.add(new Edge(5,8,5));
		edges.add(new Edge(5,6,4));
		edges.add(new Edge(5,1,2));
		edges.add(new Edge(5,6,4));
		
		edges.add(new Edge(6,7,1));
		edges.add(new Edge(6,0,7));	
		edges.add(new Edge(6,7,6));
		edges.add(new Edge(6,8,6));	
		edges.add(new Edge(6,9,7));
		
		edges.add(new Edge(7,8,1));
		edges.add(new Edge(7,4,8));
		
		edges.add(new Edge(8,9,1));
		edges.add(new Edge(8,1,6));
		edges.add(new Edge(8,5,6));
		
		edges.add(new Edge(9,3,8));
		
		
		DijkstraGraph graph = new DijkstraGraph(vertices, edges);
		
		graph.printGraph();
		
		DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);
		
		algorithm.run();
		
		algorithm.printPath();
		
		assertEquals(algorithm.getShortestPath(1), 1);
		assertEquals(algorithm.getShortestPath(2), 2);
		assertEquals(algorithm.getShortestPath(3), 3);
		assertEquals(algorithm.getShortestPath(4), 4);
		assertEquals(algorithm.getShortestPath(5), 3);
		assertEquals(algorithm.getShortestPath(6), 4);
		assertEquals(algorithm.getShortestPath(7), 5);
		assertEquals(algorithm.getShortestPath(8), 5);
		assertEquals(algorithm.getShortestPath(9), 9);
	}
	
	
	//@Test
	public void test1MillionVertexGraphwithDijkstra() {
		long numVertices = 1000 * 1000;
		GenerateGraph generateGraph = new GenerateGraph(numVertices,numVertices,10,16);
		DijkstraGraph graph = generateGraph.run();
		
		assertNotNull(graph);
		
		assertEquals(graph.getVertices().size(),numVertices);
		assertEquals(graph.getEdges().size(), 2*numVertices);
		graph.printGraph();
		
		DijkstraAlgorithm algorithm = new DijkstraAlgorithm(graph);
		
		algorithm.run();
		
		algorithm.setBase(1000);
		algorithm.printPath();
		/*System.out.println(algorithm.getShortestPath(dest));
		assertTrue(algorithm.getShortestPath(dest)>0 && algorithm.getShortestPath(dest)< oneM);*/
	}
	
}
