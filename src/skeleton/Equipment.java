package skeleton;

public abstract class Equipment implements Collectible {
    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Equipment.collect()");
        action(v);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    public abstract void action(Virologist v);

    public abstract void remove(Virologist v);
}
