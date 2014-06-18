package benchmark;

import static org.junit.Assert.assertEquals;

import java.util.List;

import phase.FindMedian;
import phase.GenerateDoubleList;

public class Main {

	public static void main(String[] args) {
		for(int benchmark=1;benchmark<=20;benchmark++){
			//Starting time
			long startTime = System.currentTimeMillis();
			int seed = 10;
			long size = 100*1000*1000;
			GenerateDoubleList generator = new GenerateDoubleList(seed, size);
			generator.run();		
			List<Double> list = generator.getList();

			assertEquals(list.size(), size);
			FindMedian algorithm = new FindMedian(list);

			double median = algorithm.run();
			long endTime = System.currentTimeMillis();
			double elapseSecond = (endTime-startTime) / 1000.0;
			System.out.println("Benchmark:"+benchmark+"\tMedian:"+median+"\tElapseTime:"+elapseSecond);
			list = null;
			
		}

	}

}
