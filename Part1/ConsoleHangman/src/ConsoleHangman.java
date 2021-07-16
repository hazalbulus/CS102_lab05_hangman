/**
 * Lab05 Part 1/a,b,c ConsoleHangman main class
 * @author Hazal Buluş
 * @version 1.0 15.07.2021
 */
package ConsoleHangman.src;

import java.util.Scanner;

/**
 * ConsoleHangman
 *
 * @author
 * @version 1.00 2013/4/7
 */

public class ConsoleHangman
{
    public static void main( String[] args)
	{
    	Scanner scan = new Scanner( System.in);

    	System.out.println( "Start of ConsoleHangman\n");

		// VARIABLES
		HangmanModel		hangmanModel;
        ConsoleHangmanView          viewOne;
		ConsoleHangmanView			viewTwo;

		// PROGRAM CODE
		//Initializing model and views
		hangmanModel = new HangmanModel( new BasicSetup() );
        viewOne = new ConsoleHangmanView();
		viewTwo = new ConsoleHangmanView();

		//Adding hangman model to views
		hangmanModel.addView(viewOne);
		hangmanModel.addView(viewTwo);
		hangmanModel.initNewGame();

		
		System.out.println( hangmanModel.getKnownSoFar() );

		do{
			//update all views and game status
			hangmanModel.update();
			System.out.println("Guess a letter: ");
			char ch;
			ch = scan.next().charAt(0); 
			//printing error message if letter has tried before
			if(hangmanModel.getUsedLetters().contains(String.valueOf(Character.toLowerCase(ch)))){
				System.out.println("You tried this letter before!");
			}
			int guess = hangmanModel.tryThis(ch);

			//Printing wrong guess message if the letter does not occur in the secret word
			if(guess == 0){
				System.out.println("Wrong guess!!");
			}
			//Printing the count that how many times the letters found in the word
			else if(guess > 0){
				System.out.println("Found in " + guess + " times.");
			}
			System.out.println("====================================");	

			//Printing won or lost messages when game is over
			if(hangmanModel.isGameOver()){

				if(hangmanModel.hasLost()){
					System.out.println("You lost the game!!");
				}
				if(!hangmanModel.hasLost()){

					System.out.println("Word is: " + hangmanModel.getKnownSoFar());
					System.out.println("You found the secret word!");
				}
			}

		}while(!hangmanModel.isGameOver());

		scan.close();
		System.out.println( "\nEnd of ConsoleHangman\n" );
	}

} // end of class ConsoleHangman
