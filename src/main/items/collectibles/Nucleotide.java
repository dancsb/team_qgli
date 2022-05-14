package main.items.collectibles;

import main.virologist.Virologist;

public class Nucleotide extends Resource {


    public Nucleotide(long amount, long maxCapacity) {
        super(amount, maxCapacity);
    }

    /**
     * Megvaltoztatja egy virologus atal tarolt nukleotidok mennyiseget
     * Ha felvesz akkor noveli , ha kraftol vagy lopnak tole, akkor csokkenti, attol fugg milyen elojelu szamot kap
     * @param x egy ertek amivel valtoztatja a nukleotidok szamat
     */
    @Override
    public void changeAmountNucleotide(long x) {
        amount+=x;
    }

    /**
     *  Nukleotidok felvetelet megvalosito fuggveny
     * @param v a virologus aki felveszi a nukleotidot.
     */
    @Override
    public void collect(Virologist v) {
        //Lekérem a resourcest és ami nucleotid ott átállítom annyival amit az r ad
        if(v.getResources().get(1).getAmount() + amount <= v.getResources().get(1).maxCapacity)
            v.getResources().forEach(r->r.changeAmountNucleotide(amount));
    }
    @Override
    public void printStat(){
        System.out.print(amount);
    }

    @Override
    public String toString(){return amount + " ";}
}
