package skeleton;

/**
 * A Game osztály idnítja el a játékot.
 */
public class Game {
    /**
     * A pálya
     */
    private Map map;

    /**
     * A játék indítása
     */
    public void startGame(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Game.startGame()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     * játék vége, akkor hívódik meg, ha checkWin() igaz értékkel tér visssza
     */
    public static void endGame(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Game.endGame()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
