package skeleton;

public abstract class Resources implements Collectible{
    protected long amount;
    protected long maxCapacity;

    @Override
    public abstract void collect(Virologist v);

    public void changeAmountAminoAcid(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    public void changeAmountNucleotide(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeAmountAminoAcid()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    public void setMaxAmount(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Resources.changeMaxAmount()");
        maxCapacity = x;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
