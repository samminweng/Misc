package benchmark;

import java.util.HashMap;

import model.Statistics;
import model.SumMonth;
import phase.CalculateSumMonth;
import phase.GeneratePvWatts;

public class Main {

	public static void main(String[] args) {
		for(int benchmark=1;benchmark<=20;benchmark++){
			//Starting time
			long startTime = System.currentTimeMillis();
			GeneratePvWatts generator = new GeneratePvWatts("large1000.csv");
			generator.run();		
			CalculateSumMonth algorithm = new CalculateSumMonth(generator.getPvwatts_list());
			algorithm.run();
			HashMap<SumMonth, Statistics> result = algorithm.getResult();
			double mean = result.get(new SumMonth(1987,5)).getMean();
			long endTime = System.currentTimeMillis();
			double elapseSecond = (endTime-startTime) / 1000.0;
			System.out.println("Benchmark:"+benchmark+"\tAverage Power (May):"+mean+"\tElapseTime:"+elapseSecond);
			generator = null;
			algorithm = null;
		}

	}
}