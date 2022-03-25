package skeleton;

public class Amnesia extends Agent {
    public Amnesia(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        super(v, effT, amino, nucleo, exTime, genCode);
    }

    public void useOn(Virologist v) {
        System.out.println("Amnesia.useOn()");
        v.getGenCode().clear(); // TODO: 2022. 03. 25. Törlődik a lista? 
    }
}
