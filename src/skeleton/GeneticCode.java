package skeleton;

public class GeneticCode implements Collectible{
    private String name;

    public GeneticCode(String name){
        this.name = name;
    }

    public String getName() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("GeneticCode.getName()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return name;
    }

    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("GeneticCode.collect()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
