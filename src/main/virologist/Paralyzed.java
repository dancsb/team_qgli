package main.virologist;

public class Paralyzed extends Attribute {

    /**
     * Beallitja a benasag hatasanak idejet
     * @param x az ido merteke amennyire bena lesz az adott varazslo
     */
    @Override
    public void setTimePara(long x) {
        time = x;
    }

    /**
     * Visszater a benasag hatasanak idejevel
     * @return visszater a hatas idejevel
     */
    @Override
    public long getTimePara() {
        return time;
    }

    /**
     * Csokkenti a benasag hatasanak idejet
     */
    public void step() {
        if (time > 0)
            time--;
    }
    @Override
    public void printStat(){
        System.out.println("paralyzed: "+time);
    }
}
