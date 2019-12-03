package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mesonet {
	
	private static ArrayList<String> stationArray = new ArrayList();
	
	public static void  readFile() {
		
		try {
			read("Mesonet.txt");
		} catch (IOException e) {
			System.out.println("error printing from file");
			e.printStackTrace();
		}
		
	}
	
	public static void read(String filename) throws IOException {
		
		 BufferedReader br = new BufferedReader(new FileReader(filename));
		 
		 String strg = "";
		 String stid = "";
		 
		 strg = br.readLine();
		 
		 while (strg != null) {
			stid = strg.trim().substring(0, 4);
			stationArray.add(stid);
			
	    	strg = br.readLine();
	     }
	     br.close();
	}
	
	public static ArrayList<String> getStationArray() {
		
		return stationArray;
	}
	
}
