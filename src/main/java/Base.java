import java.util.ArrayList;

public abstract class Base implements BaseInterface, Comparable<Base> {
    private final int attack;
    private final int protection;
    private final int[] damage;
    private double health;
    private final int speed;
    private final String name;
    private static int idCounter;
    private final int playerID;
    private final double maxHealth;
    protected Vector2 position;
    protected String status;


    public Base(int attack, int protection, int[] damage, double health, int speed, String name) {
        this.attack = attack;
        this.protection = protection;
        this.damage = damage;
        this.health = health;
        this.speed = speed;
        this.name = name;
        playerID = idCounter++;
        maxHealth = health;
        this.status = "ALIVE";
    }

    public void heal() {
        this.health = maxHealth;
    }

    public int valueDamage(Base enemy) {
        int damage;
        if (this.attack == enemy.protection) {
            damage = (this.damage[0] + this.damage[1]) / 2;
        } else if (this.attack < enemy.protection) {
            damage = this.damage[1];
        } else {
            damage = this.damage[0];
        }
        if (this.position.distance(enemy.position) > this.speed) {
            damage = damage / 2;
        }
        return damage;
    }

    public void damage(int valueDamage) {
        this.health = health - valueDamage;
        if (this.health <= 0) {
            this.status = "DEAD";
            this.health = 0;
        }
        if (this.health > this.maxHealth) this.health = this.maxHealth;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Vector2 getPosition() {
        return position;
    }

    public boolean getDelivery() {
        return false;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDelivery(boolean value) {
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }


    public void step(ArrayList<Base> enemy, ArrayList<Base> team) {

    }

    public static ArrayList<Base> sortingByName(ArrayList<Base> unsortedTeam, String name) {
        ArrayList<Base> sortedTeam1 = new ArrayList<>();
        for (int i = 0; i < unsortedTeam.size(); i++) {
            if (unsortedTeam.get(i).getName().equals(name)) {
                sortedTeam1.add(unsortedTeam.get(i));
            }
        }
        return sortedTeam1;
    }

    public static ArrayList<Base> sortedWhiteTeam(ArrayList<Base> team) {
        ArrayList<Base> sortedTeam = new ArrayList<>();
        for (int i = 0; i < team.size(); i++) {
            if (!sortingByName(team, "Sniper").isEmpty()) {
                sortedTeam.addAll(sortingByName(team, "Sniper"));
            }
            if (!sortingByName(team, "Robber").isEmpty()) {
                sortedTeam.addAll(sortingByName(team, "Robber"));
            }
            if (!sortingByName(team, "Wizard").isEmpty()) {
                sortedTeam.addAll(sortingByName(team, "Wizard"));
            }
            if (!sortingByName(team, "Peasant").isEmpty()) {
                sortedTeam.addAll(sortingByName(team, "Peasant"));
            }
            return sortedTeam;
        }
        return sortedTeam;
    }

    public static ArrayList<Base> sortedBlackTeam(ArrayList<Base> team) {
        ArrayList<Base> sortedTeam = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < team.size(); i++) {
            if (!sortingByName(team, "Xbowman").isEmpty()) {
                sortedTeam.addAll(sortingByName(team, "Xbowman"));
                n++;
            }
            if (!sortingByName(team, "Spearman").isEmpty()) {
                sortedTeam.addAll(sortingByName(team, "Spearman"));
                n++;
            }

            if (!sortingByName(team, "Monk").isEmpty()) {
                sortedTeam.addAll(sortingByName(team, "Monk"));
                n++;
            }
            if (!sortingByName(team, "Peasant").isEmpty()) {
                sortedTeam.addAll(sortingByName(team, "Peasant"));
                n++;
            }
            return sortedTeam;
//            if (n==10) return sortedTeam;

        }
        return sortedTeam;
    }


    public int compareTo(Base player) {
        if (this.health > player.health) return 1;
        else if (this.health < player.health) return -1;
        else return 0;
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " " + playerID +
//                " attk= " + attack +
//                ", protect= " + protection +
//                ", damage= " + Arrays.toString(damage) +
                " Health " + health + "  MAXhealth" + maxHealth + "  speed= " + speed + this.coloringStatus();
    }

    public String coloringStatus() {
        String str = "null";
        if (this.status.equals("ALIVE")) {
            str = AnsiColors.ANSI_PURPLE + "  ALIVE " + AnsiColors.ANSI_RESET;
        }
        if (this.status.equals("DEAD")) {
            str = AnsiColors.ANSI_RED + "   DEAD" + AnsiColors.ANSI_RESET;
        }
        return str;
    }

}
