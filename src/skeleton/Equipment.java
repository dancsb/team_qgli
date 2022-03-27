package skeleton;

/**
 * Egy felszerelest reprezentalo osztaly, abstract, implementalja a Collectiblet.
 */
public abstract class Equipment implements Collectible {
    /**
     * Egy felszereles begyujteset valositja meg, es az azzal jaro hatast/kepesseget allitja be
     * @param v a virologus aki felveszi
     */
    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Equipment.collect()");
        action(v);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Beallitja a felszereles felvetelevel jaro hatast
     * @param v a virologus aki felveszi
     */
    public abstract void action(Virologist v);
    /**
     * Egy felszereles elvesztesekor "elveszi" a felszereles altal nyujtott hatast/kepesseget a virologustol
     * @param v a virologus aki elveszti
     */
    public abstract void remove(Virologist v);
}
