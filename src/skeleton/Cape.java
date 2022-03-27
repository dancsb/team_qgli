package skeleton;

import java.util.ArrayList;

/**
 * A kopeny kulonelges felszerelest megvalosito osztaly,az equipmentbol szarmazik le.
 */
public class Cape extends Equipment{

    /**
     * a kopennyel jaro vedekezesi % merteke
     */
    private long defPerc;

    /**
     * Ez a fuggveny viszi vegbe az effekteket amik vegbemennek ha felveszi a virologus a kopenyt.
     * @param v a virologus aki felveszi.
     */
    @Override
    public void action(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Cape.action()");
        ArrayList<Attribute> attributes = v.getAttributes();
        attributes.forEach(r -> r.changeDefPerc(defPerc));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Ez a fuggveny viszi vegbe az effekteket amik vegbemennek ha a virologus elveszti a kopenyt.
     * @param v a virologus aki felveszi.
     */
    @Override
    public void remove(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Cape.remove()");
        ArrayList<Attribute> attributes = v.getAttributes();
        attributes.forEach(r -> r.changeDefPerc(-defPerc));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
