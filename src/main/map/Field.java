package main.map;

import java.util.ArrayList;
import main.virologist.*;

/**
 * Egy mezot reprezental.
 */
public class  Field {

    /**
     * A szomszedos mezoket tarolo lista
     */
    private ArrayList<Field> neighbours;
    /**
     * A mezon tartozkodo virologusokat tarolo lista
     */
    private ArrayList<Virologist> virologists;

    /**
     * Field konstruktora
     */
    public Field(){
        neighbours = new ArrayList<>();
        virologists = new ArrayList<>();
    }



    /**
     * @return visszater egy adott mezo szomszedos mezoivel
     */
    public ArrayList<Field> getNeighbours() {
        return neighbours;
    }

    /**
     * Hozzaad egy szomszedot egy mezohoz
     * @param n a szomszed mezo amit hozza akarunk adni
     */
    public void addNeighbour(Field n){
        neighbours.add(n);
    }

    /**
     *
     * @return visszater a virologusokkal amelyek az adott mezon tartozkodnak
     */
    public ArrayList<Virologist> getVirologists() {
        return virologists;
    }
    /**
     * Ha egy virologus arra a mezore szeretne lepni, eldontheti, hogy lephet e oda vagy sem
     * @param v a virologus aki lepni akar
     * @return true ha lephet, false ha nem
     */
    public boolean accept(Virologist v){
        return virologists.add(v);
    }
    /**
     * Eltavolit egy virologust az adott mezorol
     * @param v az eltavolitando virolgous
     */
    public void remove(Virologist v){
        virologists.remove(v);
    }

    public void printStat() {
    }
}