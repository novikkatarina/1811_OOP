import java.util.ArrayList;
import java.util.Collections;

public class Monk extends Mage {

    
    public Monk(int x, int y) {
        super(12, 7, new int[]{-4,-4}, 30, 5, "Monk");
                super.position = new Vector2(x, y);
    }
    @Override
    public void step (ArrayList<Base> group) {
        Collections.sort (group);
        group.get(0).heal();     
    }
}
