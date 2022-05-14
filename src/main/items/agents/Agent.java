package main.items.agents;

import main.Steppable;
import main.virologist.Virologist;

import java.util.Random;

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
     * @param amino amennyi aminosavra szukseg van a craftolashoz
     * @param nucleo amennyi nukleotidra szukseg van a craftolashoz
     * @param genCode a genetikai kod amihez szukseg lesz a craftolashoz
     */
    public Agent(Virologist v, long amino, long nucleo,String genCode) {
        owner = v;
        //2 meg 5 között ideig tart
        effectTime = 2+new Random().nextInt()%4;
        costAmino = amino;
        costNucleotide = nucleo;
        //3-tól 10 körig marad meg.
        expireTime = 10;
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
        expireTime--;
    }

    /**
     * a kratfolashoz szukseges eroforrasok felhasznalasa, ezek levonasa az adott viologustol
     * @param v virologus aki craftol
     */
    public void getCrafted(Virologist v) {
        if(v.getGenCode().stream().anyMatch(g->requireGenCode.equals(g.getName()))
               && costAmino<=v.getResources().get(0).getAmount()
               && costNucleotide<=v.getResources().get(1).getAmount()){
           //Nem értem a loseResources az mit csinál v.getResources().forEach(r->v.loseResources(costAmino));
            v.getResources().get(0).changeAmountAminoAcid(-costAmino);
            v.getResources().get(1).changeAmountNucleotide(-costNucleotide);
            v.getAgents().add(this);
        }

    }
    public void printStat(){

    }
    public String toString(){
        return null;
    }
}
