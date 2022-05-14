package main;

import main.map.Field;
import main.map.Map;
import main.virologist.Virologist;
import skeleton.SkeletonWriter;

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

    public void round(Field f){

    }
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
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Game.startGame()");
        //map = new Map();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
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
}
