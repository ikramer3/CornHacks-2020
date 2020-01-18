package main;
import java.io.*;

public class Points {
	
	private int mpg;
	private int points;
	private double distance;
	private double carbonE;
	private final double kgPerGallon = 8.8;
	
	public Points() {
		mpg = 0;
		points = 0;
		distance = 0;
	}
	
	public Points (int mpg, double distance) {
		mpg = this.mpg;
		distance = this.distance;
		carbonE = kgPerGallon/mpg *distance * 1000;
		points = (int) (Math.round(carbonE) / 50);
	}
	
	public int getPoints() {
		return points;
	}
	
	public double getCarbonE() {
		return carbonE;
	}
	
	public String toString() {
		return "You biked " + distance + "Miles and saved " +carbonE+ " g of carbon, getting " + points + "points";
	}
	
	public void fileOutput() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter("gameData.txt", true);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			pw.println("This will be where the total emissions will be"));
			pw.println("This is where the total points will be");
			pw.println("This will be where the available points will be");
			
			pw.flush();
			
		} finally {
			try {
				pw.close();
				bw.close();
				fw.close(); 
			} catch (IOException io) {
			// cant do anything	
			}
		}
		
	}
	
	
	

}
