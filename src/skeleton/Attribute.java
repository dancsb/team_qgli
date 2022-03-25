package skeleton;

public class Attribute implements Steppable{
    protected long time;
    public void setTimePara(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Attribute.setTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    public long getTimePara(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Attribute.getTimePara()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    public void setTimeInvu(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Attribute.setTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    public long getTimeInvu(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Attribute.getTimeInvu()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    public void setTimeDance(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Attribute.setTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    public long getTimeDance(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Attribute.getTimeDance()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return 0;
    }
    public void changeDefPerc(long x){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Attribute.changeDefPerc()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    @Override
    public void step() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Attribute.step()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
