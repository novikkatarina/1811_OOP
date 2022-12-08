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
    protected Vector2 position;
    protected String status;


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
        this.status = "alive";
    }
    public void heal (){
        this.health = maxHealth;
    }

    public int valueDamage (Base enemy) {
        int damage = 0;
        if (this.attack == enemy.protection) {
            damage = (this.damage[0] + this.damage[1]) / 2;
        }
        else if (this.attack < enemy.protection) {
            damage =this.damage[1];
        }
        else if (this.attack < enemy.protection){
            damage =this.damage[0];
        }
        if (this.position.distance(enemy.position) > this.speed) {damage = damage/2;}
        return damage;
    }

//    public void getdamage(){
//
//    }
    public void damage(int valueDamage){
        this.health = health - valueDamage;
        if (this.health<=0){
            this.status = "dead";
            this.health = 0;
        }
        if (this.health > this.maxHealth) this.health = this.maxHealth;
    }
    public String getName(){return name;}
    public String getStatus(){return status;}

    public Vector2 getPosition(){return position;}

    public boolean getDelivery(){return false;}
    protected void setStatus(String status) {this.status = status;}
    public void setDelivery(boolean value){
    }



    public void step(ArrayList<Base> enemy, ArrayList<Base> team) {
    
    }
    public static ArrayList<Base> sortingByName (ArrayList<Base> unsortedTeam, String name){
        ArrayList<Base> sortedTeam = new ArrayList<>();
        for (int i=0; i< unsortedTeam.size();i++ ){
            if (unsortedTeam.get(i).getName() == name){
                sortedTeam.add(unsortedTeam.get(i));
            }
        }
        return sortedTeam;
    }

    public static ArrayList<Base> sortedTeam(ArrayList<Base> team){
        ArrayList<Base> sortedTeam = new ArrayList<>();
        for (int i=0; i< team.size();i++ ){
            if (sortingByName(team, "Xbowman") != null){
                sortedTeam.addAll(sortingByName(team, "Xbowman"));
            }
            if (sortingByName(team, "Sniper") != null){
                sortedTeam.addAll(sortingByName(team, "Sniper"));
            }
            if (sortingByName(team, "Spearman") != null){
                sortedTeam.addAll(sortingByName(team, "Spearman"));
            }
            if (sortingByName(team, "Robber") != null){
                sortedTeam.addAll(sortingByName(team, "Robber"));
            }
            if (sortingByName(team, "Monk") != null){
                sortedTeam.addAll(sortingByName(team, "Monk"));
            }
            if (sortingByName(team, "Wizard") != null){
                sortedTeam.addAll(sortingByName(team, "Wizard"));
            }
            if (sortingByName(team, "Peasant") != null){
                sortedTeam.addAll(sortingByName(team, "Peasant"));
            }
        }
        return sortedTeam;
    }



    @Override
    public String getInfo() {
        return null;
    }


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
                " attk= " + attack +
                ", protect= " + protection +
                ", damage= " + Arrays.toString(damage) +
                ", health= " + health +
                ", speed= " + speed;
    }

}
