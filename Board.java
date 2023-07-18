import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board extends World
{
    Button yellow;
    Button green;
    Button red;
    Button blue;
    boolean waitingForInput;
    //int delayCount = 100;
    int index = 0;
    int MaxIndex = 1;
    final int ONTIME = 60;
    ArrayList<Button> buttonInputs; 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Board()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        yellow = new Button(new Color(50,50,0), new Color(255,255,0), "Yellow","2a#");
        green = new Button(new Color(0,50,0), new Color(0,255,0), "Green","2a");
        red = new Button(new Color(50,0,0), new Color(255,0,0), "Red", "2b");
        blue = new Button(new Color(0,0,50), new Color(0,0,255),"Blue","2c#" );
        addObject(yellow, getWidth()/4,getHeight()/4 ); 
        addObject(green, getWidth() - getWidth()/4,getHeight()/4 ); 
        addObject(red, getWidth()/4,getWidth() - getHeight()/4 ); 
        addObject(blue, getWidth() - getWidth()/4,getWidth() - getHeight()/4 ); 
        buttonInputs = new ArrayList<Button>();
        for (int i = 0 ; i < 100 ; i++ ) {
            int num = Greenfoot.getRandomNumber(4);
            switch(num) {
                case 0:
                    buttonInputs.add(yellow);
                    break;
                case 1:
                    buttonInputs.add(green);
                    break;
                case 2: 
                    buttonInputs.add(red);
                    break;
                case 3:
                    buttonInputs.add(blue);
                    break;
            }
            
        }
    }

    public void act() {
        if (waitingForInput) {
            // does something
        } else {
            if (index == MaxIndex - 1) {
                buttonInputs.get(index).buttonOn();
                Greenfoot.delay(ONTIME);
                buttonInputs.get(index).buttonOff();
                
                index++;
                //System.out.println("wait");
            } else if (index < MaxIndex - 1 ){
                buttonInputs.get(index).buttonOn();
                Greenfoot.delay(ONTIME);
                buttonInputs.get(index).buttonOff();
                index++;
                //System.out.println("wait");
            } 
            if (index >= MaxIndex) {
                index = 0;
                waitingForInput = true; 
                System.out.println("go");
            } 
        }
    }
    
    public void handleInput(String button) {
        if (button.equals(buttonInputs.get(index).id) )  { // step corrct 
            index++;
        } else { // incorrect
            index = 0; 
            waitingForInput = false;
            Greenfoot.stop();
            System.out.println("Incorrect");
        }
        
        if (index >= MaxIndex ) { // all correct 
            MaxIndex++;
            index = 0;
            waitingForInput = false;
            System.out.println("Correct: "+(MaxIndex-1));
            Greenfoot.delay(30);
        }
    }
}
