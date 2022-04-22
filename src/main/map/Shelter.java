package main.map;

import main.items.collectibles.*;
import main.virologist.*;

/**
 * A shelter specialis mezot reprezentalja
 */

public class Shelter extends Field {

    /**
     * A  felszereles, amely az ovohelyen talalhato meg
     */
    private Equipment eq;

    /**
     * Shelter kosntruktora, letrehozasa benne egy megszerezheto felszerelessel
     * @param eq az a felszereles amely a shleterben talalhato meg
     */

    public Shelter(Equipment eq) {
        this.eq = eq;
    }

    /**
     * Ha egy virologus arra a mezore szeretne lepni, eldontheti, hogy lephet e oda vagy sem
     * Ha arra a mezore lep akkor elvegzi az eroforrasok begyujteset
     * @param v az a virologus amelynek a belepeset az adott mezore elfodaja
     * @return ha lephet arra a mezore akkor igaz ertekkel ter vissza, kulonben hamissal
     */
    @Override
    public boolean accept(Virologist v) {
        if (super.accept(v)){
            //felszereles begyujtese
            eq.collect(v);
            return true;
        }
        return false;
    }

    /**
     * A shelter adatait kiiro fuggveny
     */
    @Override
    public void printStat() {
        super.printStat();
        System.out.println("equipment: " + eq.getName());
    }
}
