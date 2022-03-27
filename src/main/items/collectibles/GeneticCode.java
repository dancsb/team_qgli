package main.items.collectibles;

import main.virologist.*;
import skeleton.SkeletonWriter;

/**
 * Egy genetikai kodot reprezental, implementalja a Collectible interfacet
 */
public class GeneticCode implements Collectible{

    /**
     * Adott genetikai kod neve
     */
    private String name;

    /**
     * Konstruktor melyben beallitjuk a genetikai kod nevet
     * @param name a nev
     */
    public GeneticCode(String name){
        this.name = name;
    }

    /**
     * Visszaadja a genetikai kod nevet
     * @return a genetikai kod neve
     */
    public String getName() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("GeneticCode.getName()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return name;
    }

    /**
     * Genetikai kod megtanulasat vegzo fuggveny
     * @param v a virologus aki felveszi
     */
    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("GeneticCode.collect()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
