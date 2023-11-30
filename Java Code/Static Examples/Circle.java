//Name: Sean Hogan
//Function: Create circle
//Date: 23/11/22

public class Circle{
        
    // the Bicycle class has three fields
    private double radius; //instance Variable
    private static int numOfObjects;
  
        
    // the circle class has one constructor
    public Circle() {
        radius = 1.0;
        numOfObjects++;
	}
	
    // the circle class has four methods
	//instance method
    public void setRadius(double r) {
        radius = r;
    }
        
    public double getRadius() {
        return radius;
	}
	public static int getNumOfObjects() {
        return numOfObjects;
	}
	public double findArea(){
		return radius*radius*Math.PI;
	}
	
}
