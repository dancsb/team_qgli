package main.items.collectibles;

import main.virologist.Virologist;

/**
 * A kopeny kulonelges felszerelest megvalosito osztaly,az equipmentbol szarmazik le.
 */
public class Cape extends Equipment{
    /**
     * a kopennyel jaro vedekezesi % merteke
     */
    private double defPerc;
    private final String name = "cape";

    /**
     * A köpeny constructora
     * @param defPerc mennyi % esélye van annak, hogy levédi? Pl:37
     */
    public Cape(double defPerc) {
        this.defPerc = defPerc;
    }
    public String getName(){return name;}

    /**
     * Ez a fuggveny viszi vegbe az effekteket amik vegbemennek ha felveszi a virologus a kopenyt.
     * @param v a virologus aki felveszi.
     */
    @Override
    public void action(Virologist v) {
        //Lekérem a virológus attribútumait végigmegyek rajtuk és átállítom a def %-ot
        v.getAttributes().forEach(a->a.changeDefPerc(defPerc));
    }

    /**
     * Ez a fuggveny viszi vegbe az effekteket amik vegbemennek ha a virologus elveszti a kopenyt.
     * @param v a virologus aki felveszi.
     */
    @Override
    public void remove(Virologist v) {
        //Lekérem a virológus attribútumait végigmegyek rajtuk és átállítom a def %-ot
        v.getAttributes().forEach(a->a.changeDefPerc(-defPerc));
        v.loseEquipment(this);
    }
    @Override
    public void printStat(){
        System.out.print("cape "+defPerc);
    }
    @Override
    public String toString(){return "cape "+defPerc; }
}
