package main.virologist;

import main.*;
import main.map.Field;
import main.items.collectibles.*;
import main.items.agents.*;
import skeleton.SkeletonWriter;

import java.util.ArrayList;


/**
 * Egy virologust reprezentalo osztaly
 */
public class Virologist implements Steppable {


    /**
     * A kesztyu altal nyujtott hatas beallitasa
     */
    private boolean parry;

    /**
     * A varazslo ezen a mezon tartozkodik
     */
    private Field f;
    /**
     * A birokaban levo agensek listaja
     */
    private ArrayList<Agent> agents;
    /**
     * A birokaban levo eroforrasok listaja
     */
    private ArrayList<Resources>resources;
    /**
     * A megtanult levo genetikai kodok listaja
     */
    private ArrayList<GeneticCode>geneticCodes;
    /**
     * A virologus tulajdonsagainak listaja
     */
    private ArrayList<Attribute>attributes;
    /**
     * A birokaban levo felszerelesek listaja
     */
    private ArrayList<Equipment>equipments;

    /**
     * A virologus konstruktora, letrehoztuk tesztelesi szempontok miatt
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
     * A virologus mozgasat vegzo fuggveny
     * @param f a mezo amire a virologus lepni szeretne
     */
    public void move(Field f){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.move()");
        //lekeri a szomszedos mezoket
        ArrayList<Field> neighbours = this.f.getNeighbours();
        for(Field fNeighbours : neighbours)
        {
            if(fNeighbours == f){
                //atlepes egy masik mezore es torles az elozo mezorol
                f.accept(this); this.f.remove(this);
            }
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Azt ellenorzi, hogy egy virologus megtanulta-e mar az osszes genetikai kodot, ha igen akkor a jateknak vege van
     */
    public boolean checkWin(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.checkWin()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        //az osszes genetikai kod tudasanak eseteben igaz ertekkel ter vissza
        return geneticCodes.size() == 4;
    }

    /**
     * Az eroforrasok ellopasa egy masik virlogustol
     * @param v a virologus akitol ellopja az eroforrasokat
     * @param r az eroforras amit el szeretne lopni
     */
    public void stealResources(Virologist v,Resources r){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.stealResources()");
        //lekerdezi az ugyanazon a mezon levo virologusokat, azok kozul lophat eroforrasokat
        ArrayList<Virologist>virologists=f.getVirologists();
        for (Virologist viro:virologists) {
            if(viro==v){
                //a kivalasztott virologustol ellopja a megadott eroforrasokat
                //target virologustol valo elvetel
                v.loseResources(r);
                //sajat inventoryba felveszi a lopott eroforrasokat
                this.pickUpResource(r);
            }
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * A felszerelesek ellopasa egy masik virlogustol
     * @param v a virologus akitol ellopja az eroforrasokat
     * @param e a felszereles amit el szeretne lopni
     */
    public void stealEquipment(Virologist v,Equipment e){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.stealEquipment()");
        //lekerdezi az ugyanazon a mezon levo virologusokat, azok kozul lophat felszerelest
        ArrayList<Virologist> av = f.getVirologists();
        for (Virologist viro:av)
            if(viro == v) {
                //a kivalasztott virologustol ellopja a megadott felszerelest
                //target virologustol valo elvetel
                v.loseEquipment(e);
                //sajat inventoryba felveszi a lopott felszerelest
                this.pickUpEquipment(e);
            }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * A felszerelesek ellopasa egy masik virlogustol
     * @param target a virologus akitol ellopja az eroforrasokat
     * @param a az agens amit hasznalni szeretne
     */
     public void useAgent(Virologist target, Agent a){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.useAgent()");
        //lekerdezi az ugyanazon a mezon levo virologusokat, azokra tamadhat
        ArrayList<Virologist> av = f.getVirologists();
        for (Virologist viro:av)
            if(viro == target) {
                //a kivalasztott virologuson az agens hasznalata
                a.useOn(target);
            }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * A leptetes
     */
    public void step(){
        System.out.println("Virologist.step()");
    }

    /**
     * Agensek kraftolasa
     * @param a az agens amit kraftolni szeretne
     * @return igaz ertekkel ter vissza, ha az agenst sikeresen lekraftolta, kulonben hamis ertekkel
     */
    public boolean craftAgent(Agent a){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.craftAgent()");
        a.getCrafted(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    /**
     * Felszereles felvetele
     * @param e a felszereles amelyet fel szertne venni
     * @return igaz ertekkel ter vissza, ha a felszerelest sikeresen felvette, kulonben hamis ertekkel
     */
    public boolean pickUpEquipment(Equipment e){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.pickUpEquipment()");
        //meghivja az adott felszereles collect fuggvenyet
        e.collect(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    /**
     * Eroforrasok felvetele
     * @param r az eroforras amelyet fel szertne venni
     * @return igaz ertekkel ter vissza, ha az adott eroforrast sikeresen felvette, kulonben hamis ertekkel
     */
    public boolean pickUpResource(Resources r){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.pickUpResource()");
        //meghivja az adott eroforras collect fuggvenyet
        r.collect(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    /**
     * Felszereles elvesztese
     * @param e a felszereles amelyet elvesztett
     */
    public void loseEquipment(Equipment e){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.loseEquipment()");
        //meghivja az adott felszereles remove fuggvenyet, mely a  felszereles hatasast is elveszi
        e.remove(this);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Eroforrasok elvesztese
     * @param r a felszereles amelyet elvesztett
     */
    public void loseResources(Resources r){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.loseResources()");
        //meghivja az aminosav es nukleotid mennyiseg valtoztato fuggvenyet
        r.changeAmountAminoAcid(-r.getAmount());
        r.changeAmountNucleotide(-r.getAmount());
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Visszater egy attributummokkal teli listaval, melyek az adott varazslon vannak
     @return visszater egy attributumokkal teli listaval
     */
    public ArrayList<Attribute> getAttributes() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getAttributes()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return attributes;
    }

    /**
     * Egy genetikai kod hozzaadasa a megtanult kodokhoz
     * @param g a felszereles amelyet elvesztett
     * @return igaz ertekkel ter vissza ,ha a gentetikai kodot sikeresen megtanulta
     */
    public boolean addGeneticCode(GeneticCode g){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.addGeneticCode()");
        //ha minden genetikai kodot megtanult akkor a jateknak vege van
        if(checkWin())Game.endGame();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return true;
    }

    /**
     * Visszater egy eroforrasokkal teli listaval, melyek az adott varazslo birtokaban vannak
     * @return visszater az eroforrasokkal teli listaval melyek egy virologusnal vannak
     */
    public ArrayList<Resources> getResources() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getResources()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return resources;
    }

    /**
     * Beallitja az agens visszakeno kepesseget, igazra ha a kesztyu a varazslonal van
     * Hamisra ha elvesztette azt
     * @param b igaz vagy hamis erteke lehet, attol fugg a varazslonal van e a kesztyu
     */
    public void setParry(boolean b){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.setParry()");
        parry=b;
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Visszater egy genetikai kodokkal teli listaval, melyeket az adott varazslo megtanult
     * @return visszater a genetikai kodok teli listaval melyeket egy virologus megtanult
     */
    public ArrayList<GeneticCode> getGenCode() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getGenCode()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return geneticCodes;
    }

    /**
     * Visszater a mezovel amin a varazslo tartozkodik
     * @return visszater a mezokkel
     */
    public Field getField() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Virologist.getF()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return f;
    }
}
