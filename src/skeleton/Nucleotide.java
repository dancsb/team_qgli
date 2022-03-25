package skeleton;

import java.util.ArrayList;

public class Nucleotide extends Resources{
    @Override
    public void changeAmountNucleotide(long x) {
        super.changeAmountNucleotide(x);
    }

    @Override
    public void collect(Virologist v) {
        ArrayList<Resources> rs = v.getResources();
        ArrayList<Resources> resources = v.getResources();
        for (Resources r:
                resources) {
            r.changeAmountNucleotide(amount);
        }
    }
}
