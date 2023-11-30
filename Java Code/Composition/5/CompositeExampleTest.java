/*
Name: Sean Hogan
Function: test composite example class
Creation Date: 30/11/2022
*/
public class CompositeExampleTest{
	public static void main(String args[]) {
		Part carEngine = new Engine("Disel Engine", 15000);
		Part carTrunk = new Trunk("Trunk", 10000);
		Part carBody = new Body("Body", 12000);

		Car car = new Car("Innova");
		car.addPart(carEngine);
		car.addPart(carTrunk);
		car.addPart(carBody);

	 
	    System.out.println("\nCar Details are : ");
		System.out.println("Car name : " + car.getName());
		System.out.println("Car parts : " + car.getPartNames());
		System.out.println("Car price : " + car.getPrice());
		
		
		Part tempoEngine = new Engine("Disel Engine", 20000);
		Part tempoTrunk = new Trunk("Trunk", 19000);
		Part tempoBody = new Body("Body", 350000);
		
		Tempo tempo = new Tempo("Mahindra Jeeto");
		tempo.addPart(tempoEngine);
		tempo.addPart(tempoTrunk);
		tempo.addPart(tempoBody);

		 
        System.out.println("\nTempo Details are : ");
		System.out.println("Tempo name : " + tempo.getName());
		System.out.println("Tempo parts : " + tempo.getPartNames());
		System.out.println("Tempo price : " + tempo.getPrice());
		
	}

}