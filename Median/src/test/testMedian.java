package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import phase.FindMedian;
import phase.GenerateDoubleList;

public class testMedian {

	@Test
	public void testGenerateDoubleList() {
		int seed = 10;
		long size = 1*1000*1000;
		GenerateDoubleList generator = new GenerateDoubleList(seed, size);
		generator.run();		
		List<Double> list = generator.getList();
		
		assertEquals(list.size(), size);
		for(int i=0;i<size;i++){
			assertTrue( (list.get(i)>0) && (list.get(i)<size));
		}		
	}
	
	@Test 
	public void testFindMedian(){
		int size = 100;
		List<Double> list = new ArrayList<Double>();
		
		for(int i=1;i<size;i++){
			list.add((double)i);
		}
		FindMedian algorithm = new FindMedian(list);
		
		double median = algorithm.run();
		
		assertTrue((median-50.0)==0);
	}
	
	
	@Test
	public void test1millionList(){
		
		long size = 1*1000*1000;
		List<Double> list = new ArrayList<Double>();
		
		for(int i=1;i<size;i++){
			list.add((double)i);
		}
		FindMedian algorithm = new FindMedian(list);
		
		double median = algorithm.run();
		assertTrue((median-(size/2))==0);
		
	}
	
	
	/*@Test
	public void test100millionRandomNumbers(){
		int seed = 10;
		long size = 100*1000*1000;
		GenerateDoubleList generator = new GenerateDoubleList(seed, size);
		generator.run();		
		List<Double> list = generator.getList();
		
		assertEquals(list.size(), size);
		FindMedian algorithm = new FindMedian(list);
		
		double median = algorithm.run();
		
		System.out.println("Median:"+median);
		
	}*/
	
	

}
