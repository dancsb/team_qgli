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
        resources.add(new AminoAcid());
        resources.add(new AminoAcid());
    }

    public void move(Field f){
        System.out.println("Virologist.move()");
        ArrayList<Field> neighbours = f.getNeighbours();
        if(checkWin() == true)Game.endGame();
        for(Field fNeighbours : neighbours)
        {
            if(fNeighbours == f){
                f.accept(this); f.remove(this);
            }
        }

     }
    public boolean checkWin(){
        System.out.println("Virologist.checkWin()");
        if(geneticCodes.size() == 4) return true;
        else return false;
    }
    public void stealResources(Virologist v,Resources r){
        System.out.println("Virologist.stealResources()");
    }
    public void stealEquipment(Virologist v,Equipment e){
        System.out.println("Virologist.stealEquipment()");
    }
    public void useAgent(Agent a,Virologist target){
        System.out.println("Virologist.useAgent()");
    }
    public void step(){
        System.out.println("Virologist.step()");
    }
    public boolean craftAgent(Agent a){
        System.out.println("Virologist.craftAgent()");
        return true;
    }
    public boolean pickUpEquipment(Equipment e){
        System.out.println("Virologist.pickUpEquipment()");
        return true;
    }
    public boolean pickUpResource(Resources r){
        System.out.println("Virologist.pickUpResources()");

        return true;
    }
    public void loseEquipment(Equipment e){
        System.out.println("Virologist.loseEquipment()");
    }
    public void loseResources(Resources r){
        System.out.println("Virologist.loseResources()");
    }
    public ArrayList<Attribute> getAttributes() {
        System.out.println("Virologist.getAttributes()");
        return attributes;
    }
    public boolean addGeneticCode(GeneticCode g){
        System.out.println("Virologist.addGeneticCode()");

        return true;
    }

    public ArrayList<Resources> getResources() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.getResources()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return resources;
    }
    public void setParry(boolean b){
        System.out.println("Virologist.setParry()");
        parry=b;
    }

    public ArrayList<GeneticCode> getGenCode() {
        System.out.println("Virologist.getGenCode()");
        return geneticCodes;
    }
}
