package skeleton;

import java.util.ArrayList;

/**
 * A "Zsák" különleges felszerelést reprezentálja, leszármazik az Equipmentből
 */
public class Bag extends Equipment {

    /**
     * A mérték amivel a zsák megnöveli a virológus anyageltárolási képességét.
     */
    private long sizeIncrease;

    /**
     * Ez a függvény viszi végbe az effekteket amik végbemennek ha felveszi a virológus a zsákot.
     * @param v a virológus aki felveszi.
     */
    @Override
    public void action(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Bag.action()");
        ArrayList<Resources> resources = v.getResources();
        resources.forEach(r -> r.setMaxAmount(sizeIncrease));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Ez a függvény viszi végbe az effekteket amik végbemennek ha a virológus elveszti a zsákot.
     * @param v a virológus aki felveszi.
     */
    @Override
    public void remove(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Bag.remove()");
        ArrayList<Resources> resources = v.getResources();
        resources.forEach(r -> r.setMaxAmount(sizeIncrease));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
