package main.map;

import main.virologist.Virologist;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * A pályát reprezentáló osztály
 */
public class Map {

    /**
     * A mezők listája
     */
    private ArrayList<Field> fields;

    /**
     * Konstruktor ami polygonok alapján generál mapet
     * @param polygons a polygonok listája
     */
    public Map(ArrayList<Polygon> polygons) {
        int labNumber = 0;
        this.fields = new ArrayList<>();
        //legalább 4 labornak kell lenni
        while(labNumber<4){
            this.fields.clear();
            labNumber=0;
            for (int i = 0; i < polygons.size(); i++){
                //70% Field, 10% Storage,Shelter,Lab
                int r=new Random().nextInt(10);
                if(r==0){
                    fields.add(new Lab());labNumber++;
                }
                else if(r==1)fields.add(new Shelter());
                else if(r==2)fields.add(new Storage());
                else fields.add(new Field());
            }
        }
        //Magic, hogy beállítsuk a szomszédságokat
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

    /**
     * Legenerálja a virológusokat a mapre
     * @param n a virológusok száma
     */
    public void generateVirologists(int n){
        for(int i=0;i<n;i++){
            int fieldIndex=new Random().nextInt(fields.size());
            Virologist v=new Virologist(fields.get(fieldIndex),i);
            fields.get(fieldIndex).getVirologists().add(v);
        }
    }

    /**
     * visszater a palyan levo mezokkel
     */

    public ArrayList<Field> getFields() {
        return fields;
    }

    /**
     * hozzáad egy fieldet
     * @param f a field amit hozzáad
     */
    public void addField(Field f){
        fields.add(f);
    }

}
