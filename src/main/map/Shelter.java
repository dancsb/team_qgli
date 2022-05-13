package main.map;

import View.View;
import main.items.collectibles.*;
import main.virologist.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * A shelter specialis mezot reprezentalja
 */

public class Shelter extends Field {

    /**
     * A  felszereles, amely az ovohelyen talalhato meg
     */
    private Equipment eq;

    /**
     * Shelter kosntruktora, letrehozasa benne egy megszerezheto felszerelessel
     * @param eq az a felszereles amely a shleterben talalhato meg
     */
    private static ArrayList<Equipment>allEquipments=new ArrayList<>(){{add(new Axe());
                                                                        add(new Cape(82.3));
                                                                        add(new Bag(50));
                                                                        add(new Gloves());}};

    public Shelter(Equipment eq) {
        this.eq = eq;
    }
    public Shelter(){
        this.eq=allEquipments.get(new Random().nextInt(4));
    }
    /**
     * Ha egy virologus arra a mezore szeretne lepni, eldontheti, hogy lephet e oda vagy sem
     * Ha arra a mezore lep akkor elvegzi az eroforrasok begyujteset
     * @param v az a virologus amelynek a belepeset az adott mezore elfodaja
     * @return ha lephet arra a mezore akkor igaz ertekkel ter vissza, kulonben hamissal
     */
    @Override
    public boolean accept(Virologist v) {
        if (super.accept(v)){
            //felszereles begyujtese
            v.pickUpEquipment(eq);
            return true;
        }
        return false;
    }

    @Override
    public Equipment getEquipment() {
        return this.eq;
    }

    /**
     * A shelter adatait kiiro fuggveny
     */
    @Override
    public void printStat(HashMap<String, Virologist> hashMap, ArrayList<Field> allFields) {
        System.out.println("tipus: shelter");
        printStandard(hashMap, allFields);
        System.out.print("equipment: ");
        eq.printStat();
        System.out.println();
        System.out.println();
    }

    @Override
    public void mustDraw(View v,int idx) {
        v.drawShelter(idx);
        for(Virologist viro:virologists){
            viro.mustDraw(v,idx);
        }
    }
}
