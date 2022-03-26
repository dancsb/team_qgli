package skeleton;
/**
 * Azt a hatást reprezentálja amikor a virológus sebezhetetlen jár.
 */
public class Invulnerabled extends Attribute{
    /**
     * Védekezési előny mértéke
     */
    private long defPrec;

    /**
     * Beállítja a sebezhetetlenség hatásának idjét
     * @param x az idő
     */
    @Override
    public void setTimeInvu(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Invulnerabled.setTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Visszatér a sebezhetetlenség hatásának idejével
     * @return visszatér a sebezhetetlenség hatásának idejé
     */
    @Override
    public long getTimeInvu() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Invulnerabled.getTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return time;
    }

    /**
     * Megváltoztatja a sebezhetetlenség hatásának mértékét
     * @param x az idő
     */
    @Override
    public void changeDefPerc(long x) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Invulnerabled.changeDefPerc()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
