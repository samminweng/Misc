package Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import model.Statistics;
import model.SumMonth;

import org.junit.Test;

import phase.CalculateSumMonth;
import phase.GeneratePvWatts;

public class TestPvWatts {

	@Test
	public void testGeneratePvWattswithSmallFile() {
		GeneratePvWatts generator = new GeneratePvWatts("pvwatts_brisbane.csv");
		
		generator.run();		
		List list = generator.getPvwatts_list();
		
		assertEquals(list.size(), 8760);
		
	}

	
	//@Test
	public void testGeneratePvWattswithLargeFile() {
		GeneratePvWatts generator = new GeneratePvWatts("large1000.csv");
		
		generator.run();		
		List list = generator.getPvwatts_list();
		
		assertEquals(list.size(), 8760*1000);
		
	}
	
	
	@Test
	public void testCalculateSumMonthwithSmallFile() {
		GeneratePvWatts generator = new GeneratePvWatts("pvwatts_brisbane.csv");
		generator.run();		
		CalculateSumMonth algorithm = new CalculateSumMonth(generator.getPvwatts_list());
		algorithm.run();
		
		HashMap<SumMonth, Statistics> result = algorithm.getResult();
		assertTrue((result.get(new SumMonth(1999,1)).getMean()- 264.38) == 0.0);
		assertTrue((result.get(new SumMonth(1982,2)).getMean()- 242.97) == 0.0);
		assertTrue((result.get(new SumMonth(1992,3)).getMean()- 245.93) == 0.0);
		assertTrue((result.get(new SumMonth(1996,4)).getMean()- 220.43) == 0.0);
		assertTrue((result.get(new SumMonth(1987,5)).getMean()- 180.03) == 0.0);
		assertTrue((result.get(new SumMonth(1993,6)).getMean()- 189.52) == 0.0);
		assertTrue((result.get(new SumMonth(1992,7)).getMean()- 213.38) == 0.0);
		assertTrue((result.get(new SumMonth(1995,8)).getMean()- 248.59) == 0.0);
		assertTrue((result.get(new SumMonth(1999,9)).getMean()- 277.95) == 0.0);
		
		algorithm.printResult();
	}
	
	//@Test
	public void testCalculateSumMonthwithLargeFile() {
		GeneratePvWatts generator = new GeneratePvWatts("large1000.csv");
		generator.run();		
		CalculateSumMonth algorithm = new CalculateSumMonth(generator.getPvwatts_list());
		algorithm.run();
		
		HashMap<SumMonth, Statistics> result = algorithm.getResult();
		assertTrue((result.get(new SumMonth(1999,1)).getMean()- 264.38) == 0.0);
		assertTrue((result.get(new SumMonth(1982,2)).getMean()- 242.97) == 0.0);
		assertTrue((result.get(new SumMonth(1992,3)).getMean()- 245.93) == 0.0);
		assertTrue((result.get(new SumMonth(1996,4)).getMean()- 220.43) == 0.0);
		assertTrue((result.get(new SumMonth(1987,5)).getMean()- 180.03) == 0.0);
		assertTrue((result.get(new SumMonth(1993,6)).getMean()- 189.52) == 0.0);
		assertTrue((result.get(new SumMonth(1992,7)).getMean()- 213.38) == 0.0);
		assertTrue((result.get(new SumMonth(1995,8)).getMean()- 248.59) == 0.0);
		assertTrue((result.get(new SumMonth(1999,9)).getMean()- 277.95) == 0.0);
		
		algorithm.printResult();
	}
	
}
