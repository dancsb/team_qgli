package skeleton;

import java.util.ArrayList;

public class Paralyzer extends Agent {
    public Paralyzer(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    public void useOn(Virologist v) {
        System.out.println("Paralyzer.useOn()");
        ArrayList<Attribute> attribute=v.getAttributes();
        //Attribute[] attribute = v.getAttributes();
        for (Attribute a:attribute) {
            a.setTimePara(effectTime);
        }
    }
}