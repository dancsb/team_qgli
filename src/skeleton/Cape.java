package skeleton;

import java.util.ArrayList;

/**
 * A köpeny különelges felszerelést megvalósító osztály,az equipmentből származik le.
 */
public class Cape extends Equipment{

    /**
     * a köpennyel járó védekezési % mértéke
     */
    private long defPerc;

    /**
     * Ez a függvény viszi végbe az effekteket amik végbemennek ha felveszi a virológus a köpenyt.
     * @param v a virológus aki felveszi.
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
     * Ez a függvény viszi végbe az effekteket amik végbemennek ha a virológus elveszti a köpenyt.
     * @param v a virológus aki felveszi.
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
