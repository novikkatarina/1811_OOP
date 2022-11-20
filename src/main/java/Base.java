import java.util.Arrays;

public abstract class Base {
    private int attack;
    private int protection;
    private int[] damage;
    private double health;
    private int speed;
    private String name;
    private static int idCounter;
    private int playerID;

    public Base(int attack, int protection, int[] damage,
            double health, int speed, String name) {
        this.attack = attack;
        this.protection = protection;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.name = name;
        playerID = idCounter++;
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
