package main.virologist;

/**
 * Exception, hogy jelezzük ha meghal egy virológus
 */
public class DieException extends Exception{
    /**
     * A virológus aki meghalt
     */
    private final Virologist v;

    public DieException(Virologist v){
        this.v=v;
        v.setBearDance(true);
    }

    public Virologist getVirologist(){
        return v;
    }
}
