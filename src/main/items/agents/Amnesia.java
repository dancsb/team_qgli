package main.items.agents;

import main.virologist.*;
import skeleton.SkeletonWriter;

/**
 * Amnezia agenst reprezentalja.
 */
public class Amnesia extends Agent {

    /**
     * Agens konstruktor
     * @param v az tulajdonos virologus
     * @param effT az ido ameddig tart
     * @param amino az aminosav merteke ami a craftolashoz kell
     * @param nucleo a nukleotid merteke ami a craftolashoz kell
     * @param exTime az ido ameddig nem jar le az agens
     * @param genCode a genetikai kod ami a craftolashoz kell.
     */
    public Amnesia(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    /**
     * Az amnezia agens hasznalata egy virologuson.
     * @param v a virologus akire megy az effekt
     */
    public void useOn(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Amnesia.useOn()");
        //Elfelejti az osszes genetikai kodjat, ezert kell a .clear()
        v.getGenCode().clear();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);

    }
}
