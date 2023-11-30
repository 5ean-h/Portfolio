/*
Name: Sean Hogan
Function: create car class implements part
Creation Date: 30/11/2022
*/
class Car implements Part {
	List < Part > parts;
	String name;

	public Car(String name) {
		this.name = name;
		parts = new ArrayList < Part > ();
	}
	public void addPart(Part part) {
		parts.add(part);
	}
	public String getName() {
		return name;
	}
	public String getPartNames() {
		StringBuilder sb = new StringBuilder();
		for (Part part: parts) {
			sb.append(part.getName()).append(" ");
		}
		return sb.toString();
	}
	public double getPrice() {
		double price = 0;
		for (Part part: parts) {
			price += part.getPrice();
		}
		return price;
	}
}