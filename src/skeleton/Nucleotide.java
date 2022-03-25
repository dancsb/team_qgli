package skeleton;

import java.util.ArrayList;

public class Nucleotide extends Resources{
    @Override
    public void changeAmountNucleotide(long x) {
        System.out.println("Nucleotide.changeAmountNucleotide()");
        super.changeAmountNucleotide(x);
    }

    @Override
    public void collect(Virologist v) {
        System.out.println("Nucleotide.collect()");
        ArrayList<Resources> rs = v.getResources();
        ArrayList<Resources> resources = v.getResources();
        for (Resources r:
                resources) {
            r.changeAmountNucleotide(amount);
        }
    }
}
