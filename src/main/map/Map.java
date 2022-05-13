package main.map;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;


public class Map {

    //a palyat alkoto mezoket tarolo lista
    private ArrayList<Field> fields;

    //konstruktor, melyben legeneraljuk a palyat
    public Map(ArrayList<Polygon> polygons) {
        this.fields = new ArrayList<>();
        for (int i = 0; i < polygons.size(); i++){
            //70% Field, 10% Storage,Shelter,Lab
            int r=new Random().nextInt(10);
            if(r==0)fields.add(new Lab());
            else if(r==1)fields.add(new Shelter());
            else if(r==2)fields.add(new Storage());
            else fields.add(new Field());
            System.out.println(fields.get(i).toString());
        }

        for (int i = 0; i < polygons.size() - 1; i++) {
            for (int j = i + 1; j < polygons.size(); j++) {
                for (int k = 0; k < polygons.get(i).npoints; k++) {
                    for (int l = 0; l < polygons.get(j).npoints; l++) {
                        if((polygons.get(i).xpoints[k % polygons.get(i).npoints] == polygons.get(j).xpoints[l % polygons.get(j).npoints] && polygons.get(i).ypoints[k % polygons.get(i).npoints] == polygons.get(j).ypoints[l % polygons.get(j).npoints] &&
                            polygons.get(i).xpoints[(k + 1)  % polygons.get(i).npoints] == polygons.get(j).xpoints[(l + 1)  % polygons.get(j).npoints] && polygons.get(i).ypoints[(k + 1) % polygons.get(i).npoints] == polygons.get(j).ypoints[(l + 1) % polygons.get(j).npoints]) || (
                            polygons.get(i).xpoints[k % polygons.get(i).npoints] == polygons.get(j).xpoints[(l + 1) % polygons.get(j).npoints] && polygons.get(i).ypoints[k % polygons.get(i).npoints] == polygons.get(j).ypoints[(l + 1) % polygons.get(j).npoints] &&
                            polygons.get(i).xpoints[(k + 1) % polygons.get(i).npoints] == polygons.get(j).xpoints[l % polygons.get(j).npoints] && polygons.get(i).ypoints[(k + 1) % polygons.get(i).npoints] == polygons.get(j).ypoints[l % polygons.get(j).npoints]))
                                fields.get(i).addNeighbour(fields.get(j));
                    }
                }
            }
        }
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
