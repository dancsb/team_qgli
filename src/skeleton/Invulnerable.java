package skeleton;

import java.util.ArrayList;

/**
 * A sebezhetetlen agenst valositja meg, leszarmazik az Agentbol
 */
public class Invulnerable extends Agent {

    /**
     * Agens konstruktor
     * @param v az tulajdonos virologus
     * @param effT az ido ameddig tart
     * @param amino az aminosav merteke ami a craftolashoz kell
     * @param nucleo a nukleotid merteke ami a craftolashoz kell
     * @param exTime az ido ameddig nem jar le az agens
     * @param genCode a genetikai kod ami a craftolashoz kell.
     */
    public Invulnerable(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    /**
     * A sebezhetetlen agens hasznalata egy virologuson.
     * @param v a virologus akire megy az effekt
     */
    public void useOn(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Invulnerable.useOn()");
        ArrayList<Attribute> attribute=v.getAttributes();
        for (Attribute a:attribute) {
            a.setTimeInvu(effectTime);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
