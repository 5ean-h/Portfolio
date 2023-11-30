/*
Name: Sean Hogan
Function: creating animal class
Creation Date: 29/11/2022
*/
class Animal {

   public void animalSound() 
   {
      System.out.print("The animal makes a sound");
   }

}
class Pig extends Animal 
{
   public void animalSound() 
   {
      System.out.print("Grunts :3");
   }
}
class Dog extends Animal 
{
   public void animalSound() 
   {
      System.out.print("bark :3");
   }
}
class Cat extends Animal 
{
   public void animalSound() 
   {
      System.out.print("Meow :3");
   }
}