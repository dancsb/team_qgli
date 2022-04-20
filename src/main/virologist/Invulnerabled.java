package main.virologist;

/**
 * Azt a hatast reprezentalja amikor a virologus sebezhetetlen jar.
 */
public class Invulnerabled extends Attribute {
    /**
     * Vedekezesi elony merteke
     */
    private long defPerc;

    /**
     * Beallitja a sebezhetetlenseg hatasanak idjet
     * @param x az ido
     */
    @Override
    public void setTimeInvu(long x) {
    }

    /**
     * Visszater a sebezhetetlenseg hatasanak idejevel
     * @return visszater a sebezhetetlenseg hatasanak ideje
     */
    @Override
    public long getTimeInvu() {
        return time;
    }

    /**
     * Megvaltoztatja a sebezhetetlenseg hatasanak merteket
     * @param x az ido
     */
    @Override
    public void changeDefPerc(long x) {
        defPerc = x;
    }

    /**
     * Csokkenti a sebezhetetlenseg hatasanak idejet
     */
    public void step() {
        if (time > 0)
            time--;
        if (time == 0)
            defPerc -= 100;
    }
}