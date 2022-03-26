package skeleton;

public class Shelter extends Field{
    private Equipment eq;

    public Shelter(Equipment eq) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Shelter.constructor()");
        this.eq = eq;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    @Override
    public boolean accept(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Shelter.accept()");
        if (super.accept(v)){
            eq.collect(v);
            SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
            return true;
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return false;
    }
}
