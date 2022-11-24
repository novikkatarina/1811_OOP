import java.util.ArrayList;
import java.util.Collections;

public class Monk extends Mage {

    
    public Monk() {
        super(12, 7, new int[]{-4,-4}, 30, 5, "");
    }
    @Override
    public void step (ArrayList<Base> group) {
        Collections.sort (group);
        group.get(0).heal();     
    }
}
