package team_qgli;

public class Lab extends Field{
    private GeneticCode gc;

    public Lab(GeneticCode gc) {
        System.out.println("Lab.constructor()");
        this.gc = gc;
    }

    public GeneticCode getGc() {
        System.out.println("Lab.getGc()");
        return gc;
    }

    @Override
    public boolean accept(Virologist v) {
        System.out.println("Lab.accept()");
         if (super.accept(v)){
             gc.collect(v);
             return true;
         }
         return false;
    }
}
