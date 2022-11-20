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

}
