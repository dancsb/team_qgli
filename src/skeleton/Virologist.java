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

    public void move(Field f){}
    public boolean checkWin(){return true;}
    public void stealResources(Virologist v,Resources r){}
    public void stealEquipment(Virologist v,Resources r){}
    public void useAgent(Agent a,Virologist target){}
    public void step(){}
    public boolean craftAgent(Agent a){return true;}
    public boolean pickUpEquipment(Equipment e){return true;}
    public boolean pickUpResource(Resources r){return true;}
    public void loseEquipment(Equipment e){}
    public void looseResources(Resources r){}
    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }
    public boolean addGeneticCode(GeneticCode g){return true;}

    public ArrayList<Resources> getResources() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Virologist.getResources()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return resources;
    }
    public void setParry(boolean b){
        parry=b;
    }

    public ArrayList<GeneticCode> getGenCode() {
        return geneticCodes;
    }
}
