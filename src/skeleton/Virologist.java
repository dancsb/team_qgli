package skeleton;

import java.util.ArrayList;

public class Virologist implements Steppable {
    private boolean parry;
    private Field f;
    private ArrayList<Agent> agents;
    private ArrayList<Resources>resources;
    private ArrayList<GeneticCode>geneticCodes;
    private ArrayList<Attribute>attributes;
    private ArrayList<Equipment>equipments;

    //csak tesztelésre hoztam létre, puszi: balázs
    public Virologist() {
        resources = new ArrayList<>(2);
        attributes = new ArrayList<>();
        resources.add(new AminoAcid());
        resources.add(new AminoAcid());
        attributes.add(new Dancing());
        attributes.add(new Paralyzed());
        attributes.add(new Invulnerabled());
        geneticCodes=new ArrayList<>();
        geneticCodes.add(new GeneticCode("test"));
    }

    public void move(Field f){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.move()");
        ArrayList<Field> neighbours = f.getNeighbours();
        for(Field fNeighbours : neighbours)
        {
            if(fNeighbours == f){
                f.accept(this); f.remove(this);
            }
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
     }

    public boolean checkWin(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.checkWin()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return geneticCodes.size() == 4;
    }
    public void stealResources(Virologist v,Resources r){
        System.out.println("Virologist.stealResources()");
    }
    public void stealEquipment(Virologist v,Equipment e){
        System.out.println("Virologist.stealEquipment()");
    }
    public void useAgent(Agent a,Virologist target){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.useAgent()");
        a.useOn(target);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    public void step(){
        System.out.println("Virologist.step()");
    }
    public boolean craftAgent(Agent a){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.craftAgent()");
        a.getCrafted(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }
    public boolean pickUpEquipment(Equipment e){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.pickUpEquipment()");
        e.collect(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }
    public boolean pickUpResource(Resources r){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.pickUpResource()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }
    public void loseEquipment(Equipment e){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.loseEquipment()");
        e.remove(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    public void loseResources(Resources r){
        System.out.println("Virologist.loseResources()");
    }
    public ArrayList<Attribute> getAttributes() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.getAttributes()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return attributes;
    }
    public boolean addGeneticCode(GeneticCode g){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.addGeneticCode()");
        if(checkWin())Game.endGame();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    public ArrayList<Resources> getResources() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.getResources()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return resources;
    }
    public void setParry(boolean b){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.setParry()");
        parry=b;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    public ArrayList<GeneticCode> getGenCode() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.getGenCode()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return geneticCodes;
    }
}
