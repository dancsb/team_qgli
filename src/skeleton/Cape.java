package skeleton;

import java.util.ArrayList;

public class Cape extends Equipment{

    //a köpennyel járó védekezési előny mértéke
    private long defPerc;

    //a köpeny begyűjtését valósítja meg, és az azzal járó "ágens elleni védekezés" képességet állítja be
    @Override
    public void action(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Cape.action()");
        ArrayList<Attribute> attributes = v.getAttributes();
        attributes.forEach(r -> r.changeDefPerc(defPerc));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //a köpeny elvesztésekor "elveszi" a kopeny által nyújtott "ágens elleni védekezés" képességet a virológustól
    @Override
    public void remove(Virologist v) {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Cape.remove()");
        ArrayList<Attribute> attributes = v.getAttributes();
        attributes.forEach(r -> r.changeDefPerc(-defPerc));
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
