/**
 * Hangman model class Lab05 Part 1/b
 * @author Hazal Buluş
 * @version 1.0 15.07.2021
 */
package ConsoleHangman.src;

import java.util.ArrayList;

import cs102.Hangman;

public class HangmanModel extends Hangman {
    //Properties
    private IHangmanView iView;
    private ArrayList<IHangmanView> views;

    //Constructor
    public HangmanModel(BasicSetup setup) {
        super(setup);
        views = new ArrayList<IHangmanView>();
    }
    
    /**
     * Adding given view to views arraylist
     * @param view
     */
    public void addView(IHangmanView view){
        views.add(view);
    }

    /**
     * This method updates the views of all viewers in arraylist
     */
    public void update(){
        for(int i = 0; i< views.size(); i++){
            views.get(i).updateView(this);
            System.out.println("=================================");
        }
    }

    /**
     * checks the given char whether it is in the secret word or not
     * @return count
     */
    @Override
    public int tryThis(char ch){
       return super.tryThis(ch);
    
    }
    
    /**
     * this method initializes the game
     */
    @Override
    public void initNewGame(){
        super.initNewGame();
    }
    
}
