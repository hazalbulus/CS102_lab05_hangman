/**
 * Lab05 Part2 label's views
 * @author Hazal Buluş
 * @version 1.0 26.07.2021
 */
import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import cs102.*;

public class LabelsHangmanView extends JPanel implements IHangmanView{

    private JLabel label,label2,label3,label4;
    public LabelsHangmanView(){

        super();
        setPreferredSize(new Dimension(300,800));
        setLayout(new GridLayout(5,1,5,5));
        label = new JLabel();
        label4 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        
        label.setBackground(Color.lightGray);
        label2.setBackground(Color.lightGray);
        label3.setBackground(Color.lightGray);
        label4.setBackground(Color.lightGray);

        add(label);
        add(label2);
        add(label3);
        add(label4);
    }
    @Override
	public void updateView(Hangman hangman)
	{ 
        if(!hangman.isGameOver()){
            label.setText("Incorrect Tries:  " + hangman.getNumOfIncorrectTries());
            label2.setText("Known So Far: " + hangman.getKnownSoFar());
            label3.setText("Used Letters: " + hangman.getUsedLetters());
            label4.setText("Game is not over");
            
            label.setForeground(Color.blue);
            label2.setForeground(Color.blue);
            label3.setForeground(Color.blue);
            label4.setForeground(Color.blue);
        }

		if ( hangman.isGameOver() )
			if ( hangman.hasLost() )
				label4.setText("You Lost!");
			else
				label4.setText("You Won");
	}
}
