package main.virologist;

/**
 * Azt a hatast reprezentalja amikor a virologus sebezhetetlen jar.
 */
public class Invulnerabled extends Attribute {
    /**
     * Vedekezesi elony merteke
     */
    private double defPerc;

    @Override
    public double getDefPerc() {
        return defPerc;
    }

    /**
     * Beallitja a sebezhetetlenseg hatasanak idjet
     * @param x az ido
     */
    @Override
    public void setTimeInvu(long x) {
        time = x;
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
    public void changeDefPerc(double x) {
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
    @Override
    public void printStat(){
        System.out.println("invulnerabled: "+time);
    }

    public String toString(){
        return "invulnerabled: "+time + "\n";
    }
}