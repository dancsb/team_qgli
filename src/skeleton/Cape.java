package skeleton;

import java.util.ArrayList;

public class Cape extends Equipment{
    private long defPerc;
    @Override
    public void action(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Cape.action()");
        ArrayList<Attribute> attributes = v.getAttributes();
        attributes.forEach(r -> r.changeDefPerc(defPerc));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    @Override
    public void remove(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Cape.remove()");
        ArrayList<Attribute> attributes = v.getAttributes();
        attributes.forEach(r -> r.changeDefPerc(-defPerc));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
