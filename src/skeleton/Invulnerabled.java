package skeleton;

public class Invulnerabled extends Attribute{

    //védekezési előny mértéke
    private long defPrec;

    //beállítja a sebezhetetlenség hatásának idjét
    @Override
    public void setTimeInvu(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Invulnerabled.setTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //visszatér a sebezhetetlenség hatásának idjével
    @Override
    public long getTimeInvu() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Invulnerabled.getTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return time;
    }

    //megváltoztatja a sebezhetetlenség hatásának mértékét
    @Override
    public void changeDefPerc(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Invulnerabled.changeDefPerc()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
