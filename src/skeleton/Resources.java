package skeleton;

/**
 * A gyujthető erőforrásokat reprezentálja
 */

public abstract class Resources implements Collectible{

    /**
     * Eltárolható erőforrások mennyisége és egy virológus által a maximális eltárolható mennyiség
     */
    protected long amount;
    protected long maxCapacity;


    /**
     * Erőforrások felvételét megvalósító függvény
     * @param v a virológus amely felvette az adott erőforrást
     */
    @Override
    public abstract void collect(Virologist v);

    /**
     * Megváltoztatja egy virológus átal tárolt aminosavak mennyiségét
     * Ha felvesz akkor növeli , ha kraftol vagy lopnak tőle, akkor csökkenti
     * @param x az érték amennyivel változtatja az aminosavak mennyiségét
     */
    public void changeAmountAminoAcid(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Megváltoztatja egy virológus átal tárolt nukleotidok mennyiségét
     * Ha felvesz akkor növeli , ha kraftol vagy lopnak tőle, akkor csökkenti
     * @param x az érték amennyivel változtatja a nukleotidok mennyiségét
     */
    public void changeAmountNucleotide(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Beállítja, hogy egy virológus maximálisan mennyi erőforrást tarthat magánál
     * @param x az érték amennyire állítódik a maximálisan tárolható erőforrások száma
     */
    public void setMaxAmount(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeMaxAmount()");
        maxCapacity = x;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
