/*
Name: Sean Hogan
Function: create body class implements part
Creation Date: 30/11/2022
*/
class Body implements Part {
	String name;
	double price;
	public Body(String name, double price) {
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