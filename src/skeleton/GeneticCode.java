package skeleton;

public class GeneticCode implements Collectible{

    //adott genetikai kód neve
    private String name;

    //konstruktor melyben beállítjuk a genetikai kód nevét
    public GeneticCode(String name){
        this.name = name;
    }

    //genetikai kód nevével való visszatérés
    public String getName() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("GeneticCode.getName()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return name;
    }

    //genetikai kód megtanulását végző függvény
    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("GeneticCode.collect()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
