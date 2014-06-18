package phase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.PvWatts;
import model.SumMonth;

public class GeneratePvWatts {
	private final String filename;
	private List<PvWatts> pvwatts_list = null;

	public GeneratePvWatts(String filename){
		this.filename = filename;
	}


	public void run(){
		FileReader reader;
		try {
			reader = new FileReader(this.filename);
			BufferedReader in = new BufferedReader(reader);
			String line;
			pvwatts_list = new ArrayList<PvWatts>();
			while((line=in.readLine())!= null){
				String[] words = line.split(",");
				if(words.length==5){
					try{
						int year = Integer.parseInt(words[0]);
						int month = Integer.parseInt(words[1]);
						int day = Integer.parseInt(words[2]);
						String hour = words[3];
						int watts = Integer.parseInt(words[4]);
						//if((year >1000) && (month>=1 && month<=12) && (day>=1 && day<=31)){
						if((year >1000)){
							pvwatts_list.add(new PvWatts(year,month,day,hour,watts));
						}
					}catch(NumberFormatException ex){
						//Do nothing.
					}

				}			
			}
			reader.close();
		} catch (IOException e) {
			pvwatts_list = null;
		}



	}


	public List<PvWatts> getPvwatts_list() {
		return pvwatts_list;
	}




}
