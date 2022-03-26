package skeleton;

/**
 * Valamilyen effektet reprezentáló osztály, implementálja a Steppable interfacet
 */
public class Attribute implements Steppable{

    /**
     * A hatás ideje
     */
    protected long time;

    /**
     * egy virológus paralelizált állapotának idejének a beállítása
     * @param x az idő
     */
    public void setTimePara(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.setTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Visszaadja, hogy még mennyi ideig paralelizált az virológus.
     * @return az idő
     */
    public long getTimePara(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.getTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    /**
     * Egy virológus sebezhetetlen állapotának idejének a beállítása
     * @param x az idő
     */
    public void setTimeInvu(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.setTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Visszaadja, hogy még mennyi ideig sebezhetetlen az virológus.
     * @return az idő
     */
    public long getTimeInvu(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.getTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    /**
     * Egy virológus vitustáncot járó állapotának idejének a beállítása
     * @param x az idő
     */
    public void setTimeDance(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.setTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Visszaadja, hogy még mennyi jár vitustáncot az virológus.
     * @return az idő
     */
    public long getTimeDance(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.getTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    /**
     * Egy virológus "visszaverési" állapotának a beállítása
     * @param x az idő
     */
    public void changeDefPerc(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.changeDefPerc()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Step interface függvénye.
     */
    @Override
    public void step() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.step()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
