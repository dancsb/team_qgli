package main.items.collectibles;

import main.virologist.*;
/**
 * Begyujtheto dolgokat reprezentalo osztaly.
 */
public interface Collectible {
    /**
     * Ez a fuggveny fut le ha felveszi
     * @param v a virologus aki felveszi
     */
    void collect(Virologist v);
}
