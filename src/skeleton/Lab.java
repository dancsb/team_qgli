package skeleton;

/**
 * A labor különleges mezőt reprezentálja
 */
public class Lab extends Field{

    /**
     * A laboron elhelyezett genetikai kód
     */
    private GeneticCode gc;
    /**
     * Lab kosntruktora
     * @param gc megtanulható genetikai kód
     */
    public Lab(GeneticCode gc) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.constructor()");
        this.gc = gc;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Az adott laborban megtalálható genetikai kóddal tér vissza
     * @return adott laborban megtalálható genetikai kód
     */
    public GeneticCode getGeneticCode() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.getGeneticCode()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return gc;
    }
    /**
     * Ha egy virológus arra a mezőre szeretne lépni, eldöntheti, hogy léphet e oda vagy sem, és ha odaléphet megtanulja a genetikai kódot
     * @param v a virológus aki lépni akar
     * @return true ha odaléphet, false ha nem
     */
    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.accept()");
         if (super.accept(v)){
             //genetikai kód megtanulása
             gc.collect(v);
             SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
             return true;
         }
         SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
         return false;
    }
}
