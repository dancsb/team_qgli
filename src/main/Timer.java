package main;

import java.util.ArrayList;

/**
 * Timer osztaly megvalositasa
 */
public class Timer {

    private ArrayList<Steppable>steppables;

    public void tick(){
       steppables.forEach(Steppable::step);
    }

    public void addSteppable(Steppable s){
        steppables.add(s);
    }
}
