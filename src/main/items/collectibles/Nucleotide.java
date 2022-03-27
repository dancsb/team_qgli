package main.items.collectibles;

import main.virologist.*;
import skeleton.SkeletonWriter;
import java.util.ArrayList;

public class Nucleotide extends Resources {



    /**
     * Megvaltoztatja egy virologus atal tarolt nukleotidok mennyiseget
     * Ha felvesz akkor noveli , ha kraftol vagy lopnak tole, akkor csokkenti, attol fugg milyen elojelu szamot kap
     * @param x egy ertek amivel valtoztatja a nukleotidok szamat
     */
    @Override
    public void changeAmountNucleotide(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Nucleotide.changeAmountNucleotide()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     *  Nukleotidok felvetelet megvalosito fuggveny
     * @param v a virologus aki felveszi a nukleotidot.
     */
    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Nucleotide.collect()");
        ArrayList<Resources> resources = v.getResources();
        for (Resources r:
                resources) {
            //megnoveli a nukleotidok szamat
            r.changeAmountNucleotide(amount);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
