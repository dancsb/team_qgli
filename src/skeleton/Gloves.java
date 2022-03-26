package skeleton;

public class Gloves extends Equipment{

    @Override
    public void action(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Gloves.action()");
        v.setParry(true);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    @Override
    public void remove(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Gloves.remove()");
        v.setParry(false);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
