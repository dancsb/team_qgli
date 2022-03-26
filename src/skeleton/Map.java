package skeleton;

import java.util.ArrayList;

public class Map {
    private ArrayList<Field> fields;

    public Map() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Map.constructor()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        this.fields = new ArrayList<>();
    }

    public ArrayList<Field> getFields() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Map.getFields()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return fields;
    }

    public void addField(Field f){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Map.addField()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        fields.add(f);
    }
}
