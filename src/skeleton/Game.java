package skeleton;

/**
 * A Game osztaly idnitja el a jatekot.
 */
public class Game {
    /**
     * A palya
     */
    private Map map;

    /**
     * A jatek inditasa
     */
    public void startGame(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Game.startGame()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * Jatek vege, akkor hivodik meg, ha checkWin() igaz ertekkel ter visssza
     */
    public static void endGame(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Game.endGame()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
