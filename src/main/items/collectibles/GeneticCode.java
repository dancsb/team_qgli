package main.items.collectibles;

import main.virologist.Virologist;

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
        return name;
    }

    /**
     * Genetikai kod megtanulasat vegzo fuggveny
     * @param v a virologus aki felveszi
     */
    @Override
    public void collect(Virologist v) {
        v.addGeneticCode(this);
    }
    public void printStat(){
        System.out.print(name + " ");
    }
    public String toString(){
        return name + " ";
    }
}
