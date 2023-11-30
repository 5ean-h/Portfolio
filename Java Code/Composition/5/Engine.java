/*
Name: Sean Hogan
Function: create Engine class
Creation Date: 30/11/2022
*/
class Engine implements Part {
	String name;
	double price;

	public Engine(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
}