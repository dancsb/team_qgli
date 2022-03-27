package main.map;

import skeleton.SkeletonWriter;

import java.util.ArrayList;


public class Map {

    //a palyat alkoto mezoket tarolo lista
    private ArrayList<Field> fields;

    //konstruktor, melyben legeneraljuk a palyat
    public Map() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Map.constructor()");
        this.fields = new ArrayList<>();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //visszater a palyan levo mezokkel
    public ArrayList<Field> getFields() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Map.getFields()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return fields;
    }

    //hozzaad egy mezot a palyahoz, ez lehet lab,shleter, sotrage vagy sima field
    public void addField(Field f){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Map.addField()");
        fields.add(f);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}
