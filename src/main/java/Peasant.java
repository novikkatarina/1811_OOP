public class Peasant extends Base {

    private boolean delivery;

    public Peasant(int x, int y) {
        super(1, 1, new int[] { 1, 1 }, 1, 3, "Peasant");
        this.delivery = true;
        super.position = new Vector2(x, y);
    }

    @Override
    public String toString() {
        return super.toString() + " delivery ";
    }

}
