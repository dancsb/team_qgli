package skeleton;

import java.util.ArrayList;

/**
 * Ez az osztály reprezentálja az Aminosavat, leszármazik a Resourcesből.
 */
public class AminoAcid extends Resources{


    /**
     * megváltoztatja egy virológus átal tárolt aminosavak mennyiségét
     * ha felvesz akkor növeli , ha kraftol vagy lopnak tőle, akkor csökkenti
     * @param x a mennyiség amivel változik az aminosav
     */
    @Override
    public void changeAmountAminoAcid(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("AminoAcid.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * aminosavak felvételét megvalósító függvény
     * @param v a Virológus aki felveszi az aminosavat
     */

    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("AminoAcid.collect()");
        ArrayList<Resources> resources = v.getResources();
        for (Resources r:
                resources) {
            //megnöveli az aminosavak számát
            r.changeAmountAminoAcid(amount);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
