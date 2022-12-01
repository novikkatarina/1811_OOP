import java.util.ArrayList;
import java.util.Arrays;

public abstract class Base implements BaseInterface, Comparable<Base>{
    private int attack;
    private int protection;
    private int[] damage;
    private double health;
    private int speed;
    private String name;
    private static int idCounter;
    private int playerID;
    private double maxHealth;

    public Base(int attack, int protection, int[] damage,
            double health, int speed, String name) {
        this.attack = attack;
        this.protection = protection;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.name = name;
        playerID = idCounter++;
        maxHealth = health;
    }
    public void heal (){
        this.health = maxHealth; 
    }
    public void getdamage(){
        this.health = 0; 
    }

    
    @Override
    public void step(ArrayList<Base> group) {
    
    }

    @Override
    public String getInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public int compareTo(Base player){
        if (this.health > player.health)
            return 1;
        else if (this.health < player.health)
            return -1;
        else
        return 0;
    }


    @Override
    public String toString() {
        return  this.getClass().getSimpleName() + " " + playerID +
                " attack= " + attack +
                ", protection= " + protection +
                ", damage= " + Arrays.toString(damage) +
                ", health= " + health +
                ", speed= " + speed;
    }

}
