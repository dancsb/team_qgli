package skeleton;

import java.util.ArrayList;

public class Shelter extends Field{
    private Equipment eq;

    public Shelter(Equipment eq) {
        System.out.println("Storage.constructor()");
        this.eq = eq;
    }

    @Override
    public boolean accept(Virologist v) {
        System.out.println("Shelter.accept()");
        return super.accept(v);
    }
}
