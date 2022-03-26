package skeleton;

import java.util.ArrayList;

public class Storage extends Field{

    private ArrayList<Resources> res;

    public Storage (Resources r1, Resources r2){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Storage.constructor()");
        res = new ArrayList<>();
        res.add(r1);
        res.add(r2);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Storage.accept()");
        if (super.accept(v)){
            for (Resources r: res){
                r.collect(v);
            }
            SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
            return true;
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return false;
    }
}
