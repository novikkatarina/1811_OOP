import java.util.ArrayList;

public abstract class Shooter extends Base {
    private int shots;

    protected Shooter(int attack, int protection, int[] damage,
                      double health, int speed, String name, int shots) {
        super(attack, protection, damage, health, speed, name);
        this.shots = shots;
    }

    @Override
    public String toString() {
        return super.toString() + " shots= " + shots;
    }

    @Override
    public void step(ArrayList<Base> enemy, ArrayList<Base> team) {
        if (getStatus()=="dead") return;
        if (shots <= 0) return;
        for (int i = 0; i <team.size(); i++){
            if ((team.get(i).getName() == "Peasant") && (team.get(i).getStatus() == "alive") && (team.get(i).getDelivery() == true)){
                team.get(i).setDelivery(false);
                team.get(i).setStatus("used");
            }
        }
        int nearestEnemy = 0;
        double minDistance = 10000;
        for (int i = 0; i <enemy.size(); i++){
            if ((this.position.distance(enemy.get(i).getPosition())) < minDistance){
                nearestEnemy = i;
                minDistance = this.position.distance(enemy.get(i).getPosition());
            }
            }
        enemy.get(nearestEnemy).damage(this.valueDamage(enemy.get(nearestEnemy)));
        this.shots--;
    }
}
