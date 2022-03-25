package skeleton;

public abstract class Equipment implements Collectible {
    @Override
    public void collect(Virologist v) {

    }

    public abstract void action(Virologist v);

    public abstract void remove(Virologist v);
}
