package skeleton;

import java.util.ArrayList;

public class Map {
    private ArrayList<Field> fields;

    public Map() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Map.constructor()");
        this.fields = new ArrayList<>();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    public ArrayList<Field> getFields() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Map.getFields()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return fields;
    }

    public void addField(Field f){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Map.addField()");
        fields.add(f);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
