package skeleton;

import java.util.ArrayList;

public class Invulnerable extends Agent {
    public Invulnerable(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    public void useOn(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Invulnerable.useOn()");
        ArrayList<Attribute> attribute=v.getAttributes();
        for (Attribute a:attribute) {
            a.setTimeInvu(effectTime);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
