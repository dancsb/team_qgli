package main.items.agents;

import main.virologist.Virologist;

/**
 * A sebezhetetlen agenst valositja meg, leszarmazik az Agentbol
 */
public class Invulnerable extends Agent {

    /**
     * Agens konstruktor
     * @param v az tulajdonos virologus
     * @param amino az aminosav merteke ami a craftolashoz kell
     * @param nucleo a nukleotid merteke ami a craftolashoz kell
     * @param genCode a genetikai kod ami a craftolashoz kell.
     */
    public Invulnerable(Virologist v, long amino, long nucleo, String genCode) {
        super(v, amino, nucleo, genCode);
    }

    /**
     * A sebezhetetlen agens hasznalata egy virologuson.
     * @param v a virologus akire megy az effekt
     */
    public void useOn(Virologist v) {
        v.getAttributes().forEach(a->a.setTimeInvu(effectTime));
    }
    @Override
    public void printStat(){
        System.out.print("invulnerable "+expireTime);
        System.out.println();
    }
}
