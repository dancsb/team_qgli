package skeleton;

import java.util.ArrayList;

public class Storage extends Field{

    /**
     * A raktarban elhelyezett felszereles
     */
    private ArrayList<Resources> res;

    /**
     * Storage kosntruktora, storage letrehozasa benne egy megtanulhato eroforrasokkal
     * @param r1 a storage mezon megtalalhato aminosavak
     * @param r2 a storage mezon megtalalhato nukleotidok
     */
    public Storage (Resources r1, Resources r2){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Storage.constructor()");
        res = new ArrayList<>();
        res.add(r1);
        res.add(r2);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Ha egy virologus arra a mezore szeretne lepni,ez a fuggveny eldontheti, hogy lephet e oda vagy sem
     * Illetve az adott mezon levo targyak begyujteset vegzi el
     * @param v az adott storage mezore lepni kívano virologus
     * @return igaz ertekkel ter vissza ha a virologust beengedte az adott mezore, hamis ertekkel ha oda nem lephet a virologus
     */
    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Storage.accept()");
        if (super.accept(v)){
            for (Resources r: res){
                //eroforrasok begyujtese
                r.collect(v);
            }
            SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
            return true;
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return false;
    }
}
