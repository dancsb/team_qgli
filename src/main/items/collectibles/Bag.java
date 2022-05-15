package main.items.collectibles;

import main.virologist.Virologist;

/**
 * A "Zsak" kulonleges felszerelest reprezentalja, leszarmazik az Equipmentbol
 */
public class Bag extends Equipment {
    /**
     * A mertek amivel a zsak megnoveli a virologus anyageltarolasi kepesseget.
     */
    private final long sizeIncrease; //itt long van szóval majd csak egész számmal lehet lérehozni :D
    private final String name = "bag";

    public Bag(long sizeIncrease) {
        this.sizeIncrease = sizeIncrease;
    }
    public String getName(){return name;}

    /**
     * Ez a fuggveny viszi vegbe az effekteket amik vegbemennek ha felveszi a virologus a zsakot.
     * @param v a virologus aki felveszi.
     */
    @Override
    public void action(Virologist v) {
        //A virológus összes resourceára lekérem a mennyiségét és megszorzom a sizeIncreaseel.
        v.getResources().forEach(r->r.setMaxAmount(sizeIncrease*r.getMaxCapacity()));
    }

    /**
     * Ez a fuggveny viszi vegbe az effekteket amik vegbemennek ha a virologus elveszti a zsakot.
     * @param v a virologus aki felveszi.
     */
    @Override
    public void remove(Virologist v) {
        //A virológus összes resourceára lekérem a mennyiségét és leosztom a sizeIncreaseel.
        v.getResources().forEach(r->r.setMaxAmount(r.getMaxCapacity()/sizeIncrease));
        v.loseEquipment(this);
    }
    @Override
    public void printStat(){
        System.out.print("bag "+sizeIncrease);
    }

    @Override
    public String toString(){return "bag "+sizeIncrease; }
}
