package skeleton;

public class Lab extends Field{
    private GeneticCode gc;

    public Lab(GeneticCode gc) {
        this.gc = gc;
    }

    public GeneticCode getGc() {
        System.out.println("Lab.getGc()");
        return gc;
    }

    @Override
    public boolean accept(Virologist v) {
        System.out.println("Lab.accept()");
        return super.accept(v);
    }
}
