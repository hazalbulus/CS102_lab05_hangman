/**
 * class ConsoleHangmanView that implements IHangmanView such that--
 * when its updateView(Hangman) method is called--it prints out the status of the Hangman game on the console.
 * @author Hazal Buluş
 * @version 1.0 15.07.2021
 */
package ConsoleHangman.src;
import cs102.Hangman;

public class ConsoleHangmanView implements IHangmanView{

    /**
     * This method prints the game status
     * @param hangman 
     */
    @Override
    public void updateView(Hangman hangmanModel) {
        System.out.println("The word so far: " + hangmanModel.getKnownSoFar() + "\nNumber of incorrect tries: " 
                            + hangmanModel.getNumOfIncorrectTries() + "/" + hangmanModel.getMaxAllowedIncorrectTries() + "\nUsed letters: " + hangmanModel.getUsedLetters());
        
    }
}
