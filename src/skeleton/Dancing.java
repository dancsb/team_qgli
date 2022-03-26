package skeleton;

/**
 * Azt a hatást reprezentálja amikor a virológus vítustáncot jár.
 */
public class Dancing extends Attribute{
    /**
     * Beállítja, hogy mennyi ideig járja a vítustáncot a virológus.
     * @param x az idő
     */
    @Override
    public void setTimeDance(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Dancing.setTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    /**
     * Visszaadja, hogy mennyi ideig járja a vítustáncot a virológus.
     * @return az idő
     */
    @Override
    public long getTimeDance() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Dancing.getTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return time;
    }
}
