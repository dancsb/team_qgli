package main.items.collectibles;

import skeleton.SkeletonWriter;
import main.virologist.*;

/**
 * A gyujtheto eroforrasokat reprezentalja
 */

public abstract class Resources implements Collectible{

    /**
     * Eltarolhato eroforrasok mennyisege es egy virologus altal a maximalis eltarolhato mennyiseg
     */
    protected long amount;
    protected long maxCapacity;


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
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.getAmount()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return amount;
    }

    /**
     * Megvaltoztatja egy virologus atal tarolt aminosavak mennyiseget
     * Ha felvesz akkor noveli , ha kraftol vagy lopnak tole, akkor csokkenti
     * @param x az ertek amennyivel valtoztatja az aminosavak mennyiseget
     */
    public void changeAmountAminoAcid(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Megvaltoztatja egy virologus atal tarolt nukleotidok mennyiseget
     * Ha felvesz akkor noveli , ha kraftol vagy lopnak tole, akkor csokkenti
     * @param x az ertek amennyivel valtoztatja a nukleotidok mennyiseget
     */
    public void changeAmountNucleotide(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Beallitja, hogy egy virologus maximalisan mennyi eroforrast tarthat maganal
     * @param x az ertek amennyire allitodik a maximalisan tarolhato eroforrasok szama
     */
    public void setMaxAmount(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeMaxAmount()");
        maxCapacity = x;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
