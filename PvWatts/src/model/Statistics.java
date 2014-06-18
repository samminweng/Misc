package model;

public class Statistics {
	private long count = 0;
	private long sum = 0;
	private double mean = 0.0;
	
	public long getCount() {
		return count;
	}
	public void addCount() {
		this.count++;
	}
	
	public long getSum() {
		return sum;
	}
	
	public void addSum(int power) {
		this.sum += power;
	}
	
	public double getMean(){
		this.mean = this.sum/(double)this.count;
		return Math.round(this.mean*100)/100.0;
	}
	
	
}
