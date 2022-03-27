package skeleton;

import java.util.ArrayList;

/**
 * Ez az osztaly reprezentalja az Aminosavat, leszarmazik a Resourcesbol.
 */
public class AminoAcid extends Resources{


    /**
     * Megvaltoztatja egy virologus atal tarolt aminosavak mennyiseget
     * Ha felvesz akkor noveli , ha kraftol vagy lopnak tole, akkor csokkenti
     * @param x a mennyiseg amivel valtozik az aminosav
     */
    @Override
    public void changeAmountAminoAcid(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("AminoAcid.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Aminosavak felvetelet megvalosito fuggveny
     * @param v a Virologus aki felveszi az aminosavat
     */

    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("AminoAcid.collect()");
        ArrayList<Resources> resources = v.getResources();
        for (Resources r:
                resources) {
            //megnoveli az aminosavak szamat
            r.changeAmountAminoAcid(amount);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
