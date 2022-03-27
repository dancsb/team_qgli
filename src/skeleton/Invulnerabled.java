package skeleton;
/**
 * Azt a hatast reprezentalja amikor a virologus sebezhetetlen jar.
 */
public class Invulnerabled extends Attribute{
    /**
     * Vedekezesi elony merteke
     */
    private long defPrec;

    /**
     * Beallitja a sebezhetetlenseg hatasanak idjet
     * @param x az ido
     */
    @Override
    public void setTimeInvu(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Invulnerabled.setTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Visszater a sebezhetetlenseg hatasanak idejevel
     * @return visszater a sebezhetetlenseg hatasanak ideje
     */
    @Override
    public long getTimeInvu() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Invulnerabled.getTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return time;
    }

    /**
     * Megvaltoztatja a sebezhetetlenseg hatasanak merteket
     * @param x az ido
     */
    @Override
    public void changeDefPerc(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Invulnerabled.changeDefPerc()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
