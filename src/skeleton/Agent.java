package skeleton;

import java.util.ArrayList;

/**
 *  Ágenst megvalósító class, implementálja a Steppablet.
 */
public abstract class Agent implements Steppable {
    /**
     * Az a virológus akié az ágens.
     */
    protected Virologist owner;
    /**
     * Amennyi ideig tart az effekt.
     */
    protected long effectTime;
    /**
     * Amennyi aminosavba kerül az ágens létrehozása.
     */
    protected long costAmino;
    /**
     * Amennyi nukleotid kerül az ágens létrehozása.
     */
    protected long costNucleotide;
    /**
     * Amennyi idő múlva elévül az ágens.
     */
    protected long expireTime;
    /**
     * Amelyik genetikai kódra szükség van az ágens létrehozásához.
     */
    protected String requireGenCode;

    //ágens konstruktora, melyben paraméterül kapja a Virologust amely lekraftolta, hatási időt, amino és nukleo költségeket és a szükséges genetikai kódot

    /**
     * Ágens konstruktora
     * @param v a virológus aki owner lesz
     * @param effT az idő amennyi ideig tart az effekt
     * @param amino amennyi aminosavra szükség van a craftoláshoz
     * @param nucleo amennyi nukleotidra szükség van a craftoláshoz
     * @param exTime mennyi ideig tartson az ágens
     * @param genCode a genetikai kód amihez szükség lesz a craftoláshoz
     */
    public Agent(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        owner = v;
        effectTime = effT;
        costAmino = amino;
        costNucleotide = nucleo;
        expireTime = exTime;
        requireGenCode = genCode;
    }

    /**
     * @return Visszadja az ágens tulajdonosát
     */
    public Virologist getOwner() {
        return owner;
    }

    /**
     * @return Visszaadja, hogy mennyi ideig tart az ágens effektje.
     */
    public long getEffectTime() {
        return effectTime;
    }
    /**
     * @return Visszaadja, hogy mennyi aminosavba kerül a létrehozása.
     */
    public long getCostAmino() {
        return costAmino;
    }
    /**
     * @return Visszaadja, hogy mennyi nukleotidba kerül a létrehozása.
     */
    public long getCostNucleotide() {
        return costNucleotide;
    }
    /**
     * @return Visszaadja, hogy mennyi idő múlva jár le.
     */
    public long getExpireTime() {
        return expireTime;
    }
    /**
     * @return Visszaadja, hogy melyik genCode kell a létrehozásához.
     */
    public String getRequireGenCode() {
        return requireGenCode;
    }

    /**
     * Abstract függvény, ami akkor fut le  ha egy ágenst felhasználódik egy virológuson.
     * @param v a virológus akire megy az effekt
     */
    public abstract void useOn(Virologist v);

    /**
     * step inferface függvénye
     */
    public void step() {
        System.out.println("Agent.step()");
    }

    /**
     * a kratfoláshoz szükséges erőforrások felhasználása, ezek levonása az adott viológustól
     * @param v virológus aki craftol
     */
    public void getCrafted(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Agent.getCrafted()");
        ArrayList<Resources> resource = v.getResources();
        for (Resources r:
             resource) {
            v.loseResources(r);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
