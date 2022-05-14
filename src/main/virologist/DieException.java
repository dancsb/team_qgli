package main.virologist;

public class DieException extends Exception{
    private final Virologist v;

    public DieException(Virologist v){
        this.v=v;
        v.setBearDance(true);
    }

    public Virologist getVirologist(){
        return v;
    }
}
