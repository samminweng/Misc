package model;

public class SumMonth{

	private final int year;
	private final int month;
	
	public SumMonth(int year, int month){
		this.year = year;
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==this) return true;
		if(obj==null || !(obj instanceof SumMonth)) return false;
		SumMonth sumMonth = SumMonth.class.cast(obj);
		return (this.year==sumMonth.year) && (this.month==sumMonth.month);
	}

	@Override
	public int hashCode() {
		return this.year + this.month;
	}


//	@Override
//	public int compareTo(SumMonth sumMonth) {
//		if(this==sumMonth) return 0;
//		int year = this.year - sumMonth.year;
//		if(year != 0) return year;
//		return this.month - sumMonth.month;
//	}
	
	
}
