package skeleton;

import java.util.ArrayList;

public class AminoAcid extends Resources{
    @Override
    public void collect(Virologist v) {
        ArrayList<Resources> rs = v.getResources();
        ArrayList<Resources> resources = v.getResources();
        for (Resources r:
                resources) {
            r.changeAmountAminoAcid(amount);
        }
    }

    @Override
    public void changeAmountAminoAcid(long x) {
        super.changeAmountAminoAcid(x);
    }
}
