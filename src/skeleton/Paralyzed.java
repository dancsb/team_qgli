package skeleton;

public class Paralyzed extends Attribute{

    /**
     * Beállítja a bénaság hatásának idjét
     * @param x az idő mértéke amennyire béna lesz az adott varázsló
     */
    @Override
    public void setTimePara(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Paralyzed.setTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Visszatér a bénaság hatásának idjével
     * @return visszatér a hatás idejével
     */
    @Override
    public long getTimePara() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Paralyzed.getTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return time;
    }
}
