package main.items.agents;

import main.virologist.Virologist;

/**
 * Amnezia agenst reprezentalja.
 */
public class Amnesia extends Agent {

    public Amnesia(Virologist v, long amino, long nucleo, String genCode) {
        super(v, amino, nucleo, genCode);
    }

    /**
     * Az amnezia agens hasznalata egy virologuson.
     * @param v a virologus akire megy az effekt
     */
    public void useOn(Virologist v) {
        //Elfelejti az osszes genetikai kodjat, ezert kell a .clear()
        v.getGenCode().clear();
    }
    @Override
    public void printStat(){
        System.out.print("amnesia "+expireTime); System.out.println();
    }
    @Override
    public String toString(){
        if(expireTime > 0) return "        amnesia agens felhasznalhato meg "+expireTime + " korig\n";
        else return null;
    }
}
