/*
Name: Sean Hogan
Function: creating publisher class
Creation Date: 29/11/2022
*/
class Publisher{
  
  String name;
  String publisherID;
  String city;
  
  Publisher(String name, String publisherID, String city) {
    this.name = name;
    this.publisherID = publisherID;
    this.city = city;
  }
}


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

class Book
{
  String name;
  int price;
  // author details
  Author auther;
  Publisher publisher;
  Book(String n, int p, Author auther, Publisher publisher )
  {
    this.name = n;
    this.price = p;
    this.auther = auther;
    this.publisher = publisher;
  }
  
}