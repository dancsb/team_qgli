package skeleton;

import java.util.ArrayList;

public class Nucleotide extends Resources{
    @Override
    public void changeAmountNucleotide(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Nucleotide.changeAmountNucleotide()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Nucleotide.collect()");
        ArrayList<Resources> rs = v.getResources();
        ArrayList<Resources> resources = v.getResources();
        for (Resources r:
                resources) {
            r.changeAmountNucleotide(amount);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
