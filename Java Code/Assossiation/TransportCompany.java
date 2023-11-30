/*
Name: Sean Hogan
Function: testing car class
Creation Date: 29/11/2022
*/
class TransportCompany{
   public static void main(String args[])
   {
	Driver obj = new Driver("Andy", "Ford", 9988);
	System.out.println(obj.driverName+" is a driver of car Id: "+obj.carId);
   }
}