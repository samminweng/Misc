package model;

public class Estimate implements Comparable<Estimate> {
	private final int vertex;
	private Done done;
	/*private final int previous;*/
	
	/*public Estimate(int vertex){
		this.vertex = vertex;
	}*/
	
	public Estimate(int vertex, Done done){
		this.vertex = vertex;
		this.done = done;
	}

	public int getVertex() {
		return vertex;
	}

	@Override
	public int compareTo(Estimate other) {
		return Integer.compare(this.done.getDistance(), other.done.getDistance());
	}
	
	
}
