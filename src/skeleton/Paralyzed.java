package skeleton;

public class Paralyzed extends Attribute{

    //beállítja a bénaság hatásának idjét
    @Override
    public void setTimePara(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Paralyzed.setTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //visszatér a bénaság hatásának idjével
    @Override
    public long getTimePara() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Paralyzed.getTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return time;
    }
}
