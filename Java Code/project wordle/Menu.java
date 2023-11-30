//Name: Sean Hogan K00276275
//Date: 6/12/22
//Function: class that will create 4 string objects

public class Menu 
{
	
	private String output;
	private String output1;
	private String output2;
	private String output3;
	
	//Default constructor
	public Menu()
	{
		output="Please enter a number for you corresponding choice(1-3):";
		output1="1. View Rules";
		output2="2. Play Wordle";
		output3="3. Exit";
	}	
	public Menu(String output, String output1, String output2, String output3 ){
	
		this.output=output;
		this.output=output1;
		this.output=output2;
		this.output=output3;
	} 

	//get methods
	public String getOutput(){
	
		return this.output;
	}	
	public String getOutput1(){
	
		return this.output1;
	}
	public String getOutput2(){
	
		return this.output2;
	}
	public String getOutput3(){
	
		return this.output3;
	}

	
	
}