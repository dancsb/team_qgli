package skeleton;

import java.util.ArrayList;

public class Bag extends Equipment {
    private long sizeIncrease;

    @Override
    public void action(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Bag.action()");
        ArrayList<Resources> resources = v.getResources();
        resources.forEach(r -> r.setMaxAmount(sizeIncrease));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    @Override
    public void remove(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Bag.remove()");
        ArrayList<Resources> resources = v.getResources();
        resources.forEach(r -> r.setMaxAmount(sizeIncrease));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
