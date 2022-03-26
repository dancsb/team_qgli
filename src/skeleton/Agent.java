package skeleton;

import java.util.ArrayList;

public abstract class Agent implements Steppable {
    protected Virologist owner;
    protected long effectTime;
    protected long costAmino;
    protected long costNucleotide;
    protected long expireTime;
    protected String requireGenCode;

    public Agent(Virologist v, long effT, long amino, long nucleo, long exTime, String genCode) {
        owner = v;
        effectTime = effT;
        costAmino = amino;
        costNucleotide = nucleo;
        expireTime = exTime;
        requireGenCode = genCode;
    }

    public Virologist getOwner() {
        return owner;
    }

    public long getEffectTime() {
        return effectTime;
    }

    public long getCostAmino() {
        return costAmino;
    }

    public long getCostNucleotide() {
        return costNucleotide;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public String getRequireGenCode() {
        return requireGenCode;
    }

    public abstract void useOn(Virologist v);

    public void step() {
        System.out.println("Agent.step()");
    }

    public void getCrafted(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Agent.getCrafted()");
        ArrayList<Resources> resource = v.getResources();
        for (Resources r:
             resource) {
            v.loseResources(r);
        }
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
