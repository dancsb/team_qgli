package main.virologist;

import main.*;
import main.map.Field;
import main.items.collectibles.*;
import main.items.agents.*;

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
     * Megmondja medvevirusos-e a virologus
     */
    private boolean bearDance;

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
    private ArrayList<Resource>resources;
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
        //resources.add(new AminoAcid());
        //resources.add(new Nucleotide());
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
        //lekeri a szomszedos mezoket
        ArrayList<Field> neighbours = f.getNeighbours();
        if(neighbours.contains(f)){
            //atlepes egy masik mezore es torles az elozo mezorol
            f.accept(this);
            f.remove(this);
            ArrayList<Virologist> virologists = f.getVirologists();
            if (bearDance){
                for (Virologist v:
                     virologists) {
                    ArrayList<Equipment> equips = v.getEquipments();
                    for (Equipment e:
                         equips) {
                        if (!e.getUsed()){
                            die();
                        }
                    }
                    v.setBearDance(bearDance);
                }
            }else{
                for (Virologist v:
                     virologists) {
                    setBearDance(v.isBearDance());
                }
            }
        }
    }

    /**
     * Azt ellenorzi, hogy egy virologus megtanulta-e mar az osszes genetikai kodot, ha igen akkor a jateknak vege van
     */
    public boolean checkWin(){
        //az osszes genetikai kod tudasanak eseteben igaz ertekkel ter vissza
        return geneticCodes.size() == 4;
    }

    /**
     * Az eroforrasok ellopasa egy masik virlogustol
     * @param v a virologus akitol ellopja az eroforrasokat
     * @param r az eroforras amit el szeretne lopni
     */
    public void stealResources(Virologist v, Resource r){
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
    }

    /**
     * A felszerelesek ellopasa egy masik virlogustol
     * @param v a virologus akitol ellopja az eroforrasokat
     * @param e a felszereles amit el szeretne lopni
     */
    public void stealEquipment(Virologist v,Equipment e){
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
    }

    /**
     * A felszerelesek ellopasa egy masik virlogustol
     * @param target a virologus akitol ellopja az eroforrasokat
     * @param a az agens amit hasznalni szeretne
     */
     public void useAgent(Virologist target, Agent a){
        //lekerdezi az ugyanazon a mezon levo virologusokat, azokra tamadhat
        ArrayList<Virologist> av = f.getVirologists();
        for (Virologist viro:av)
            if(viro == target) {
                //a kivalasztott virologuson az agens hasznalata
                a.useOn(target);
            }
    }

    /**
     * A leptetes
     */
    public void step(){
    }

    /**
     * Agensek kraftolasa
     *
     * @param a az agens amit kraftolni szeretne
     */
    public void craftAgent(Agent a){
        a.getCrafted(this);
    }

    /**
     * Felszereles felvetele
     *
     * @param e a felszereles amelyet fel szertne venni
     */
    public void pickUpEquipment(Equipment e){
        //meghivja az adott felszereles collect fuggvenyet
        e.collect(this);
    }

    /**
     * Eroforrasok felvetele
     *
     * @param r az eroforras amelyet fel szertne venni
     */
    public void pickUpResource(Resource r){
        //meghivja az adott eroforras collect fuggvenyet
        r.collect(this);
    }

    /**
     * Felszereles elvesztese
     * @param e a felszereles amelyet elvesztett
     */
    public void loseEquipment(Equipment e){
        //meghivja az adott felszereles remove fuggvenyet, mely a  felszereles hatasast is elveszi
        e.remove(this);
    }

    /**
     * Eroforrasok elvesztese
     * @param r a felszereles amelyet elvesztett
     */
    public void loseResources(Resource r){
        //meghivja az aminosav es nukleotid mennyiseg valtoztato fuggvenyet
        r.changeAmountAminoAcid(-r.getAmount());
        r.changeAmountNucleotide(-r.getAmount());
    }

    /**
     * Visszater egy attributummokkal teli listaval, melyek az adott varazslon vannak
     @return visszater egy attributumokkal teli listaval
     */
    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Egy genetikai kod hozzaadasa a megtanult kodokhoz
     *
     * @param g a felszereles amelyet elvesztett
     */
    public void addGeneticCode(GeneticCode g){
        if(geneticCodes.contains(g))return;
        else geneticCodes.add(g);
        //ha minden genetikai kodot megtanult akkor a jateknak vege van
        if(checkWin())Game.endGame();
    }

    /**
     * Visszater egy eroforrasokkal teli listaval, melyek az adott varazslo birtokaban vannak
     * @return visszater az eroforrasokkal teli listaval melyek egy virologusnal vannak
     */
    public ArrayList<Resource> getResources() {
        return resources;
    }

    /**
     * Beallitja az agens visszakeno kepesseget, igazra ha a kesztyu a varazslonal van
     * Hamisra ha elvesztette azt
     * @param b igaz vagy hamis erteke lehet, attol fugg a varazslonal van e a kesztyu
     */
    public void setParry(boolean b){
        parry=b;
    }

    /**
     * Visszater egy genetikai kodokkal teli listaval, melyeket az adott varazslo megtanult
     * @return visszater a genetikai kodok teli listaval melyeket egy virologus megtanult
     */
    public ArrayList<GeneticCode> getGenCode() {
        return geneticCodes;
    }

    /**
     * Visszater a mezovel amin a varazslo tartozkodik
     * @return visszater a mezokkel
     */
    public Field getField() {
        return f;
    }

    /**
     * Visszatér az equipmentek tömbjével
     * @return a virológus equipmentjeinek tömbje
     */
    public ArrayList<Equipment> getEquipments() {
        return equipments;
    }

    /**
     * Megadja a virologus agenseit
     * @return az agensek listaja
     */
    public ArrayList<Agent> getAgents() {
        return agents;
    }

    /**
     * Beallitja a virologus helyet
     * @param f erre a mezore allitja be a helyet
     */
    public void setField(Field f) {
        this.f = f;
    }

    /**
     * megmondja a virologus kivedi-e az agenst
     * @return a parry erteke
     */
    public boolean isParry() {
        return parry;
    }

    /**
     * Megmondja medvevirusos-e a medve
     * @return a bearDance erteke
     */
    public boolean isBearDance() {
        return bearDance;
    }

    /**
     * Beallitja a viologus bearDance-t a kapott ertekre
     * @param bearDance erre allitja be az erteket
     */
    public void setBearDance(boolean bearDance) {
        if(!bearDance) {
            this.bearDance = bearDance;
        }
    }

    /**
     * A virologus meghal(lekerul a mezorol es nullra allitodik a helye)
     */
    public void die(){
        f.remove(this);
        f=null;
        bearDance=false;
    }

    /**
     * A virologus adatait irja ki
     * @param name megkapja a sajat nevet
     */
    public void printStat(String name) {
        System.out.println("virologusNev: " + name);
        System.out.println("sajatfield: " + f);
        for (Attribute a: attributes)
            a.printStat();
        System.out.println("medvetancol: " + bearDance);
        System.out.print("genetikaiKodjanakListaja: ");
        if (geneticCodes.size() == 0)
            System.out.println("null");
        else
            for (GeneticCode g: geneticCodes)
                g.printStat();
        System.out.println();
        System.out.print("agenseinekListaja: ");
        if (agents.size() == 0)
            System.out.println("null");
        else
            for (Agent a: agents)
                a.printStat();
        System.out.println();
        System.out.print("resourceErtek: ");
        for (Resource r: resources)
            r.printStat();
        System.out.println();
        System.out.print("equipmentek: ");
        if (equipments.size() == 0)
            System.out.println("null");
        else
            for (Equipment e: equipments)
                e.printStat();
        System.out.println();
        System.out.println();
    }
}
