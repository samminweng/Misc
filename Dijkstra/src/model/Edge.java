package model;

public class Edge {
	private final long from;
	private final long to;
	private final int value;
	public Edge(long from, long to, int value) {
		this.from = from;
		this.to = to;
		this.value = value;
	}
	public long getFrom() {
		return from;
	}
	public long getTo() {
		return to;
	}
	public int getValue() {
		return value;
	}
	
	
	
}
