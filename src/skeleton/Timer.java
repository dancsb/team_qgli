package skeleton;

import java.util.ArrayList;

public class Timer {
    private ArrayList<Steppable>steppables;
    public void tick(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Timer.tick()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
    public void addSteppable(Steppable s){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Timer.addSteppable()");
        steppables.add(s);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
