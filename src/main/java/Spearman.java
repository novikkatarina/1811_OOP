import java.util.ArrayList;

public class Spearman extends Base {
    public Spearman(int x, int y) {
        super(4, 5, new int[]{1, 3}, 10, 4, "Spearman");
        this.position = new Vector2(x, y);

    }

    @Override
    public void step(ArrayList<Base> enemy, ArrayList<Base> team) {
        if (this.status.equals("DEAD")) return;
        int nearestEnemy = -1;
        double minDistance = 10000;
        for (int i = 0; i < enemy.size(); i++) {
            if (((this.position.distance(enemy.get(i).getPosition())) < minDistance) && (enemy.get(i).getStatus().equals("ALIVE"))) {
                nearestEnemy = i;
                minDistance = (int) this.position.distance(enemy.get(i).getPosition());
            }
        }
        if (minDistance <= 1){
            enemy.get(nearestEnemy).damage(this.valueDamage(enemy.get(nearestEnemy)));
            return;}
        if (nearestEnemy != -1){
            int x = getPosition().x;
            int y = getPosition().y;
            if (enemy.get(nearestEnemy).getPosition().y > this.position.y && (checkPosibility(new Vector2(x, y+1), enemy, team) && (y<10))) {
                y++;
                setPosition(new Vector2(x, y));
            } else if (enemy.get(nearestEnemy).getPosition().y < this.position.y && (checkPosibility(new Vector2(x,y-1), enemy, team)) && (1<y)) {
                y--;
                setPosition(new Vector2(x, y));
            } else if (enemy.get(nearestEnemy).getPosition().x > this.position.x && (checkPosibility(new Vector2(x+1, y), enemy, team))&& (x<10)) {
                x++;
                setPosition(new Vector2(x, y));
            } else if (enemy.get(nearestEnemy).getPosition().x < this.position.x && (checkPosibility(new Vector2(x-1, y), enemy, team))&& (1<x)) {
                x--;
                setPosition(new Vector2(x, y));
            }
        }
    }

    private boolean checkPosibility(Vector2 position, ArrayList<Base> enemy, ArrayList<Base> team) {
        for (Base base : enemy) {
            if (!position.isEqual(base.getPosition()) && (!base.getStatus().equals("DEAD"))){
                for (Base unit : team) {
                    if (!position.isEqual(base.getPosition()) && (!base.getStatus().equals("DEAD")))
                        return true;
                }
            }
        }
        return false;
    }
}

