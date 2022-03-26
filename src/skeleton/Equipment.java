package skeleton;

public abstract class Equipment implements Collectible {

    //egy felszerelés begyűjtését valósítja meg, és az azzal járó hatást/képességet állítja be
    @Override
    public void collect(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Equipment.collect()");
        action(v);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //beállitja a felszerelés felvételével járó hatást
    public abstract void action(Virologist v);

    //egy felszerelés elvesztésekor "elveszi" a felszerelés által nyújtott hatást/képességet a virológustól
    public abstract void remove(Virologist v);
}
