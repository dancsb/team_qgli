package View;

/**
 * Interface a kirajzolandó objektumoknak
 */
public interface IView {
    /**
     * Kirajzol valami az adott indexre
     * @param v a view amibe rajzoljon
     * @param idx hová rajzoljon
     */
    void mustDraw(View v,int idx);
}
