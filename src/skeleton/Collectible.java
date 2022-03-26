package skeleton;

/**
 * Begyűjthető dolgokat reprezentáló osztály.
 */
public interface Collectible {
    /**
     * Ez a függvény fut le ha felveszi
     * @param v a virológus aki felveszi
     */
    void collect(Virologist v);
}
