package main.map;

import main.items.collectibles.*;
import main.virologist.*;
import skeleton.SkeletonWriter;

/**
 * A labor kulonleges mezot reprezentalja
 */
public class Lab extends Field {

    /**
     * A laboron elhelyezett genetikai kod
     */
    private GeneticCode gc;
    /**
     * Lab kosntruktora
     * @param gc megtanulhato genetikai kod
     */
    public Lab(GeneticCode gc) {
        this.gc = gc;
    }
    /**
     * Az adott laborban megtalalhato genetikai koddal ter vissza
     * @return adott laborban megtalalhato genetikai kod
     */
    public GeneticCode getGeneticCode() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.getGeneticCode()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return gc;
    }
    /**
     * Ha egy virologus arra a mezore szeretne lepni, eldontheti, hogy lephet e oda vagy sem, es ha odalephet megtanulja a genetikai kodot
     * @param v a virologus aki lepni akar
     * @return true ha odalephet, false ha nem
     */
    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.accept()");
         if (super.accept(v)){
             //genetikai kod megtanulasa
             gc.collect(v);
             SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
             return true;
         }
         SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
         return false;
    }
}
