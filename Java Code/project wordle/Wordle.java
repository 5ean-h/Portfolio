//Name: Sean Hogan K00276275
//Date: 2/12/22
//Function: class that contains rules method and main method
import java.util.Scanner;

public class Wordle
{//start of class

	public void rules()
	{
		System.out.println("Rules:");
		System.out.println("-------");
		System.out.println("Wordle is a game where a Five letter word is chosen.");
		System.out.println("You have Five turns to guess the word.");
		System.out.println("If you guess a right letter but its in the wrong slot it will turn red.");
		System.out.println("If you guess a right letter in the right slot it will turn green");
		System.out.println("If you guess the word you win");
		
	}
	public static void main(String [] args)
	{//start of main method
		Scanner scan = new Scanner(System.in);
		
		int menu=0;
		do
		{
			//Menu
			
			Menu mn = new Menu();
			System.out.println(mn.getOutput());
			System.out.println(mn.getOutput1());
			System.out.println(mn.getOutput2());
			System.out.println(mn.getOutput3());
			menu = scan.nextInt();
			
			if(menu == 1)
			{
				System.out.println("");
				Wordle rule = new Wordle();  
				rule.rules(); 
				System.out.println("");
			}
			else if(menu == 2)
			{
				Game play = new Game();  
				play.game(); 
			}
			else if(menu == 3)
			{
				System.out.println("");
				System.out.println("Exiting Menu");
			}
			else
			{
				System.out.println("");
				System.out.println("Invalid Entry");
			}
		
			System.out.println("");
		
		}while(menu < 3);
		
	}//end of main method
	
	
}//end of class