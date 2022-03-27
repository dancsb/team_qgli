package skeleton;

public class Paralyzed extends Attribute{

    /**
     * Beallitja a benasag hatasanak idjet
     * @param x az ido merteke amennyire bena lesz az adott varazslo
     */
    @Override
    public void setTimePara(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Paralyzed.setTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Visszater a benasag hatasanak idjevel
     * @return visszater a hatas idejevel
     */
    @Override
    public long getTimePara() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Paralyzed.getTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return time;
    }
}
