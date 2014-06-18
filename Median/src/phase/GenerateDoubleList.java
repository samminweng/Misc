package phase;

import java.util.ArrayList;
import java.util.Random;

public class GenerateDoubleList {
	private final long size;
	private final int seed;	
	private ArrayList<Double> list;
	public ArrayList<Double> getList() {
		return list;
	}

	public GenerateDoubleList(int seed, long size){
		this.seed = seed;
		this.size = size;
	}

	public void run(){
		list = new ArrayList<Double>();
		Random random = new Random(seed);
		for(int index=0;index<size;index++){
			double value = random.nextDouble() * size;
			list.add(value);
		}
	}


}
