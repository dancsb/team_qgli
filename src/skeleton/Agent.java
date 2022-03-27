package skeleton;

import java.util.ArrayList;

/**
 *  Agenst megvalosito class, abstract, implementalja a Steppablet.
 */
public abstract class Agent implements Steppable {
    /**
     * Az a virologus akie az agens.
     */
    protected Virologist owner;
    /**
     * Amennyi ideig tart az effekt.
     */
    protected long effectTime;
    /**
     * Amennyi aminosavba kerul az agens letrehozasa.
     */
    protected long costAmino;
    /**
     * Amennyi nukleotid kerul az agens letrehozasa.
     */
    protected long costNucleotide;
    /**
     * Amennyi ido mulva elevul az agens.
     */
    protected long expireTime;
    /**
     * Amelyik genetikai kodra szukseg van az agens letrehozasahoz.
     */
    protected String requireGenCode;

    //agens konstruktora, melyben parameterul kapja a Virologust amely lekraftolta, hatasi idot, amino es nukleo koltsegeket es a szukseges genetikai kodot

    /**
     * Agens konstruktora
     * @param v a virologus aki owner lesz
     * @param effT az ido amennyi ideig tart az effekt
     * @param amino amennyi aminosavra szukseg van a craftolashoz
     * @param nucleo amennyi nukleotidra szukseg van a craftolashoz
     * @param exTime mennyi ideig tartson az agens
     * @param genCode a genetikai kod amihez szukseg lesz a craftolashoz
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
     * @return Visszadja az agens tulajdonosat
     */
    public Virologist getOwner() {
        return owner;
    }

    /**
     * @return Visszaadja, hogy mennyi ideig tart az agens effektje.
     */
    public long getEffectTime() {
        return effectTime;
    }
    /**
     * @return Visszaadja, hogy mennyi aminosavba kerul a letrehozasa.
     */
    public long getCostAmino() {
        return costAmino;
    }
    /**
     * @return Visszaadja, hogy mennyi nukleotidba kerul a letrehozasa.
     */
    public long getCostNucleotide() {
        return costNucleotide;
    }
    /**
     * @return Visszaadja, hogy mennyi ido mulva jar le.
     */
    public long getExpireTime() {
        return expireTime;
    }
    /**
     * @return Visszaadja, hogy melyik genCode kell a letrehozasahoz.
     */
    public String getRequireGenCode() {
        return requireGenCode;
    }

    /**
     * Abstract fuggveny, ami akkor fut le  ha egy agenst felhasznalodik egy virologuson.
     * @param v a virologus akire megy az effekt
     */
    public abstract void useOn(Virologist v);

    /**
     * step inferface fuggvenye
     */

    public void step() {
        System.out.println("Agent.step()");
    }

    /**
     * a kratfolashoz szukseges eroforrasok felhasznalasa, ezek levonasa az adott viologustol
     * @param v virologus aki craftol
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
