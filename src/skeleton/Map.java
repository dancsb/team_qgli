package skeleton;

import java.util.ArrayList;

public class Map {
    private ArrayList<Field> fields;

    public Map() {
        System.out.println("Map.constructor()");
        this.fields = new ArrayList<>();
    }

    public ArrayList<Field> getFields() {
        System.out.println("Map.getFields()");
        return fields;
    }

    public void addField(Field f){
        System.out.println("Map.addField()");
        fields.add(f);
    }
}