package main.virologist;

/**
 * Azt a hatast reprezentalja amikor a virologus vitustancot jar.
 */
public class Dancing extends Attribute {
    /**
     * Beallitja, hogy mennyi ideig jarja a vitustancot a virologus.
     * @param x az ido
     */
    @Override
    public void setTimeDance(long x) {
        time = x;
    }

    /**
     * Visszaadja, hogy mennyi ideig jarja a vitustancot a virologus.
     * @return az ido
     */
    @Override
    public long getTimeDance() {
        return time;
    }

    /**
     * Csokkenti a vitustanc hatasanak idejet
     */
    public void step() {
        if (time > 0)
            time--;
    }
    @Override
    public void printStat(){
        System.out.println("vitustancol: "+time);
    }

    public String toString(){
        return "vitustancol: " + time + "\n";
    }
}
