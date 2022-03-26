package skeleton;

import java.util.ArrayList;

public class Virologist implements Steppable {

    private boolean parry;
    //varázsló ezen a mezőn tartózkodik
    private Field f;
    //birokában levő ágensek listája
    private ArrayList<Agent> agents;
    //birokában levő erőforrások listája
    private ArrayList<Resources>resources;
    //birokában levő genetikai kódok listája
    private ArrayList<GeneticCode>geneticCodes;
    //tulajdonságok listája
    private ArrayList<Attribute>attributes;
    //birokában levő felszerelések listája
    private ArrayList<Equipment>equipments;

    //virologus konstruktora, letrehoztuk tesztelési szempontok miatt
    public Virologist() {
        resources = new ArrayList<>(2);
        attributes = new ArrayList<>();
        resources.add(new AminoAcid());
        resources.add(new Nucleotide());
        attributes.add(new Dancing());
        attributes.add(new Paralyzed());
        attributes.add(new Invulnerabled());
        geneticCodes=new ArrayList<>();
        geneticCodes.add(new GeneticCode("test"));
        f=new Field();
    }

    //virológus mozgását végző függvény
    public void move(Field f){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.move()");
        //lekéri a szomszédos mezőket
        ArrayList<Field> neighbours = this.f.getNeighbours();
        for(Field fNeighbours : neighbours)
        {
            if(fNeighbours == f){
                //átlépés egy másik mezőre és törlés az előző mezőről
                f.accept(this); this.f.remove(this);
            }
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
     }

     //ellenórzi, hogy egy virológus megtanulta-e már az osszes genetikai kódot, ha igen akkor a játéknak vége van
    public boolean checkWin(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.checkWin()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        //az összes genetikai kód tudásának esetében igaz értékkel tér vissza
        return geneticCodes.size() == 4;
    }

    //erőforrások ellopása egy másik virlógustól
    public void stealResources(Virologist v,Resources r){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.stealResources()");
        //lekérdezi az ugyanazon a mezón lévő virológusokat, azok közül lophat erőforrásokat
        ArrayList<Virologist>virologists=f.getVirologists();
        for (Virologist viro:virologists) {
            if(viro==v){
                //a kiválasztott virológustól ellopja a megadott erőforrásokat
                //target virológustól való elvétel
                v.loseResources(r);
                //saját inventoryba felveszi a lopott erőforrásokat
                this.pickUpResource(r);
            }
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //felszerelések ellopása egy másik virlógustól
    public void stealEquipment(Virologist v,Equipment e){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.stealEquipment()");
        //lekérdezi az ugyanazon a mezón lévő virológusokat, azok közül lophat felszerelést
        ArrayList<Virologist> av = f.getVirologists();
        for (Virologist viro:av)
            if(viro == v) {
                //a kiválasztott virológustól ellopja a megadott felszerelést
                //target virológustól való elvétel
                v.loseEquipment(e);
                //saját inventoryba felveszi a lopott felszerelést
                this.pickUpEquipment(e);
            }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //ágensek használata egy másik virológuson
    public void useAgent(Virologist target, Agent a){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.useAgent()");
        //lekérdezi az ugyanazon a mezón lévő virológusokat, azokra támadhat
        ArrayList<Virologist> av = f.getVirologists();
        for (Virologist viro:av)
            if(viro == target) {
                //a kiválasztott virológuson az ágens használata
                a.useOn(target);
            }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //léptetés
    public void step(){
        System.out.println("Virologist.step()");
    }

    //ágensek kraftolása
    public boolean craftAgent(Agent a){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.craftAgent()");
        a.getCrafted(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    //felszerelés felvétele
    public boolean pickUpEquipment(Equipment e){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.pickUpEquipment()");
        //meghívja az adott felszerelés collect függvényét
        e.collect(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    //erőforrások felvétele
    public boolean pickUpResource(Resources r){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.pickUpResource()");
        //meghívja az adott erőforrás collect függvényét
        r.collect(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    //felszerelés elvesztése
    public void loseEquipment(Equipment e){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.loseEquipment()");
        //meghívja az adott felszerelés remove függvényét, mely a  felszerelés hatásást is elveszi
        e.remove(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //erőforrások elvesztése
    public void loseResources(Resources r){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.loseResources()");
        //meghívja az aminosav es nukleotid mennyiség változtató függvényét
        r.changeAmountAminoAcid(-r.amount);
        r.changeAmountNucleotide(-r.amount);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //visszatér egy attributummokkal teli listával, melyek az adott varázslón vannak
    public ArrayList<Attribute> getAttributes() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getAttributes()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return attributes;
    }

    //egy genetikai kód hozzáadása a megtanult kódokhoz
    public boolean addGeneticCode(GeneticCode g){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.addGeneticCode()");
        //ha minden genetikai kódot megtanult akkor a játéknak vége van
        if(checkWin())Game.endGame();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    //visszatér egy erőforrásokkal teli listával, melyek az adott varázsló birtokában vannak
    public ArrayList<Resources> getResources() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getResources()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return resources;
    }

    //beállítja az ágens visszakenő képességet, igazra ha a kesztyű a varázslónál van
    //hamisra ha elvesztette azt
    public void setParry(boolean b){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.setParry()");
        parry=b;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //visszatér egy genetikai kódokkal teli listával, melyeket az adott varázsló megtanult
    public ArrayList<GeneticCode> getGenCode() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getGenCode()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return geneticCodes;
    }

    //visszatér a mezővel amin a varázsló tartózkodik
    public Field getField() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getF()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return f;
    }
}
