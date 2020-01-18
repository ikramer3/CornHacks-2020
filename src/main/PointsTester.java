package main;

public class PointsTester extends Points{
	
	public static void main(String args[]) {
		
		Points test1 = new Points(35, 2);
		
		fileOutput(test1.getCarbonE(), test1.getObjectMPG(), test1.getPoints());
		
		System.out.println("this isnt working and I dont know why");
		
	}

}
