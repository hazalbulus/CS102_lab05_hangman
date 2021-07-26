/**
 * Lab05 Part2 text filed panel control class
 * @author Hazal Buluş
 * @version 1.0 26.07.2021
 */
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.event.*;
import cs102.*;

public class TextFieldControlPanel extends JPanel {
    private HangmanModel hangman;
    private JTextField text;

    public TextFieldControlPanel(HangmanModel hangman){
        super();
        this.hangman = hangman;
        text = new JTextField(20);
        text.addActionListener(new TextListener());
        setBackground(Color.lightGray);
        add(text);
    }
    private class TextListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(text != null){
                for(int i= 0; i < text.getText().length(); i++){
                    hangman.tryThis(text.getText().charAt(i));
                }
                text.setText("");
            }
        }
    }
}
