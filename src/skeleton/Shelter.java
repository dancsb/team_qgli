package skeleton;

/**
 * A shelter speciális mezőt reprezentálja
 */

public class Shelter extends Field{

    /**
     * A  felszerelés amely az óvóhelyen található meg
     */
    private Equipment eq;

    /**
     * Shelter kosntruktora, létrehozása benne egy megszerezhető felszereléssel
     * @param eq az a felszerelés amely a shleterben található meg
     */

    public Shelter(Equipment eq) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Shelter.constructor()");
        this.eq = eq;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Ha egy virológus arra a mezőre szeretne lépni, eldöntheti, hogy léphet e oda vagy sem
     * @param v az a virológus amelynek a belépését az adott mezőre elfodaja
     * @return ha léphet arra a mezőre akkor igaz értékkel tér vissza, különben hamissal
     */
    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Shelter.accept()");
        if (super.accept(v)){
            //felszerelés begyűjtése
            eq.collect(v);
            SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
            return true;
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return false;
    }
}
