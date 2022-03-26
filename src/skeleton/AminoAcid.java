package skeleton;

import java.util.ArrayList;

public class AminoAcid extends Resources{

    //megváltoztatja egy virológus átal tárolt aminosavak mennyiségét
    //ha felvesz akkor növeli , ha kraftol vagy lopnak tőle, akkor csökkenti
    @Override
    public void changeAmountAminoAcid(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("AminoAcid.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //aminosavak felvételét megvalósító függvény
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
