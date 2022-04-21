package main.virologist;

import main.*;

/**
 * Valamilyen effektet reprezentalo osztaly, implementalja a Steppable interfacet
 */
public class Attribute implements Steppable{

    /**
     * A hatas ideje
     */
    protected long time;

    /**
     * Egy virologus paralelizalt allapotanak idejenek a beallitasa
     * @param x az ido
     */
    public void setTimePara(long x){
    }

    /**
     * Visszaadja, hogy meg mennyi ideig paralelizalt az virologus.
     * @return az ido
     */
    public long getTimePara(){
        return 0;
    }
    /**
     * Egy virologus sebezhetetlen allapotanak idejenek a beallitasa
     * @param x az ido
     */
    public void setTimeInvu(long x){
    }
    /**
     * Visszaadja, hogy meg mennyi ideig sebezhetetlen az virologus.
     * @return az ido
     */
    public long getTimeInvu(){
        return 0;
    }
    /**
     * Egy virologus vitustancot jaro allapotanak idejenek a beallitasa
     * @param x az ido
     */
    public void setTimeDance(long x){
    }
    /**
     * Visszaadja, hogy meg mennyi jar vitustancot az virologus.
     * @return az ido
     */
    public long getTimeDance(){
        return 0;
    }
    /**
     * Egy virologus "visszaveresi" allapotanak a beallitasa
     * @param x az ido
     */
    public void changeDefPerc(double x){
    }

    /**
     * Step interface fuggvenye.
     */
    @Override
    public void step() {
    }
    public void printStat(){

    }
}
