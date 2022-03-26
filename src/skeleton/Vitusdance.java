package skeleton;

import java.util.ArrayList;

/**
 * Vitustáncot reprezentáló osztály
 */
public class Vitusdance extends Agent {

    /**
     * Viutsdance ágens konstruktora, melyben paraméterül kapja a virologust amely lekraftolta, hatási időt,
     * Amino és nukleo költségeket és a szükséges genetikai kódot
     * @param amino kraftoláshoz szükséges aminosavak száma
     * @param effT az idő ameddig tart
     * @param exTime az idő ameddig nem jár le az ágens
     * @param genCode kraftoláshoz szükséges genetikai kód
     * @param nucleo kraftoláshoz szükséges nukleotidok száma
     * @param v a tulajdonos virológus
     */
    public Vitusdance(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    /**
     * A vitusdance ágens használata egy másik virológuson
     * @param v a virológus amelyen az ágenst használjuk
     */
    public void useOn(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Vitusdance.useOn()");
        ArrayList<Attribute> attribute=v.getAttributes();
        for (Attribute a:attribute) {
            a.setTimeDance(effectTime);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
