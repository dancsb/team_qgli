package main.map;

import View.IView;
import View.View;
import main.items.collectibles.Equipment;
import main.items.collectibles.Resource;
import main.virologist.Virologist;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Egy mezot reprezental.
 */
public class  Field implements IView {

    /**
     * A szomszedos mezoket tarolo lista
     */
    protected ArrayList<Field> neighbours;
    /**
     * A mezon tartozkodo virologusokat tarolo lista
     */
    protected ArrayList<Virologist> virologists;

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
        if (!n.neighbours.contains(this))
            n.addNeighbour(this);
    }

    /**
     *
     * @return visszater a virologusokkal amelyek az adott mezon tartozkodnak
     */
    public ArrayList<Virologist> getVirologists() {
        return virologists;
    }

    public Equipment getEquipment() {
        return null;
    }

    public ArrayList<Resource> getResources() {
        return null;
    }

    /**
     * Ha egy virologus arra a mezore szeretne lepni, eldontheti, hogy lephet e oda vagy sem
     * @param v a virologus aki lepni akar
     * @return true ha lephet, false ha nem
     */
    public boolean accept(Virologist v){
        v.setField(this);
        return virologists.add(v);
    }

    /**
     * Eltavolit egy virologust az adott mezorol
     * @param v az eltavolitando virolgous
     */
    public void remove(Virologist v){
        virologists.remove(v);
    }

    /**
     * Egy mező adatainak kiirasa (leszarmazottak ezt meghivjak)
     */
    protected void printStandard(HashMap<String, Virologist> hashMap, ArrayList<Field> allFields) {
        System.out.print("szomszedok: ");
        //szomszedok
        if (neighbours.size() == 0) {
            System.out.println("null");
        } else {
            for (Field f :
                    neighbours) {
                System.out.print(allFields.indexOf(f));
                if (neighbours.get(neighbours.size()-1) != f)
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.print("virologusokNevei: ");
        //virologusok
        if (virologists.size() == 0) {
            System.out.println("null");
        } else {
            for (String key :
                    hashMap.keySet()) {
                if (virologists.contains(hashMap.get(key))) {
                    System.out.print(key + " ");
                }
            }
            System.out.println();
        }
    }

    /**
     * A mezo adatait kiiro fuggveny + ures sorral
     */
    public void printStat(HashMap<String, Virologist> hashMap, ArrayList<Field> allFields) {
        System.out.println("tipus: field");
        printStandard(hashMap,allFields);
    }

    /**
     * kirajzoltat egy fieldet
     * @param v a View amire ki kell rajzolni
     * @param idx a field indexe ami = a polygon indexével így tudja hova kell rajzolni
     */
    @Override
    public void mustDraw(View v,int idx) {
        v.drawField();
        for(Virologist viro:virologists){
            viro.mustDraw(v,idx);
        }
    }
}