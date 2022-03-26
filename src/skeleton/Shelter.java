package skeleton;

public class Shelter extends Field{
    private Equipment eq;

    public Shelter(Equipment eq) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Shelter.constructor()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        this.eq = eq;
    }

    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Shelter.accept()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        if (super.accept(v)){
            eq.collect(v);
            return true;
        }
        return false;
    }
}
