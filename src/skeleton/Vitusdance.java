package skeleton;

import java.util.ArrayList;

public class Vitusdance extends Agent {

    //viutsdance ágens konstruktora, melyben paraméterül kapja a virologust amely lekraftolta, hatási időt,
    //amino és nukleo költségeket és a szükséges genetikai kódot
    public Vitusdance(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    //a vitusdance ágens használata egy másik virológuson
    public void useOn(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Vitusdance.useOn()");
        ArrayList<Attribute> attribute=v.getAttributes();
        for (Attribute a:attribute) {
            a.setTimeDance(effectTime);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
