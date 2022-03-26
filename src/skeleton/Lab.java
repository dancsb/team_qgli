package skeleton;

public class Lab extends Field{

    //a laborban elhelyezett genetikai kód
    private GeneticCode gc;

    //lab kosntruktora, létrehozása benne egy megtanulható genetikai kóddal
    public Lab(GeneticCode gc) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.constructor()");
        this.gc = gc;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //az adott laborban megtalálható genetikai kóddal tér vissza
    public GeneticCode getGeneticCode() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.getGeneticCode()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return gc;
    }

    //ha egy virológus arra a mezőre szeretne lépni, eldöntheti, hogy léphet e oda vagy sem
    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.accept()");
         if (super.accept(v)){
             //genetikai kód megtanulása
             gc.collect(v);
             SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
             return true;
         }
         SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
         return false;
    }
}
