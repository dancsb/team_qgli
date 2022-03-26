package skeleton;

import java.util.ArrayList;

public class Amnesia extends Agent {

    //amnesia ágens konstruktora, melyben paraméterül kapja a virologust amely lekraftolta, hatási időt,
    //amino és nukleo költségeket és a szükséges genetikai kódot
    public Amnesia(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    //az amnesia ágens használata egy másik virológuson
    public void useOn(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Amnesia.useOn()");
        v.getGenCode().clear(); //TODO törlődik a lista?
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);

    }
}
