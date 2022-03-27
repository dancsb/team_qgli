package skeleton;

/**
 * Azt a hatast reprezentalja amikor a virologus vítustancot jar.
 */
public class Dancing extends Attribute{
    /**
     * Beallítja, hogy mennyi ideig jarja a vítustancot a virologus.
     * @param x az ido
     */
    @Override
    public void setTimeDance(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Dancing.setTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Visszaadja, hogy mennyi ideig jarja a vítustancot a virologus.
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
