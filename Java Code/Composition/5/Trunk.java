/*
Name: Sean Hogan
Function: create trunk class implements part
Creation Date: 30/11/2022
*/
class Trunk implements Part {
	String name;
	double price;
	public Trunk(String name, double price) {
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