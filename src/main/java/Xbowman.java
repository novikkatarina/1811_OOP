public class Xbowman extends Shooter {
    public Xbowman(int x, int y) {
        super(6, 3, new int[]{2,3}, 10, 4, "Xbowman", 16, 32);
        this.position = new Vector2 (x, y);
    }
}
