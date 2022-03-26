package skeleton;

import java.util.ArrayList;

public class Storage extends Field{

    /**
     * A raktárban elhelyezett felszerelés
     */
    private ArrayList<Resources> res;

    /**
     * Storage kosntruktora, storage létrehozása benne egy megtanulható erőforrásokkal
     * @param r1 a storage mezőn megtalálható aminosavak
     * @param r2 a storage mezőn megtalálható nukleotidok
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
     * Ha egy virológus arra a mezőre szeretne lépni,ez a függvény eldöntheti, hogy léphet e oda vagy sem
     * Illetve az adott mezőn lévő tárgyak begyűjtését végzi el
     * @param v az adott storage mezőre lépni kívánó virológus
     * @return igaz értékkel tér vissza ha a virológust beengedte az adott mezőre, hamis értékkel ha oda nem léphet a virológus
     */
    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Storage.accept()");
        if (super.accept(v)){
            for (Resources r: res){
                //erőforrások begyűjtése
                r.collect(v);
            }
            SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
            return true;
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return false;
    }
}
