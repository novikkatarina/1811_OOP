public class Sniper extends Shooter {
    public Sniper(int x, int y) {
        super(12, 10, new int[]{8,10}, 15, 9, "Sniper", 32);
        this.position = new Vector2 (x, y);
    }
}
