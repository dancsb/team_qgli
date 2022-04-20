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
     * @param effT az ido ameddig tart
     * @param exTime az ido ameddig nem jar le az agens
     * @param genCode kraftolashoz szukseges genetikai kod
     * @param nucleo kraftolashoz szukseges nukleotidok szama
     * @param v a tulajdonos virologus
     */
    public Vitusdance(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    /**
     * A vitusdance agens hasznalata egy masik virologuson
     * @param v a virologus amelyen az agenst hasznaljuk
     */
    public void useOn(Virologist v) {
        v.getAttributes().forEach(a->a.setTimeDance(effectTime));
    }
    @Override
    public void printStat(){
        System.out.print("vitusdance "+expireTime);
    }
}
