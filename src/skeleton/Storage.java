package skeleton;

import java.util.ArrayList;

public class Storage extends Field{

    private ArrayList<Resources> res;

    public Storage (Resources r1, Resources r2){
        System.out.println("Shelter.constructor()");
        res = new ArrayList<>();
        res.add(r1);
        res.add(r2);
    }

    @Override
    public boolean accept(Virologist v) {
        System.out.println("Storage.accept()");
        if (super.accept(v)){

            return true;
        }
        return false;
    }
}
