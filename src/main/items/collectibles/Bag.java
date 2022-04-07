package main.items.collectibles;

import main.virologist.*;
import skeleton.SkeletonWriter;
import java.util.ArrayList;

/**
 * A "Zsak" kulonleges felszerelest reprezentalja, leszarmazik az Equipmentbol
 */
public class Bag extends Equipment {

    /**
     * A mertek amivel a zsak megnoveli a virologus anyageltarolasi kepesseget.
     */
    private long sizeIncrease;

    /**
     * Ez a fuggveny viszi vegbe az effekteket amik vegbemennek ha felveszi a virologus a zsakot.
     * @param v a virologus aki felveszi.
     */
    @Override
    public void action(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Bag.action()");
        ArrayList<Resource> resources = v.getResources();
        resources.forEach(r -> r.setMaxAmount(sizeIncrease));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Ez a fuggveny viszi vegbe az effekteket amik vegbemennek ha a virologus elveszti a zsakot.
     * @param v a virologus aki felveszi.
     */
    @Override
    public void remove(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Bag.remove()");
        ArrayList<Resource> resources = v.getResources();
        resources.forEach(r -> r.setMaxAmount(sizeIncrease));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
