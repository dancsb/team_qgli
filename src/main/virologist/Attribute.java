package main.virologist;

import main.*;
import skeleton.SkeletonWriter;

/**
 * Valamilyen effektet reprezentalo osztaly, implementalja a Steppable interfacet
 */
public class Attribute implements Steppable{

    /**
     * A hatas ideje
     */
    protected long time;

    /**
     * egy virologus paralelizalt allapotanak idejenek a beallitasa
     * @param x az ido
     */
    public void setTimePara(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.setTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Visszaadja, hogy meg mennyi ideig paralelizalt az virologus.
     * @return az ido
     */
    public long getTimePara(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.getTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    /**
     * Egy virologus sebezhetetlen allapotanak idejenek a beallitasa
     * @param x az ido
     */
    public void setTimeInvu(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.setTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Visszaadja, hogy meg mennyi ideig sebezhetetlen az virologus.
     * @return az ido
     */
    public long getTimeInvu(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.getTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    /**
     * Egy virologus vitustancot jaro allapotanak idejenek a beallitasa
     * @param x az ido
     */
    public void setTimeDance(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.setTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Visszaadja, hogy meg mennyi jar vitustancot az virologus.
     * @return az ido
     */
    public long getTimeDance(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.getTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    /**
     * Egy virologus "visszaveresi" allapotanak a beallitasa
     * @param x az ido
     */
    public void changeDefPerc(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.changeDefPerc()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Step interface fuggvenye.
     */
    @Override
    public void step() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.step()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
