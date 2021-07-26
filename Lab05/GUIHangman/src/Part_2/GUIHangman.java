import java.awt.*;
import cs102.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");

		HangmanModel		  hangman;
		BasicSetup		  basicSetup;
		ConsoleHangmanView	  consoleView;
		TextFieldControlPanel textFieldControlPanel;
		NewGameButtonControl  newGame;
		LabelsHangmanView     labelsHangmanView;
		GallowsHangmanView    hangmanView;
		LetterButtonControls letterButtonControls;
		SimpleJFrame jframe;

		basicSetup = new BasicSetup();
		hangman = new HangmanModel( basicSetup);
		textFieldControlPanel = new TextFieldControlPanel(hangman);
		newGame = new NewGameButtonControl(hangman);
		labelsHangmanView = new LabelsHangmanView();
		hangmanView = new GallowsHangmanView(hangman);
		consoleView = new ConsoleHangmanView();
		letterButtonControls = new LetterButtonControls(hangman.getAllLetters());
		HangmanLetterButtonControls controls = new HangmanLetterButtonControls(hangman);

		hangman.addView(consoleView);
		hangman.addView(labelsHangmanView);
		hangman.addView(hangmanView);
		hangman.addView(newGame);
		hangman.addView(controls);

		newGame.updateView(hangman);
		labelsHangmanView.updateView(hangman);
		consoleView.updateView(hangman);
		hangmanView.updateView(hangman);
		controls.updateView(hangman);

		jframe = new SimpleJFrame( "GUIHangman", 	// title
							hangmanView,			// center
							textFieldControlPanel, newGame,		// north, south
							controls, labelsHangmanView);	// east, west

		// this is an infinite loop reading from the console... not clever!

		jframe.setSize(new Dimension(1200,80000));
		ConsoleControl.controlFor( hangman);
	}

	public static void main( String[] args)
	{
		new GUIHangman();

	}

} // end of class GUIHangman
