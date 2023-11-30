//Name: Sean Hogan
//Function: Create test circle class
//Date: 4/11/22

public class TestCircle {
		
	public static void main(String[] args)
	{
		
		Circle c1 = new circle();
			System.out.println(c1.getRadius());
			System.out.println(c1. getNumOfObjects());
			System.out.println(Circle.getNumOfObjects());
			printCircle(c1);

		Circle c2 = new Circle(5);
			System.out.println(c2.getRadius());
			System.out.println(c2.getNumOfObjects());
			System.out.println(Circle.getNumOfObjects());
			printCircle(c2);

	}	
	public static void printCircle(Circle c)
	{
			System.out.println("The Radius is " + c.getRadius());
			System.out.println("The number of circle objects is " + c.getNumOfObjects());
		
	}
	
}