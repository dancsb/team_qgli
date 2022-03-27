package skeleton;

/**
 * Azt a hatast reprezentalja amikor a virologus vitustancot jar.
 */
public class Dancing extends Attribute{
    /**
     * Beallitja, hogy mennyi ideig jarja a vitustancot a virologus.
     * @param x az ido
     */
    @Override
    public void setTimeDance(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Dancing.setTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Visszaadja, hogy mennyi ideig jarja a vitustancot a virologus.
     * @return az ido
     */
    @Override
    public long getTimeDance() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Dancing.getTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return time;
    }
}
