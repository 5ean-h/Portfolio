/*
Name: Sean Hogan
Function: testing address2
Creation Date: 29/11/2022
*/
public class testAddress2
{
	public static void main(String args[])
	{
       Address ad = new Address(55, "Agra", "UP", "India");
       StudentClass obj = new StudentClass(123, "Chaitanya", ad);
	   College obj2 = new College("LIT", ad);
	   Staff obj3 = new Staff("John", ad);
       System.out.println(obj.rollNum);
       System.out.println(obj.studentName);
       System.out.println(obj.studentAddr.streetNum);
       System.out.println(obj.studentAddr.city);
       System.out.println(obj.studentAddr.state);
       System.out.println(obj.studentAddr.country);
	   System.out.println(obj2.collegeAddr.city);
   }
}