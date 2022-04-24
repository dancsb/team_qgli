package main.map;

import main.items.collectibles.*;
import main.virologist.*;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A labor kulonleges mezot reprezentalja
 */
public class Lab extends Field {

    /**
     * A laboron elhelyezett genetikai kod
     */
    private GeneticCode gc;

    /**
     * Medvevirusos-e  a labor
     */
    private boolean bearRegion;

    /**
     * Lab kosntruktora
     * @param gc megtanulhato genetikai kod
     */
    public Lab(boolean mv, GeneticCode gc) {
        this.gc = gc;
        this.bearRegion = mv;
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
             v.setBearDance(bearRegion);
             return true;
         }
         return false;
    }

    /**
     * Az adott labor medvevirusossagat jelzi
     * @return medvevirusos erteke
     */
    public boolean isBearRegion() {
        return bearRegion;
    }

    /**
     * A labor adatait kiiro fuggveny
     */
    @Override
    public void printStat(HashMap<String, Virologist> hashMap, ArrayList<Field> allFields) {
        System.out.println("tipus: lab");
        printStandard(hashMap, allFields);
        System.out.println("bearRegion: " + bearRegion);
        System.out.println("geneticCode: " + gc.getName());
        System.out.println();
    }
}
