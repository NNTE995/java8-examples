package java8_examples;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogFileWebView {
	
	public static void main(String[] args) {
		int[] Histo = new int[24];
		LocalTime [] Horas = new LocalTime[24];
		Map<Integer, logFile> visitMap = new HashMap<Integer, logFile>();
		Path path = Paths.get("C:\\Users\\DELL\\eclipse-workspace\\java8_examples\\src\\java8_examples\\LogFileText.txt");
		Path file = Paths.get("C:\\Users\\DELL\\eclipse-workspace\\java8_examples\\src\\java8_examples\\LogFileOutput.txt");
		
		String[] read;
		
		try {
			read = Files.readAllLines(path).toString().replace(",", "").replace("[", "").replace("]", "").split(" ");
			System.out.println(read[0]);
			for(int i=0;i<read.length;i++) {
				String[] arr = read[i].replace("VisitID=", "").replace("StartTime=", "").replace("EndTime=", "").replace("-", " ").replace(";", ",").split(" ");
				visitMap.put(i+1, new logFile(Integer.parseInt(arr[0]), LocalTime.parse(arr[1]), LocalTime.parse(arr[2])));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
		for(int i=1;i<visitMap.size()+1;i++) {
		    int b=(int) ChronoUnit.HOURS.between(LocalTime.of(00,00,00),visitMap.get(i).getStartTime());
		    int c=(int) ChronoUnit.HOURS.between(LocalTime.of(00,00,00),visitMap.get(i).getEndTime());
		    
		    for(int j=b;j<=c;j++){
		        Histo[j]+=1;
		    }
		}
		
		int index_Max=0;
		int max = Arrays.stream(Histo).max().getAsInt();
		
		for(int j=0;j<=Histo.length-1;j++){
		    Horas[j]=LocalTime.of(00,00,00).plusHours(j);
		    System.out.println("From "+ Horas[j]+ " to "+ Horas[j].plusHours(1));
		    System.out.println("are "+ Histo[j]+ " users in server");
		    
		    if(Histo[j]==max) {
		       index_Max=j;
		    }
		 }
		 
	    System.out.println("The most concurrent hour is from " + Horas[index_Max]+ " to "+ Horas[index_Max+1]);
	    System.out.println("Where the number of logged in users were: "+ max);
	    
	    try{
	    	List<String> lines = Arrays.asList("The most concurrent hour is from " + Horas[index_Max] + " to " + Horas[index_Max+1],
	    			"Where the number of logged in users were: "+ max);
	    	Files.write(file, lines, StandardCharsets.UTF_8);
	    } catch (IOException e){
	    	System.out.println("An error occurred.");
	    	e.printStackTrace();
	    }
	}
}