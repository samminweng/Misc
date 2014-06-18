package phase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.PvWatts;
import model.Statistics;
import model.SumMonth;

public class CalculateSumMonth {

	private final List<PvWatts> list;
	private HashMap<SumMonth, Statistics> result;
	
	public CalculateSumMonth(List<PvWatts> list){
		this.list = list;
	}
	
	public void run(){
		//Iterate all of the PvWatts tuples and put the SumMonth tuples
		result = new HashMap<SumMonth, Statistics>();
		
		for(PvWatts pv: list){
			SumMonth sumMonth = new SumMonth(pv.getYear(), pv.getMonth());
			Statistics stats;
			if(result.containsKey(sumMonth)){
				stats = result.get(sumMonth);
			}else{
				stats = new Statistics();				
			}
			
			stats.addCount();
			stats.addSum(pv.getWatts());
			
			result.put(sumMonth, stats);
		}	
		
	}
	
	public void printResult(){
		//Print out the averaged monthly power level.
		for(SumMonth sumMonth: result.keySet()){
			Statistics stats = result.get(sumMonth);
			System.out.println(" "+sumMonth.getYear()+"/"+sumMonth.getMonth()+":"+stats.getMean());
		}
	}
	

	public HashMap<SumMonth, Statistics> getResult() {
		return result;
	}
	
	
	
}
