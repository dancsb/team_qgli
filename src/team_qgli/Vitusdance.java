package team_qgli;

public class Vitusdance extends Agent {
    public Vitusdance(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    public void useOn(Virologist v) {
        System.out.println("Vitusdance.useOn()");
        Attribute[] attribute = v.getAttributes();
        for (Attribute a:attribute) {
            a.setTimeDance(effectTime);
        }
    }
}
