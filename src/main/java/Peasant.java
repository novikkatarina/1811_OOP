public class Peasant extends Base {

    private boolean delivery;

    public Peasant() {
        super(1, 1, new int[] { 1, 1 }, 1, 3, "");
        this.delivery = true;
    }

    @Override
    public String toString() {
        return super.toString() + " delivery ";
    }

}
