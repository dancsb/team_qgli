package skeleton;

import java.util.ArrayList;
/**
 * A bénító ágenst valósítja meg, leszármazik az Agentből
 */
public class Paralyzer extends Agent {

    /**
     * Ágens konstruktor
     * @param v a tulajdonos virológus
     * @param effT az idő ameddig tart
     * @param amino az aminosav mértéke ami a craftoláshoz kell
     * @param nucleo a nukleotid mértéke ami a craftoláshoz kell
     * @param exTime az idő ameddig nem jár le az ágens
     * @param genCode a genetikai kód ami a craftoláshoz kell.
     */
    public Paralyzer(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    /**
     * A bénító ágens használata egy virológuson.
     * @param v a virológus akire megy az effekt
     */
    public void useOn(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Paralyzer.useOn()");
        ArrayList<Attribute> attribute=v.getAttributes();
        for (Attribute a:attribute) {
            a.setTimePara(effectTime);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
