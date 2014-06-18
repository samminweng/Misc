package model;

public class Done{
	private final int vertex;
	private int previous;
	private int distance = Integer.MAX_VALUE;
	
	public Done(int vertex){
		this.vertex = vertex;
	}	
	
	public int getVertex() {
		return vertex;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getPrevious() {
		return previous;
	}

	public void setPrevious(int previous) {
		this.previous = previous;
	}	
	
}
