package main.items.agents;

import skeleton.SkeletonWriter;

import main.virologist.*;
import java.util.ArrayList;

/**
 * Vitustancot reprezentalo osztaly
 */
public class Vitusdance extends Agent {

    /**
     * Viutsdance agens konstruktora, melyben parameterul kapja a virologust amely lekraftolta, hatasi idot,
     * Amino es nukleo koltsegeket es a szukseges genetikai kodot
     * @param amino kraftolashoz szukseges aminosavak szama
     * @param effT az ido ameddig tart
     * @param exTime az ido ameddig nem jar le az agens
     * @param genCode kraftolashoz szukseges genetikai kod
     * @param nucleo kraftolashoz szukseges nukleotidok szama
     * @param v a tulajdonos virologus
     */
    public Vitusdance(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    /**
     * A vitusdance agens hasznalata egy masik virologuson
     * @param v a virologus amelyen az agenst hasznaljuk
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
