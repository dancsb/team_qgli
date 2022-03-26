package skeleton;

import java.util.ArrayList;

public class Nucleotide extends Resources{



    /**
     * megváltoztatja egy virológus átal tárolt nukleotidok mennyiségét
     * ha felvesz akkor növeli , ha kraftol vagy lopnak tőle, akkor csökkenti, attól függ milyen előjelű számot kap
     * @param x egy érték amivel változtatja a nukleotidok számát
     */
    @Override
    public void changeAmountNucleotide(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Nucleotide.changeAmountNucleotide()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     *  nukleotidok felvételét megvalósító függvény
     * @param v a Virológus aki felveszi a nukleotidot.
     */
    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Nucleotide.collect()");
        ArrayList<Resources> resources = v.getResources();
        for (Resources r:
                resources) {
            //megnöveli a nukleotidok számát
            r.changeAmountNucleotide(amount);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
