package main.map;

import java.util.ArrayList;


public class Map {

    //a palyat alkoto mezoket tarolo lista
    private ArrayList<Field> fields;

    //konstruktor, melyben legeneraljuk a palyat
    public Map() {
        this.fields = new ArrayList<>();
    }

    //visszater a palyan levo mezokkel
    public ArrayList<Field> getFields() {
        return fields;
    }

    //hozzaad egy mezot a palyahoz, ez lehet lab,shleter, sotrage vagy sima field
    public void addField(Field f){
        fields.add(f);
    }
}
