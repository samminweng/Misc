package phase;

import java.util.Collections;
import java.util.List;

public class FindMedian {
	private final List<Double> list;
	
	public FindMedian(List<Double> list){
		this.list = list;
	}
	
	public double run(){
		//Sort the doubles in the list.
		Collections.sort(list);
		long size = list.size();
		
		long middle;
		if(list.size() % 2 == 1){
			middle = (size +1)/2 - 1; 
			return list.get((int)middle);
		}else
		{
			middle = size /2;
			double num1 = list.get((int) (middle-1));
			double num2 = list.get((int) middle);
			return (num1+num2)/2.0;
		}
	}
	
}
