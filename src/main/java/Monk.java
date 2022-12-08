import java.util.ArrayList;
import java.util.Collections;

public class Monk extends Mage {

    
    public Monk(int x, int y) {
        super(12, 7, new int[]{-4,-4}, 30, 5, "Monk");
                super.position = new Vector2(x, y);
    }
    @Override
    public void step (ArrayList<Base> enemy, ArrayList<Base> team) {
        if (getStatus()=="dead") return;
        Collections.sort (team);
        team.get(0).heal();
    }
}
