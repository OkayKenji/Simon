import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private Color offColor;
    private Color onColor;
    public String id;
    private String sound; 
    public Button(Color offColor, Color onColor, String id, String sound) {
        GreenfootImage button = new GreenfootImage(275,275);
        button.setColor(offColor);
        button.fill();
        setImage(button);
        this.offColor = offColor;
        this.onColor = onColor;
        this.id = id;
        this.sound = sound;
    }

    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mousePressed(this)) {
            buttonOn();            
        } else if (Greenfoot.mouseClicked​(this))  {
            buttonOff();    
            Board myBoard = (Board) getWorld();
            myBoard.handleInput(this.id);
        }
    }

    public void buttonOn() {
        Greenfoot.playSound(sound+".wav");
        GreenfootImage button = new GreenfootImage(275,275);
        button.setColor(onColor);
        button.fill();
        setImage(button);

    }

    public void buttonOff() {
        GreenfootImage button = new GreenfootImage(275,275);
        button.setColor(offColor);
        button.fill();
        setImage(button);
    }
    
    public String toString() {
        return id;
    }
}
