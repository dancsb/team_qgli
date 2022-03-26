package skeleton;

import java.util.ArrayList;

public class Storage extends Field{

    //a raktárban elhelyezett felszerelés
    private ArrayList<Resources> res;

    //storage kosntruktora, létrehozása benne egy megtanulható erőforrásokkal
    public Storage (Resources r1, Resources r2){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Storage.constructor()");
        res = new ArrayList<>();
        res.add(r1);
        res.add(r2);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //ha egy virológus arra a mezőre szeretne lépni, eldöntheti, hogy léphet e oda vagy sem
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
