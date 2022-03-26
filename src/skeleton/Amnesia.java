package skeleton;

import java.util.ArrayList;

/**
 * Amnézia ágenst reprezentálja.
 */
public class Amnesia extends Agent {

    /**
     *
     * @param v az tulajdonos virológus
     * @param effT az idő ameddig tart
     * @param amino az aminosav mértéke ami a craftoláshoz kell
     * @param nucleo a nukleotid mértéke ami a craftoláshoz kell
     * @param exTime az idő ameddig nem jár le az ágens
     * @param genCode a genetikai kód ami a craftoláshoz kell.
     */
    public Amnesia(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    /**
     * Az amnézia ágens használata egy virológuson.
     * @param v a virológus akire megy az effekt
     */
    public void useOn(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Amnesia.useOn()");
        //Elfelejti az összes genetikai kódját, ezért kell a .clear()
        v.getGenCode().clear();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);

    }
}
