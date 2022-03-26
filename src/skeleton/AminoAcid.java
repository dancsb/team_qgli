package skeleton;

import java.util.ArrayList;

public class AminoAcid extends Resources{
    @Override
    public void changeAmountAminoAcid(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("AminoAcid.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("AminoAcid.collect()");
        ArrayList<Resources> resources = v.getResources();
        for (Resources r:
                resources) {
            r.changeAmountAminoAcid(amount);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
