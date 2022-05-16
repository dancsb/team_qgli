package main.map;

import java.util.ArrayList;
import java.util.HashMap;

import View.View;
import main.items.collectibles.*;
import main.virologist.*;

public class Storage extends Field {

    /**
     * A raktarban elhelyezett nyersanyag
     */
    private ArrayList<Resource> res;

    /**
     * Storage kosntruktora, storage letrehozasa benne egy megtanulhato eroforrasokkal
     * @param r1 a storage mezon megtalalhato aminosavak
     * @param r2 a storage mezon megtalalhato nukleotidok
     */
    public Storage (Resource r1, Resource r2){
        res = new ArrayList<>();
        res.add(r1);
        res.add(r2);
    }
    public Storage(){
        res=new ArrayList<>();
        res.add(new AminoAcid(100,100));
        res.add(new Nucleotide(100,100));
    }
    /**
     * Ha egy virologus arra a mezore szeretne lepni,ez a fuggveny eldontheti, hogy lephet e oda vagy sem
     * Illetve az adott mezon levo targyak begyujteset vegzi el
     * @param v az adott storage mezore lepni kivano virologus
     * @return igaz ertekkel ter vissza ha a virologust beengedte az adott mezore, hamis ertekkel ha oda nem lephet a virologus
     */
    @Override
    public boolean accept(Virologist v) {
        if (super.accept(v)){
            for (Resource r: res){
                //eroforrasok begyujtese
                if (v.isBearDance()){
                    destroy();
                }
                else r.collect(v);
            }
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Resource> getResources() {
        return this.res;
    }

    /**
     * A raktarban levo nyersanyagokat pusztitja el
     */
    private void destroy(){
        for (Resource r:
             res) {
            r.changeAmountAminoAcid(0);
            r.changeAmountNucleotide(0);
        }
    }

    /**
     * A raktar adatait kiiro fuggveny
     */
    @Override
    public void printStat(HashMap<String, Virologist> hashMap, ArrayList<Field> allFields) {
        System.out.println("tipus: storage");
        printStandard(hashMap, allFields);
        System.out.println("resources: " + res.get(0).getAmount() + " " + res.get(1).getAmount());
    }
    /**
     * kirajzoltat egy storaget
     * @param v a View amire ki kell rajzolni
     * @param idx a field indexe ami = a polygon indexével így tudja hova kell rajzolni
     */
    @Override
    public void mustDraw(View v,int idx) {
        v.drawStorage();
        for(Virologist viro:virologists){
            viro.mustDraw(v,idx);
        }
    }
}
