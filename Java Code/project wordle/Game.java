//Name: Sean Hogan K00276275
//Date: 6/12/22
//Function: class that will create the wordle game
import java.util.Scanner;

public class Game
{//start of class


	public void game()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("");
			
			//setting word randomly
			String word1 = "Steam";
			//String word1 = super(Word.word);
			word1 = word1.toUpperCase();
			
			//set array size for length of word
			int arraySize = 5;
			
			//Array to store individual letters of the word
			char[] letArray = new char[arraySize];
			
			for(int i = 0; i < arraySize; i++)
			{
				letArray[i] = word1.charAt(i);
			}
			
			
			int endGame = 0;
			int gameTime = 5;
			int j = 0;
			
			do{
				String scan1;
				System.out.println("");
				System.out.println("Please Enter your your five letter word guess");
				scan1 = scan.next();
				scan1 = scan1.toUpperCase();
				endGame = 0;
				
				//Array to store individual letters of guess
				char[] optArray = new char[arraySize];
			
				for(int i = 0; i < arraySize; i++)
				{
					optArray[i] = scan1.charAt(i);
				}
				
				System.out.println("Word Entered: " + scan1);
				
				//checking letters
				for(int i = 0; i < arraySize; i++)
				{
					if((optArray[i] == letArray[i]))
					{
						//correct letter and location
						System.out.println(optArray[i] + " is Correct");
						endGame++;
					}
					else if(word1.indexOf(optArray[i]) > -1)
					{
						//In word but wrong location
						System.out.println(optArray[i] + " is in the word, wrong position");
					}
					else
					{
						//Letters not in word
						System.out.println(optArray[i] + " is not in the word");
					}
				}
				
				System.out.println("");
				j++;
				
			}while((j < gameTime)&&(endGame < arraySize));
			
			System.out.println("");
			
			if(endGame == arraySize)
			{
				System.out.println("Congrats!, You guessed correct");
				System.out.println("It took " + j + " guesses to guess the word");
				System.out.println("Thank You For Playing!");
			}
			else
			{
				System.out.println("Hard Luck, You ran out of turns");
				System.out.println("The Word Was " + word1);
				System.out.println("Thank You For Playing!");
			}
			
	}
																												
}