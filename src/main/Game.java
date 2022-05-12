package main;

import main.map.Map;
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

    public Game(Map m) {
        map = m;
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
    public static void endGame(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Game.endGame()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
