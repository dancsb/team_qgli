package main.items.collectibles;

import main.virologist.Virologist;

public class Axe extends Equipment{
    private boolean used=false;

    @Override
    public void action(Virologist v) {

    }

    @Override
    public void remove(Virologist v) {

    }

    @Override
    public boolean getUsed() {
        return used;
    }

    @Override
    public void setUsed(boolean used) {
        this.used=used;
    }
    @Override
    public void printStat(){
        System.out.print("axe "+used);
        System.out.println();
    }
}
