import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Wizard extends Mage {
    public Wizard(int x, int y) {
        super(17, 12, new int[]{-5, -5}, 30, 9, "Wizard");
        this.position = new Vector2(x, y);
    }

    @Override
    public void step(ArrayList<Base> enemy, ArrayList<Base> team) {
        if (this.status == "DEAD") return;
        ArrayList<Base> copy = new ArrayList<>(team);
        Collections.sort(copy);
        copy.get(0).heal();
    }
}
