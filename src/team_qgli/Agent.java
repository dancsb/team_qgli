package team_qgli;

public abstract class Agent implements Steppable {
    protected Virologist owner;
    protected long effectTime;
    protected long costAmino;
    protected long costNucleotide;
    protected long expireTime;
    protected String requireGen;

    public abstract void UseOn(Virologist v);

    public void Step() {
        System.out.println("Agent.Step()");
    }

    public void GetCrafted(Virologist v) {
        System.out.println("Agent.GetCrafted()");
    }

}
