package main;

import main.map.Field;
import main.map.Map;
import main.virologist.Virologist;
import skeleton.SkeletonWriter;

import java.awt.*;
import java.util.ArrayList;

/**
 * A Game osztaly idnitja el a jatekot.
 */
public class Game {
    /**
     * A palya
     */
    private Map map;
    private ArrayList<Virologist>viros=new ArrayList<>();

    public Game(Map m) {
        map = m;
    }

    public ArrayList<Virologist> getViros() {
        return viros;
    }

    /**
     * A jatek inditasa
     */

    public void startGame(){
    }

    /**
     * Jatek vege, akkor hivodik meg, ha checkWin() igaz ertekkel ter visssza
     */
    public static boolean endGame(){
        return false;
    }

    public Map getMap() {
        return map;
    }
    public void generateMap(ArrayList<Polygon>polygons){
        map=new Map(polygons);
    }
}
