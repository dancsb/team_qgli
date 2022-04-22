package main.items.collectibles;

import main.virologist.Virologist;

/**
 * A kesztyu kulonleges felszerelest reprezentalja, leszarmazik az Equipment osztalybol.
 */
public class Gloves extends Equipment{
    private int durability=3;

    /**
     * A kesztyu begyujteset valositja meg, es az azzal jaro "visszakenes" kepesseget allitja be
     * @param v a virologus aki felveszi
     */
    @Override
    public void action(Virologist v) {
        v.setParry(true);
    }
    /**
     * A kesztyu elvesztesekor "elveszi" a kesztyu altal nyujtott "visszakenes" kepesseget a virologustol
     * @param v a virologus aki elveszti
     */
    @Override
    public void remove(Virologist v) {
        v.setParry(false);
    }

    /**
     * Visszaadja, hogy még mennyiszer használható.
     * @return egy int, hogy mennyiszer használható
     */
    @Override
    public int getDurability() {
        return durability;
    }

    /**
     * Beállíthatjuk, hogy még mennyiszer használható a kesztyű.
     * @param durability mennyi legyen az eszköz durabilityje
     */
    @Override
    public void setDurability(int durability) {
        this.durability=durability;
    }
    @Override
    public void printStat(){
        System.out.print("gloves "+durability);
    }
}
