package skeleton;

public abstract class Resources implements Collectible{

    //erőforrások mennyisége
    protected long amount;
    //maximális tárolási képessége egy adott erőforrásból egy adott varázslónak
    protected long maxCapacity;


    //erőforrások felvételét megvalósító függvény
    @Override
    public abstract void collect(Virologist v);

    //megváltoztatja egy virológus átal tárolt aminosavak mennyiségét
    //ha felvesz akkor növeli , ha kraftol vagy lopnak tőle, akkor csökkenti
    public void changeAmountAminoAcid(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    //megváltoztatja egy virológus átal tárolt nukleotidok mennyiségét
    //ha felvesz akkor növeli , ha kraftol vagy lopnak tőle, akkor csökkenti
    public void changeAmountNucleotide(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //beállítja, hogy egy virológus maximálisan mennyi erőforrást tarthat magánál
    public void setMaxAmount(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeMaxAmount()");
        maxCapacity = x;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
