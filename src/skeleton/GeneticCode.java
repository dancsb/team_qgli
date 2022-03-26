package skeleton;

/**
 * Egy genetikai kódot reprezentál, implementálja a Collectible interfacet
 */
public class GeneticCode implements Collectible{

    /**
     * Adott genetikai kód neve
     */
    private String name;

    /**
     * Konstruktor melyben beállítjuk a genetikai kód nevét
     * @param name a név
     */
    public GeneticCode(String name){
        this.name = name;
    }

    /**
     * Visszaadja a genetikai kód nevét
     * @return a genetikai kód neve
     */
    public String getName() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("GeneticCode.getName()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return name;
    }

    /**
     * Genetikai kód megtanulását végző függvény
     * @param v a virológus aki felveszi
     */
    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("GeneticCode.collect()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
