/*
Name: Sean Hogan
Function: testing publisher class
Creation Date: 29/11/2022
*/
public class testPublisher
{
	public static void main(String[] args) {
    Author auther = new Author("John", 42, "USA");
    Publisher publisher = new Publisher("Sun Publication","JDSR-III4", "LA");
    Book b = new Book("Java for Begginer", 800, auther, publisher);
    System.out.println("Book Name: "+b.name);
    System.out.println("Book Price: "+b.price);
    System.out.println("------------Author Details----------");
    System.out.println("Auther Name: "+b.auther.authorName);
    System.out.println("Auther Age: "+b.auther.age);
    System.out.println("Auther place: "+b.auther.place);
    System.out.println("------------Publisher Details-------");
    System.out.println("Publisher Name: "+b.publisher.name);
    System.out.println("Publisher ID: "+b.publisher.publisherID);
    System.out.println("Publisher City: "+b.publisher.city);
  }
}