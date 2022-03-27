package main.items.collectibles;

import main.virologist.*;
import skeleton.SkeletonWriter;

/**
 * A kesztyu kulonleges felszerelest reprezentalja, leszarmazik az Equipment osztalybol.
 */
public class Gloves extends Equipment{
    /**
     * A kesztyu begyujteset valositja meg, es az azzal jaro "visszakenes" kepesseget allitja be
     * @param v a virologus aki felveszi
     */
    @Override
    public void action(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Gloves.action()");
        v.setParry(true);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * A kesztyu elvesztesekor "elveszi" a kesztyu altal nyujtott "visszakenes" kepesseget a virologustol
     * @param v a virologus aki elveszti
     */
    @Override
    public void remove(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Gloves.remove()");
        v.setParry(false);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
