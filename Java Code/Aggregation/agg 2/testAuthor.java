/*
Name: Sean Hogan
Function: testing author class
Creation Date: 29/11/2022
*/
public class testAuthor
{
	public static void main(String[] args) 
	{
		Author auther = new Author("John", 42, "USA");
		Book b = new Book("Java for Begginer", 800, auther);
		System.out.println("Book Name: "+b.name);
		System.out.println("Book Price: "+b.price);
		System.out.println("------------Auther Details----------");
		System.out.println("Auther Name: "+b.auther.authorName);
		System.out.println("Auther Age: "+b.auther.age);
		System.out.println("Auther place: "+b.auther.place);
	}
}