package team_qgli;

public abstract class Equipment implements Collectible {
    @Override
    public abstract void collect(Virologist v);
    public void Action(Virologist v){}
    public void Remove(Virologist v){}
}
