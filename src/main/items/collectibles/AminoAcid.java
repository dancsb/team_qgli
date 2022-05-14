package main.items.collectibles;

import main.virologist.Virologist;

/**
 * Ez az osztaly reprezentalja az Aminosavat, leszarmazik a Resourcesbol.
 */
public class AminoAcid extends Resource {

    /**
     * Amino konstruktor
     * @param amount mennyi legyen
     * @param maxCapacity mennyi a max
     */
    public AminoAcid(long amount, long maxCapacity) {
        super(amount, maxCapacity);
    }

    /**
     * Megvaltoztatja egy virologus atal tarolt aminosavak mennyiseget
     * Ha felvesz akkor noveli , ha kraftol vagy lopnak tole, akkor csokkenti
     * @param x a mennyiseg amivel valtozik az aminosav
     */
    @Override
    public void changeAmountAminoAcid(long x) {
        amount+=x;
    }

    /**
     * Aminosavak felvetelet megvalosito fuggveny
     * @param v a Virologus aki felveszi az aminosavat
     */

    @Override
    public void collect(Virologist v) {
        //Lekérem a resourcest és ami aminoacid ott átállítom annyival amit az r ad
        if(v.getResources().get(0).getAmount() + amount <= v.getResources().get(0).maxCapacity)
            v.getResources().get(0).changeAmountAminoAcid(amount);
    }
    @Override
    public void printStat(){
        System.out.print(amount+" ");
    }

    @Override
    public String toString(){return amount + ", ";}
}
