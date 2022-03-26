package skeleton;

import java.util.ArrayList;

public class AminoAcid extends Resources{
    @Override
    public void changeAmountAminoAcid(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("AminoAcid.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    @Override
    public void collect(Virologist v) {
        System.out.println("AminoAcid.collect()");
        ArrayList<Resources> rs = v.getResources();
        ArrayList<Resources> resources = v.getResources();
        for (Resources r:
                resources) {
            r.changeAmountAminoAcid(amount);
        }
    }
}
