package skeleton;

public abstract class SkeletonWriter {

    //TABULÁLÁST MEGVALÓSITÓ OSZTÁLY

    private static int level = 0;

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        SkeletonWriter.level = level;
    }

    public static void println(String s) {
        for (int i = 0; i < level - 1; i++)
            System.out.print("\t");
        System.out.println(s);
    }
}
