package model;

public class PvWatts {
	private final int year;
	private final int month;
	private final int day;
	private final String time;
	private final int watts;
	public PvWatts(int year, int month, int day, String time, int watts) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.time = time;
		this.watts = watts;
	}
	
	
	public int getYear() {
		return year;
	}
	public int getMonth() {
		return month;
	}
	public int getDay() {
		return day;
	}
	public String getTime() {
		return time;
	}
	public int getWatts() {
		return watts;
	}
	
	
	
	
}
