package skeleton;

import java.util.ArrayList;

public class Bag extends Equipment {

    //a mérték amivel megnöveli a zsák a virológus inventory-át
    private long sizeIncrease;

    //a zsák begyűjtését valósítja meg, és az azzal járó "inventroy növelő" képességet állítja be
    @Override
    public void action(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Bag.action()");
        ArrayList<Resources> resources = v.getResources();
        resources.forEach(r -> r.setMaxAmount(sizeIncrease));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //a zsák elvesztésekor "elveszi" a zsák által nyújtott "inventory növelő" képességet a virológustól
    @Override
    public void remove(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Bag.remove()");
        ArrayList<Resources> resources = v.getResources();
        resources.forEach(r -> r.setMaxAmount(sizeIncrease));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
