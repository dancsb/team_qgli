package main.items.collectibles;

import main.virologist.Virologist;

/**
 * A Balta eszközt reprezentáló osztály
 */
public class Axe extends Equipment{
    /**
     * Volt-e használva
     */
    private boolean used=false;
    /**
     * Az azonosítója
     */
    private final String name = "axe";

    public String getName(){return name;}

    @Override
    public void action(Virologist v) {
    }

    /**
     * Elveszíti az equipmentet
     * @param v a virologus aki elveszti
     */
    @Override
    public void remove(Virologist v) {
        v.loseEquipment(this);
    }

    @Override
    public boolean getUsed() {
        return used;
    }

    @Override
    public void setUsed(boolean used) {
        this.used=used;
    }
    @Override
    public void printStat(){
        System.out.print("axe "+used);
    }
    @Override
    public String toString(){return "axe "+used; }
}
