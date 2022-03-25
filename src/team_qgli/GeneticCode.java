package team_qgli;

public class GeneticCode implements Collectible{
    private String name;

    public GeneticCode(String name){
        this.name = name;
    }

    public String getName() {
        System.out.println("GeneticCode.getName()");
        return name;
    }

    @Override
    public void collect(Virologist v) {
        System.out.println("GeneticCode.collect()");
    }
}
