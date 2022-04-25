package main.items.agents;

import main.virologist.Virologist;

/**
 * Vitustancot reprezentalo osztaly
 */
public class Vitusdance extends Agent {

    /**
     * Viutsdance agens konstruktora, melyben parameterul kapja a virologust amely lekraftolta, hatasi idot,
     * Amino es nukleo koltsegeket es a szukseges genetikai kodot
     * @param amino kraftolashoz szukseges aminosavak szama
     * @param genCode kraftolashoz szukseges genetikai kod
     * @param nucleo kraftolashoz szukseges nukleotidok szama
     * @param v a tulajdonos virologus
     */
    public Vitusdance(Virologist v, long amino, long nucleo, String genCode) {
        super(v, amino, nucleo, genCode);
    }

    /**
     * A vitusdance agens hasznalata egy masik virologuson
     * @param v a virologus amelyen az agenst hasznaljuk
     */
    public void useOn(Virologist v) {
        v.getAttributes().forEach(a->a.setTimeDance(expireTime));
    }
    @Override
    public void printStat(){
        System.out.print("vitusdance "+expireTime);System.out.println();
    }
}
