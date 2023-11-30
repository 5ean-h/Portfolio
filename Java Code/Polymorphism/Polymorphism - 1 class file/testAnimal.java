/*
Name: Sean Hogan
Function: tetsting animal class
Creation Date: 29/11/2022
*/
public class testAnimal
{
	public static void main(String [] args)
	{
		Animal myAnimal = new Animal();
		Animal myPig = new Pig();
		Animal myDog = new Dog();
		Animal myCat = new Cat();
		myAnimal.animalSound();
		myPig.animalSound();
	}
}