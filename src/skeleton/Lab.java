package skeleton;

public class Lab extends Field{
    private GeneticCode gc;

    public Lab(GeneticCode gc) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Lab.constructor()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        this.gc = gc;
    }

    public GeneticCode getGeneticCode() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Lab.getGeneticCode()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return gc;
    }

    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Lab.accept()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
         if (super.accept(v)){
             gc.collect(v);
             return true;
         }
         return false;
    }
}
