package main.items.collectibles;

import main.virologist.Virologist;

/**
 * Egy felszerelest reprezentalo osztaly, abstract, implementalja a Collectiblet.
 */
public abstract class Equipment implements Collectible {
    /**
     * Egy felszereles begyujteset valositja meg, es az azzal jaro hatast/kepesseget allitja be
     * @param v a virologus aki felveszi
     */
    @Override
    public void collect(Virologist v) {
        //Az equipment meghívja a leszáramzott actionjét
        action(v);
    }
    /**
     * Beallitja a felszereles felvetelevel jaro hatast
     * @param v a virologus aki felveszi
     */
    public abstract void action(Virologist v);
    /**
     * Egy felszereles elvesztesekor "elveszi" a felszereles altal nyujtott hatast/kepesseget a virologustol
     * @param v a virologus aki elveszti
     */
    public abstract void remove(Virologist v);

    /**
     * Visszaadja, hogy mennyi a durability-je egy eszköznek, a kesztyű miatt kell, minden másnál -1-et ad vissza
     * @return -1 ha nem kesztyű
     */
    public int getDurability(){
        return -1;
    }

    /**
     * Beállítjuk az eszköz durabilityjét, csak a kesztyűnél fog valamit csinálni.
     * @param durability mennyi legyen az eszköz durabilityje
     */
    public void setDurability(int durability){

    }

    /**
     * Visszaadja, hogy volt-e már használva az eszköz, a balta miatt kell.
     * @return true ha használt,false ha nem
     */
    public boolean getUsed(){
        return true;
    }

    /**
     * Beállítja, hogy az eszköz volt-e már használva a balta miatt kell
     * @param used volt-e már használva.
     */
    public void setUsed(boolean used){}

    public abstract void printStat();
    public String toString(){return null;}
    public String getName(){return null;}
}
