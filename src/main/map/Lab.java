package main.map;

import View.View;
import main.items.collectibles.*;
import main.virologist.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

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

    private static ArrayList<GeneticCode>allGencodes=new ArrayList<>(){{add(new GeneticCode("paralyzer"));
                                                                        add(new GeneticCode("invulnerable"));
                                                                        add(new GeneticCode("vitusdance"));
                                                                        add(new GeneticCode("amensia"));}};

    private static int current=0;
    /**
     * Lab kosntruktora
     * @param gc megtanulhato genetikai kod
     */
    public Lab(boolean mv, GeneticCode gc) {
        this.gc = gc;
        bearRegion = mv;
    }
    public Lab(){
        int r=new Random().nextInt(100);
        this.bearRegion=r<25;
        bearRegion = true;
        this.gc=allGencodes.get(current);
        current=(current+1)%4;
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
             if(bearRegion)
                v.setBearDance(true);
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
    }

    @Override
    public void mustDraw(View v,int idx) {
        v.drawLab(idx);
        for(Virologist viro:virologists){
            viro.mustDraw(v,idx);
        }
    }
}
