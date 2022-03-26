package skeleton;

public class Attribute implements Steppable{

    //hatási ideje
    protected long time;

    //egy virológus paralelizált állapotának idejének a beállítása
    public void setTimePara(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.setTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    //egy virológus paralelizált állapotának hátralevő idejének a lekérdezése
    public long getTimePara(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.getTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    //egy virológus sebezhetetlen állapotának idejének a beállítása
    public void setTimeInvu(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.setTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    //egy virológus sebezhetetlen állapotának hátralevő idejének a lekérdezése
    public long getTimeInvu(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.getTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    //egy virológus vitustáncot járó állapotának idejének a beállítása
    public void setTimeDance(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.setTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    //egy virológus vitustáncot járó állapotának hátralevő idejének a lekérdezése
    public long getTimeDance(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.getTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    //egy virológus a köpeny által nyert védekezési képesség százalékos beállítása
    //vagy a köpeny elvesztésével járó viszzaállítás
    public void changeDefPerc(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.changeDefPerc()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    @Override
    public void step() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Attribute.step()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
