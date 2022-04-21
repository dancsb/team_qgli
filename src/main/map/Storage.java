package main.map;

import java.util.ArrayList;
import main.items.collectibles.*;
import main.virologist.*;

public class Storage extends Field {

    /**
     * A raktarban elhelyezett felszereles
     */
    private ArrayList<Resource> res;

    /**
     * Storage kosntruktora, storage letrehozasa benne egy megtanulhato eroforrasokkal
     * @param r1 a storage mezon megtalalhato aminosavak
     * @param r2 a storage mezon megtalalhato nukleotidok
     */
    public Storage (Resource r1, Resource r2){
        res = new ArrayList<>();
        res.add(r1);
        res.add(r2);
    }

    /**
     * Ha egy virologus arra a mezore szeretne lepni,ez a fuggveny eldontheti, hogy lephet e oda vagy sem
     * Illetve az adott mezon levo targyak begyujteset vegzi el
     * @param v az adott storage mezore lepni kivano virologus
     * @return igaz ertekkel ter vissza ha a virologust beengedte az adott mezore, hamis ertekkel ha oda nem lephet a virologus
     */
    @Override
    public boolean accept(Virologist v) {
        if (super.accept(v)){
            for (Resource r: res){
                //eroforrasok begyujtese
                r.collect(v);
            }
            return true;
        }
        return false;
    }
}
