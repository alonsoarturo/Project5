package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Mesonet {
	
	private static ArrayList<String> stationArray = new ArrayList();
	
	
	/**
	 *  readFile() method calls the read method to read in the "Mesonet.txt" file
	 *  uses try/catch to throw en IOException if there is an error reading in the data
	 *  from the file.
	 *  
	 */
	public static void  readFile() {
		
		try {
			read("Mesonet.txt");
		} catch (IOException e) {
			System.out.println("error printing from file");
			e.printStackTrace();
		}
		
	}
	
	/**
	 * read(String filename) method takes in a file name to read in. while the lines 
	 * have a value, the method trims the string and saves it to an ArrayList stationArray
	 * 
	 * @param filename
	 * @throws IOException
	 */
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
	
	/**
	 * getStationArray() is a getter method that returns the ArrayList stationArray
	 * 
	 * @return ArrayList<String> stationArray
	 */
	public static ArrayList<String> getStationArray() {
		
		return stationArray;
	}
	
}
