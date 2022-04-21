package main.map;

import main.items.collectibles.*;
import main.virologist.*;

/**
 * A labor kulonleges mezot reprezentalja
 */
public class Lab extends Field {

    /**
     * A laboron elhelyezett genetikai kod
     */
    private GeneticCode gc;
    private boolean medvevirusos;
    /**
     * Lab kosntruktora
     * @param gc megtanulhato genetikai kod
     */
    public Lab(boolean mv, GeneticCode gc) {
        this.gc = gc;
        this.medvevirusos = mv;
    }
    /**
     * Az adott laborban megtalalhato genetikai koddal ter vissza
     * @return adott laborban megtalalhato genetikai kod
     */
    public GeneticCode getGeneticCode() {
        return gc;
    }
    /**
     * Ha egy virologus arra a mezore szeretne lepni, eldontheti, hogy lephet e oda vagy sem, es ha odalephet megtanulja a genetikai kodot
     * @param v a virologus aki lepni akar
     * @return true ha odalephet, false ha nem
     */
    @Override
    public boolean accept(Virologist v) {
         if (super.accept(v)){
             //genetikai kod megtanulasa
             gc.collect(v);
             return true;
         }
         return false;
    }
}
