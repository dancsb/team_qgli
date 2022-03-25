package skeleton;

public abstract class Resources implements Collectible{
    protected long amount;
    protected long maxCapacity;

    @Override
    public abstract void collect(Virologist v);

    public void changeAmountAminoAcid(long x){}
    public void changeAmountNucleotide(long x){}
    public void setMaxAmount(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Resources.changeMaxAmount()");
        maxCapacity = x;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
