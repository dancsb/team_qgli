package skeleton;

public class Shelter extends Field{

    //az óvóhelyen elhelyezett felszerelés
    private Equipment eq;

    //shelter kosntruktora, létrehozása benne egy megszerezhető felszereléssel
    public Shelter(Equipment eq) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Shelter.constructor()");
        this.eq = eq;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //ha egy virológus arra a mezőre szeretne lépni, eldöntheti, hogy léphet e oda vagy sem
    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Shelter.accept()");
        if (super.accept(v)){
            //felszerelés begyűjtése
            eq.collect(v);
            SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
            return true;
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return false;
    }
}
