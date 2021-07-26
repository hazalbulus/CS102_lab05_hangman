/**
 * Lab05 Part2 HangMan's view class
 * @author Hazal Buluş
 * @version 1.0 26.07.2021
 */
import cs102.*;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GallowsHangmanView extends JPanel implements IHangmanView{
    private HangmanModel hangman;
    public GallowsHangmanView(HangmanModel hangman){
        setBackground(Color.pink);
        this.hangman = hangman;
        setVisible(true);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(20, 400, 300, 40);
        g.fillRect(30, 100, 10, 300);
        g.fillRect(40, 100, 150, 10);
        g.fillRect(170, 110, 6, 30);
        
        if(hangman.getNumOfIncorrectTries() == 1)
        {
            g.drawOval(133, 140, 80, 80);
        }
        if(hangman.getNumOfIncorrectTries() == 2)
        {
            g.drawOval(133, 140, 80, 80);
            g.drawLine(173, 220, 173, 300);
        }
        if(hangman.getNumOfIncorrectTries() == 3)
        {
            g.drawOval(133, 140, 80, 80);
            g.drawLine(173, 220, 173, 300);
            g.drawLine(173, 300, 118, 356);
        }
        if(hangman.getNumOfIncorrectTries() == 4)
        {
            g.drawOval(133, 140, 80, 80);
            g.drawLine(173, 220, 173, 300);
            g.drawLine(173, 300, 117, 356);
            g.drawLine(173, 300, 229, 356);
        }
        if(hangman.getNumOfIncorrectTries() == 5)
        {
            g.drawOval(133, 140, 80, 80);
            g.drawLine(173, 220, 173, 300);
            g.drawLine(173, 300, 117, 356);
            g.drawLine(173, 300, 229, 356);
            g.drawLine(173, 240, 117, 296);
        }
        if(hangman.getNumOfIncorrectTries() == 6)
        {
            g.drawOval(133, 140, 80, 80);
            g.drawLine(173, 220, 173, 300);
            g.drawLine(173, 300, 117, 356);
            g.drawLine(173, 300, 229, 356);
            g.drawLine(173, 240, 117, 296);
            g.drawLine(173, 240, 229, 296);
        }
    }
    
    @Override
    public void updateView(Hangman hangmanModel) 
    {
		repaint();
    }
    
}
