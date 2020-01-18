package main;
import java.io.*;
import java.util.*;

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
		this.mpg = mpg;
		this.distance = distance;
		carbonE = (double)kgPerGallon/mpg *distance * 1000;
		points = (int) (Math.round(carbonE) / 50);
	}
	
	public int getPoints() {
		return points;
	}
	
	public double getCarbonE() {
		return carbonE;
	}
	
	public int getObjectMPG() {
		return mpg;
	}
	
	public String toString() {
		return "You biked " + distance + "Miles and saved " +carbonE+ " g of carbon, getting " + points + "points";
	}
	
	/*
	 * getEmmission reads the game file and returns the number that represents the emissions ( the first line of the file)
	 */
	public static double getEmissions() {
		double carbonEmissionTotal;
		
		Scanner s = null;
		try {
			s=new Scanner(new File("gameData.txt"));
		} catch (FileNotFoundException e) {
			return -1;
		}
		
		String line;
		
		line = s.nextLine();
		carbonEmissionTotal = Double.parseDouble(line);
		
		s.close();
		
		return carbonEmissionTotal;
		
	}
	
	/*
	 * getMPG reads the game file and returns the number that represents the miles per gallon( the second line of the file)
	 */
	public static int getMPG() {
		int milesPerGallon;
		
		Scanner s = null;
		try {
			s=new Scanner(new File("C:\\Users\\asgoi\\OneDrive\\Documents\\CornHacks-2020\\src\\main\\gameData.txt"));
		} catch (FileNotFoundException e) {
			return -1;
		}
		
		String line;
		
		for(int i=0; i<1; i++) {
			s.nextLine();
		}
		line = s.nextLine();
		milesPerGallon = Integer.parseInt(line);
		
		s.close();
		
		return milesPerGallon;
	}
	
	/*
	 * getEmmission reads the game file and returns the number that represents the totalPoints ( the third line of the file)
	 */
	public static int getTotalPoints() {
		int totalPoints;
		
		Scanner s = null;
		try {
			s=new Scanner(new File("C:\\Users\\asgoi\\OneDrive\\Documents\\CornHacks-2020\\src\\main\\gameData.txt"));
		} catch (FileNotFoundException e) {
			return -1;
		}
		
		String line;
		
		for(int i =0; i<2; i++) {
			s.nextLine();
		}
		
		line = s.nextLine();
		totalPoints = Integer.parseInt(line);
		s.close();
		
		return totalPoints;
		
	}
	
	public static void fileOutput(double emissions, int mpg, int point) {
		
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File("gameData.txt"));
		} catch(FileNotFoundException fnfe) {
			throw new RuntimeException(fnfe);
		}
		
		pw.println(emissions);
		pw.println(mpg);
		pw.println(point);
		
		pw.close();

	}
	
	public int addPointsToTotal() {
		int previousPoints = getTotalPoints();
		int newPoints = previousPoints + points;
		
		return newPoints;
	}
	
	
	
	
	

}
