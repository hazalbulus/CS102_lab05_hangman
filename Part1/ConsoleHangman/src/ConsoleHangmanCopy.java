/**
 * Lab05 Part 1/b ConsoleHangmanCopy main class
 * @author Hazal Buluş
 * @version 1.0 15.07.2021
 */
package ConsoleHangman.src;

import java.util.Scanner;
import cs102.*;

/**
 * ConsoleHangman
 *
 * @author
 * @version 1.00 2013/4/7
 */

public class ConsoleHangmanCopy
{
    public static void main( String[] args)
	{
    	Scanner scan = new Scanner( System.in);

    	System.out.println( "Start of ConsoleHangman\n");

		// VARIABLES
		Hangman		hangman;

		// PROGRAM CODE
		hangman = new Hangman( new BasicSetup() );
		hangman.initNewGame();
		
		System.out.println( hangman.getKnownSoFar() );


		do{
			System.out.println("Guess a letter: ");
			char ch;
			ch = scan.next().charAt(0); 
			if(hangman.getUsedLetters().contains(String.valueOf(Character.toLowerCase(ch)))){
				System.out.println("You tried this letter before!");
			}
			int guess = hangman.tryThis(ch);
			//Printing wrong guess message if the letter does not occur in the secret word
			if(guess == 0){
				System.out.println("Wrong guess!");
			}
			//Printing the count that how many times the letters found in the word
			if(guess > 0 ){
				System.out.println("Correct guess! Found in " + guess + " times." );
			}
			//Printing the game status
			System.out.println("The word so far: " + hangman.getKnownSoFar() + "\nNumber of incorrect tries: " + hangman.getNumOfIncorrectTries() + "\nUsed letters: " + hangman.getUsedLetters());	
			System.out.println("====================================");	

			//Printing won or lost messages when game is over
			if(hangman.isGameOver()){

				if(hangman.hasLost()){
					System.out.println("You lost the game!!");
				}
				if(!hangman.hasLost())
					System.out.println("You found the secret word!");
			}

		}while(!hangman.isGameOver());
		scan.close();


		System.out.println( "\nEnd of ConsoleHangman\n" );
	}

} // end of class ConsoleHangman
