package skeleton;

public class Game {
    private Map map;

    public void startGame(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Game.startGame()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    public static void endGame(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Game.endGame()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
