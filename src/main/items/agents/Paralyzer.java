package main.items.agents;

import main.virologist.Virologist;
/**
 * A benito agenst valositja meg, leszarmazik az Agentbol
 */
public class Paralyzer extends Agent {

    /**
     * Agens konstruktor
     * @param v a tulajdonos virologus
     * @param amino az aminosav merteke ami a craftolashoz kell
     * @param nucleo a nukleotid merteke ami a craftolashoz kell
     * @param genCode a genetikai kod ami a craftolashoz kell.
     */
    public Paralyzer(Virologist v, long amino, long nucleo, String genCode) {
        super(v, amino, nucleo, genCode);
    }

    /**
     * A benito agens hasznalata egy virologuson.
     * @param v a virologus akire megy az effekt
     */
    public void useOn(Virologist v) {
        v.getAttributes().forEach(a->a.setTimePara(effectTime));
    }
    @Override
    public void printStat(){
        System.out.print("paralyzer "+expireTime);
    }
}
