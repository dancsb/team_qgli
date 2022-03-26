package skeleton;

/**
 * Egy felszerelést reprezentáló osztály, abstract, implementálja a Collectiblet.
 */
public abstract class Equipment implements Collectible {
    /**
     * egy felszerelés begyűjtését valósítja meg, és az azzal járó hatást/képességet állítja be
     * @param v a virológus aki felveszi
     */
    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Equipment.collect()");
        action(v);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * beállitja a felszerelés felvételével járó hatást
     * @param v a virológus aki felveszi
     */
    public abstract void action(Virologist v);
    /**
     * egy felszerelés elvesztésekor "elveszi" a felszerelés által nyújtott hatást/képességet a virológustól
     * @param v a virológus aki elveszti
     */
    public abstract void remove(Virologist v);
}
