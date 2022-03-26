package skeleton;

public class Lab extends Field{
    private GeneticCode gc;

    public Lab(GeneticCode gc) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.constructor()");
        this.gc = gc;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    public GeneticCode getGeneticCode() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.getGeneticCode()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return gc;
    }

    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Lab.accept()");
         if (super.accept(v)){
             gc.collect(v);
             SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
             return true;
         }
         SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
         return false;
    }
}
