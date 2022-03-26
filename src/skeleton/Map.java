package skeleton;

import java.util.ArrayList;

public class Map {

    //a pályát alkotó mezőket tároló lista
    private ArrayList<Field> fields;

    //konstruktor, melyben legeneráljuk a pályát
    public Map() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Map.constructor()");
        this.fields = new ArrayList<>();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //visszatér a pályán levő mezőkkel
    public ArrayList<Field> getFields() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Map.getFields()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return fields;
    }

    //hozzáad egy mezőt a pályához, ez lehet lab,shleter, sotrage vagy sima field
    public void addField(Field f){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Map.addField()");
        fields.add(f);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
