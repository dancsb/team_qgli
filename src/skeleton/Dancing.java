package skeleton;

public class Dancing extends Attribute{
    @Override
    public void setTimeDance(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Dancing.setTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    @Override
    public long getTimeDance() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Dancing.getTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return time;
    }
}
