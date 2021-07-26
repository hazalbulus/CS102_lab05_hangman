/**
 * Lab05 Part2 letter buttons' controller class
 * @author Hazal Buluş
 * @version 1.0 26.07.2021
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import cs102.*;

public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView
{
    Hangman hangman;
    
    public HangmanLetterButtonControls( Hangman hangman)
    {
        super(hangman.getAllLetters());
        this.hangman = hangman;
    }
    
	@Override
    public void updateView(Hangman hangmanModel) 
    {
		setEnabledAll(true);
        setDisabled(hangman.getUsedLetters());
        addActionListener(new LetterButtonListener());
	}
    private class LetterButtonListener implements ActionListener
    {
    
        public void actionPerformed(ActionEvent e)
        {
            hangman.tryThis(((AbstractButton) e.getSource()).getText().charAt(0));
            ((JButton) e.getSource()).setEnabled(false);
        }
    }
    
}
