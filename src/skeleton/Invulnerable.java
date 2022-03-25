package skeleton;

import java.util.ArrayList;

public class Invulnerable extends Agent {
    public Invulnerable(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    public void useOn(Virologist v) {
        System.out.println("Invulnerable.useOn()");
        ArrayList<Attribute> attribute = v.getAttributes();
        for (Attribute a:attribute) {
            a.setTimeInvu(effectTime);
        }
    }
}
