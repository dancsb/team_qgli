package skeleton;

import java.util.ArrayList;

/**
 * Timer osztaly megvalosítasa
 */
public class Timer {

    private ArrayList<Steppable>steppables;

    public void tick(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Timer.tick()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    public void addSteppable(Steppable s){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Timer.addSteppable()");
        steppables.add(s);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
