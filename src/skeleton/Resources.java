package skeleton;

public class Resources implements Collectible{
    protected long amount;
    protected long maxCapacity;
    @Override
    public void collect(Virologist v) {

    }
    public void changeAmountAminoAcid(long x){}
    public void changeAmountNucleotide(long x){}
    public void changeMaxAmount(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Resources.changeMaxAmount()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
