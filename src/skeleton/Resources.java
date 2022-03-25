package skeleton;

public abstract class Resources implements Collectible{
    protected long amount;
    protected long maxCapacity;

    @Override
    public abstract void collect(Virologist v);

    public void changeAmountAminoAcid(long x){}
    public void changeAmountNucleotide(long x){}
    public void changeMaxAmount(long x){
        System.out.println("Resources.changeMaxAmount()");
        maxCapacity = x;
    }
}
