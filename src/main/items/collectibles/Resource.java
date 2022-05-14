package main.items.collectibles;

import main.virologist.Virologist;

/**
 * A gyujtheto eroforrasokat reprezentalja
 */

public abstract class Resource implements Collectible{

    /**
     * Eltarolhato eroforrasok mennyisege es egy virologus altal a maximalis eltarolhato mennyiseg
     */
    protected long amount;
    protected long maxCapacity;

    public Resource(long amount, long maxCapacity) {
        this.amount = amount;
        this.maxCapacity = maxCapacity;
    }

    /**
     * Eroforrasok felvetelet megvalosito fuggveny
     * @param v a virologus amely felvette az adott eroforrast
     */
    @Override
    public abstract void collect(Virologist v);

    /**
     * Megadja az eroforras mennyiseget
     * @return amount erteke
     */
    public long getAmount() {
        return amount;
    }

    public long getMaxCapacity() {
        return maxCapacity;
    }

    /**
     * Megvaltoztatja egy virologus atal tarolt aminosavak mennyiseget
     * Ha felvesz akkor noveli , ha kraftol vagy lopnak tole, akkor csokkenti
     * @param x az ertek amennyivel valtoztatja az aminosavak mennyiseget
     */
    public void changeAmountAminoAcid(long x){}

    /**
     * Megvaltoztatja egy virologus atal tarolt nukleotidok mennyiseget
     * Ha felvesz akkor noveli , ha kraftol vagy lopnak tole, akkor csokkenti
     * @param x az ertek amennyivel valtoztatja a nukleotidok mennyiseget
     */
    public void changeAmountNucleotide(long x){}
    /**
     * Beallitja, hogy egy virologus maximalisan mennyi eroforrast tarthat maganal
     * @param x az ertek amennyire allitodik a maximalisan tarolhato eroforrasok szama
     */
    public void setMaxAmount(long x){
        maxCapacity = x;
    }

    public void printStat(){
    }
    public String toString(){return null;}
}
