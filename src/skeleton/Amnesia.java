package skeleton;

import java.util.ArrayList;

public class Amnesia extends Agent {
    public Amnesia(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    public void useOn(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Amnesia.useOn()");
        v.getGenCode().clear(); // TODO: 2022. 03. 25. Törlődik a lista?
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);

    }
}
