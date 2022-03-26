package skeleton;

import java.util.ArrayList;


/**
 * Egy virológust reprezentáló osztály
 */
public class Virologist implements Steppable {


    /**
     * A kesztyű által nyújtott hatás beállítása
     */
    private boolean parry;

    /**
     * A varázsló ezen a mezőn tartózkodik
     */
    private Field f;
    /**
     * A birokában levő ágensek listája
     */
    private ArrayList<Agent> agents;
    /**
     * A birokában levő erőforrások listája
     */
    private ArrayList<Resources>resources;
    /**
     * A megtanult levő genetikai kódok listája
     */
    private ArrayList<GeneticCode>geneticCodes;
    /**
     * A virológus tulajdonságainak listája
     */
    private ArrayList<Attribute>attributes;
    /**
     * A birokában levő felszerelések listája
     */
    private ArrayList<Equipment>equipments;

    /**
     * A virologus konstruktora, letrehoztuk tesztelési szempontok miatt
     */
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

    /**
     * A virológus mozgását végző függvény
     * @param f a mező amire a virológus lépni szeretne
     */
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

    /**
     * Azt ellenórzi, hogy egy virológus megtanulta-e már az osszes genetikai kódot, ha igen akkor a játéknak vége van
     */
    public boolean checkWin(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.checkWin()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        //az összes genetikai kód tudásának esetében igaz értékkel tér vissza
        return geneticCodes.size() == 4;
    }

    /**
     * Az erőforrások ellopása egy másik virlógustól
     * @param v a virológus akitől ellopja az erőforrásokat
     * @param r az erőforrás amit el szeretne lopni
     */
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

    /**
     * A felszerelések ellopása egy másik virlógustól
     * @param v a virológus akitől ellopja az erőforrásokat
     * @param e a felszerelés amit el szeretne lopni
     */
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

    /**
     * A felszerelések ellopása egy másik virlógustól
     * @param target a virológus akitől ellopja az erőforrásokat
     * @param a az ágens amit használni szeretne
     */
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

    /**
     * A léptetés
     */
    public void step(){
        System.out.println("Virologist.step()");
    }

    /**
     * Ágensek kraftolása
     * @param a az ágens amit kraftolni szeretne
     * @return igaz értékkel tér vissza, ha az ágenst sikeresen lekraftolta, különben hamis értékkel
     */
    public boolean craftAgent(Agent a){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.craftAgent()");
        a.getCrafted(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    /**
     * Felszerelés felvétele
     * @param e a felszerelés amelyet fel szertne venni
     * @return igaz értékkel tér vissza, ha a felszerelést sikeresen felvette, különben hamis értékkel
     */
    public boolean pickUpEquipment(Equipment e){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.pickUpEquipment()");
        //meghívja az adott felszerelés collect függvényét
        e.collect(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    /**
     * Erőforrások felvétele
     * @param r az erőforrás amelyet fel szertne venni
     * @return igaz értékkel tér vissza, ha az adott erőforrást sikeresen felvette, különben hamis értékkel
     */
    public boolean pickUpResource(Resources r){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.pickUpResource()");
        //meghívja az adott erőforrás collect függvényét
        r.collect(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    /**
     * Felszerelés elvesztése
     * @param e a felszerelés amelyet elvesztett
     */
    public void loseEquipment(Equipment e){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.loseEquipment()");
        //meghívja az adott felszerelés remove függvényét, mely a  felszerelés hatásást is elveszi
        e.remove(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Erőforrások elvesztése
     * @param r a felszerelés amelyet elvesztett
     */
    public void loseResources(Resources r){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.loseResources()");
        //meghívja az aminosav es nukleotid mennyiség változtató függvényét
        r.changeAmountAminoAcid(-r.amount);
        r.changeAmountNucleotide(-r.amount);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Visszatér egy attributummokkal teli listával, melyek az adott varázslón vannak
     @return visszatér egy attributumokkal teli listával
     */
    public ArrayList<Attribute> getAttributes() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getAttributes()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return attributes;
    }

    /**
     * Egy genetikai kód hozzáadása a megtanult kódokhoz
     * @param g a felszerelés amelyet elvesztett
     * @return igaz értékkel tér vissza ,ha a gentetikai kódot sikeresen megtanulta
     */
    public boolean addGeneticCode(GeneticCode g){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.addGeneticCode()");
        //ha minden genetikai kódot megtanult akkor a játéknak vége van
        if(checkWin())Game.endGame();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    /**
     * Visszatér egy erőforrásokkal teli listával, melyek az adott varázsló birtokában vannak
     * @return visszatér az erőforrásokkal teli listával melyek egy virológusnál vannak
     */
    public ArrayList<Resources> getResources() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getResources()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return resources;
    }

    /**
     * Beállítja az ágens visszakenő képességet, igazra ha a kesztyű a varázslónál van
     * Hamisra ha elvesztette azt
     * @param b igaz vagy hamis értéke lehet, attól függ a varázslónál van e a kesztyű
     */
    public void setParry(boolean b){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.setParry()");
        parry=b;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Visszatér egy genetikai kódokkal teli listával, melyeket az adott varázsló megtanult
     * @return visszatér a genetikai kódok teli listával melyeket egy virológus megtanult
     */
    public ArrayList<GeneticCode> getGenCode() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getGenCode()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return geneticCodes;
    }

    /**
     * Visszatér a mezővel amin a varázsló tartózkodik
     * @return visszatér a mezőkkel
     */
    public Field getField() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getF()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return f;
    }
}
