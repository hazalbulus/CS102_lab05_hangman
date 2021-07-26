/**
 * Lab05 Part2 New Game button control class
 * @author Hazal Buluş
 * @version 1.0 26.07.2021
 */
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.event.*;
import cs102.*;

public class NewGameButtonControl extends JButton implements IHangmanView {

    private HangmanModel model;
    public NewGameButtonControl(HangmanModel model){
        this.model = model;
        this.setText("New Game");
        setBackground(Color.lightGray);
        addActionListener(new ButtonListener());
    }
    
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            model.initNewGame();
            setEnabled(false);
            
        }
    }
    public void updateView(Hangman hangman){
        
        if ( hangman.isGameOver())
            setEnabled(true);
    
    }

    
}
