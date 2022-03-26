package skeleton;

public class Gloves extends Equipment{

    //a kesztyű begyűjtését valósítja meg, és az azzal járó "visszakenés" képességet állítja be
    @Override
    public void action(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Gloves.action()");
        v.setParry(true);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //a kesztyű elvesztésekor "elveszi" a kesztyű által nyújtott "visszakenés" képességet a virológustól
    @Override
    public void remove(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Gloves.remove()");
        v.setParry(false);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
