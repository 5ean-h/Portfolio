/*
Name: Sean Hogan
Function: creating author class
Creation Date: 29/11/2022
*/
class Author
{
  String authorName;
  int age;
  String place;

  // Author class constructor
  Author(String name, int age, String place)
  {
    this.authorName = name;
    this.age = age;
    this.place = place;
  }
}

class  Book
{
  String name;
  int price;
  // author details
  Author auther;
  Book(String n, int p, Author auther)
  {
    this.name = n;
    this.price = p;
    this.auther = auther;
  }
  
  
}