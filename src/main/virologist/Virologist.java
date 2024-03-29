package main.virologist;

import View.View;
import main.*;
import main.map.Field;
import main.items.collectibles.*;
import main.items.agents.*;

import java.util.ArrayList;
import java.util.Random;


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
    private boolean bearDance=false;

    /**
     * A varazslo ezen a mezon tartozkodik
     */
    private Field field;

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
    private int viroID;

    /**
     * A virologus konstruktora, letrehoztuk tesztelesi szempontok miatt
     */
    public Virologist(Field f,int viroID) {
        resources = new ArrayList<>(2);
        attributes = new ArrayList<>();
        agents=new ArrayList<>();
        equipments=new ArrayList<>();
        resources.add(new AminoAcid(0,500));
        resources.add(new Nucleotide(0,500));
        attributes.add(new Dancing());
        attributes.add(new Paralyzed());
        attributes.add(new Invulnerabled());
        geneticCodes=new ArrayList<>();
        field =f;
        this.viroID=viroID;
    }

    /**
     * A virologus mozgasat vegzo fuggveny
     * @param f a mezo amire a virologus lepni szeretne
     */
    public void move(Field f) throws DieException {
        //lekeri a szomszedos mezoket
        ArrayList<Field> neighbours = this.field.getNeighbours();
        if(neighbours.contains(f)){
            //atlepes egy masik mezore es torles az elozo mezorol
            this.field.remove(this);
            f.accept(this);
            ArrayList<Virologist> virologists = f.getVirologists();
            if (bearDance){
                for (Virologist v:virologists) {
                    if (v!=this) {
                        for (Equipment e : v.getEquipments()) {
                            if (!e.getUsed()) {
                                e.setUsed(true);
                                die();
                                return;
                            }

                        }
                        v.setBearDance(true);
                    }
                }
            }
            else{
                Virologist deadBear=null;
                for (Virologist v:virologists) {
                    if(v.isBearDance()){
                        for(Equipment e:equipments) {
                            if(!e.getUsed()) {
                                e.setUsed(true);
                                deadBear=v;
                            }
                        }
                    }
                    //Ennek a sornak szerintem 0 értelme van, nem tudom, hogy került ide.
                    //Úgy, hogy kell a fertőződés miatt, köszönjük László
                    this.setBearDance(v.isBearDance());
                }
                if(deadBear!=null){
                    deadBear.die();
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
        ArrayList<Virologist>virologists= field.getVirologists();
        for (Virologist viro:virologists) {
            if(viro==v && this.resources.size() < resources.get(0).getMaxCapacity()){
                if(v.getAttributes().get(0).getTimeInvu() > 0) return;
                //a kivalasztott virologustol ellopja a megadott eroforrasokat
                //target virologustol valo elvetel
                //sajat inventoryba felveszi a lopott eroforrasokat
                this.pickUpResource(r);
                v.loseResources(r);
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
        ArrayList<Virologist> av = field.getVirologists();
        for (Virologist viro:av)
            if(viro == v && this.equipments.size() < 3) {
                for(Attribute atr:viro.getAttributes()){
                    if(atr.getTimePara()>0){
                        v.loseEquipment(e);
                        //sajat inventoryba felveszi a lopott felszerelest
                        this.pickUpEquipment(e);
                        return;
                    }
                }
            }
    }

    /**
     * A felszerelesek ellopasa egy masik virlogustol
     * @param target a virologus akitol ellopja az eroforrasokat
     * @param a az agens amit hasznalni szeretne
     */
     public void useAgent(Virologist target, Agent a){
        //lekerdezi az ugyanazon a mezon levo virologusokat, azokra tamadhat
        ArrayList<Virologist> av = field.getVirologists();
        if(target==this){
            this.agents.remove(a);
            if(target.isInvulnerable())return;
            a.useOn(this);
            return;
        }
        for (Virologist viro:av)
            if(viro == target) {
                for(Attribute atr:viro.getAttributes()){
                    if(atr.getTimeInvu()>0){
                        this.agents.remove(a);
                        return;
                    }
                }
                if(viro.parry) {
                    a.useOn(this);
                    this.agents.remove(a);
                    boolean removeTheGloves=false;
                    Equipment gl=null;
                    for(Equipment e:viro.getEquipments()){
                        if(e.getDurability()==1){
                            removeTheGloves=true;
                            gl=e;
                        }
                        else{
                            e.setDurability(e.getDurability()-1);
                        }
                    }
                    if(removeTheGloves) viro.getEquipments().remove(gl);
                    return;
                }
                //a kivalasztott virologuson az agens hasznalata
                a.useOn(target);
                this.agents.remove(a);
            }
    }

    /**
     * A leptetes
     */
    public void step() throws DieException {
        //minden Steppable leptetese
        for (Attribute a :
                attributes) {
            a.step();
        }
        for (Agent a :
                agents) {
            a.step();
        }

        //eldöntjük.hogy tancol-e
        boolean vitus = false;
        for (Attribute a :
                attributes) {
            vitus = a.getTimeDance() > 0;
            if (vitus) {
                break;
            }
        }

        //ha random kell lepnie
        if (bearDance || vitus) {
            Random rnd = new Random();
            ArrayList<Field> neighbours = field.getNeighbours();
            int route = rnd.nextInt(neighbours.size());  //random mezo sorsolasa
            Field target = neighbours.get(route);
            move(target);
        }
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
        boolean owned = false;
        if (equipments.size() < 3) {
            for (Equipment eq:equipments) {
                if(e.getName().equals(eq.getName())){
                    owned = !e.getName().equals("axe") || !e.getUsed();
                }
            }
            if(!owned){
                equipments.add(e);
                e.action(this);
            }
        }
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
        this.equipments.remove(e);
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
        for (GeneticCode genCode: geneticCodes) {
            if (genCode.getName().equals(g.getName())) return;
        }
        geneticCodes.add(g);
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
        return field;
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
        this.field = f;
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
        boolean vedve = false;
        for (Attribute atr:this.getAttributes())
            if(atr.getDefPerc() == 100)
                vedve = true;
        if(!vedve && !isBearDance()) {
            this.bearDance = bearDance;
            if(bearDance) {
                equipments.clear();
                agents.clear();
            }
        }
    }

    /**
     * A virologus meghal(lekerul a mezorol es nullra allitodik a helye)
     */
    public void die() throws DieException {
        field.remove(this);
        ///field =null;
        field=new Field();
        bearDance=false;
        throw new DieException(this);
    }

    /**
     * A virologus adatait irja ki
     * @param name megkapja a sajat nevet
     */
    public void printStat(String name,int fieldIndex) {
        System.out.println("nev: " + name);
        System.out.println("sajatField: " + fieldIndex);
        for (Attribute a: attributes)
            a.printStat();
        System.out.println("medvetancol: " + bearDance);
        System.out.print("genetikaiKodokListaja: ");
        if (geneticCodes.size() == 0)
            System.out.print("null");
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
        //System.out.println();
        System.out.print("resourceErtek: ");
        for (Resource r: resources)
            r.printStat();
        System.out.println();
        System.out.print("equipmentek: ");
        if (equipments.size() == 0)
            System.out.println("null");
        else
            for (int i = 0; i < equipments.size(); i++) {
                equipments.get(i).printStat();
                if(i != equipments.size() - 1)
                    System.out.print(", ");
                else
                    System.out.println();
            }
    }
    public void mustDraw(View v,int fieldIdx) {
        if (!bearDance) {
            v.drawVirologist(viroID, fieldIdx);
        }else{
            v.drawBear(viroID, fieldIdx);
        }
    }

    public int getViroID() {
        return viroID;
    }

    public String toString() {
        String temp ="";

        for (Attribute a: attributes)
            temp += a.toString();

        temp += "genetikaiKodokListaja: ";
        if (geneticCodes.size() == 0)
            temp += "null";
        else
            for (int i = 0; i < geneticCodes.size(); i++) {
                temp += geneticCodes.get(i).toString();
                if(i != geneticCodes.size() - 1)
                    temp += ", ";
            }
        temp += "\n";

        if (agents.size() == 0)
            temp += "agenseinekListaja: null\n";
        else {
            temp += "agenseinekListaja: ";
            for (Agent agent : agents) {
                temp += "\n";
                if (agent.toString() != null) temp += agent.toString();
            }
        }
        temp += "resourceErtek: ";
        for (Resource r: resources)
            temp += r.toString();
        temp += "\n";

        temp += "equipmentek: ";
        if (equipments.size() == 0)
            temp += "null";
        else
            for (int i = 0; i < equipments.size(); i++) {
                temp += equipments.get(i).toString();
                if(i != equipments.size() - 1)
                    temp += ", ";
            }
        return  temp;
    }

    public boolean isParalyzed(){
        for (Attribute a:
             attributes) {
            if (a.getTimePara()>0){
                return true;
            }
        }
        return false;
    }
    public boolean isInvulnerable(){
        for (Attribute a:
                attributes) {
            if (a.getTimeInvu()>0){
                return true;
            }
        }
        return false;
    }
}
