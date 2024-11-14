package lab3;

public class Basketball {
	private double diameter;
	private boolean inflated;
	
	
	public Basketball(double givenDiameter){
		this.diameter = givenDiameter;
		this.inflated = false; 
	 }

	public boolean isDribbleable() {
		return inflated;
	 }

	public double getDiameter() {
	   return diameter;
	  }

	public double getCircumference() {
	   return Math.PI * diameter;
	  }

	public void inflate() {
		inflated = true;
	  }
}
