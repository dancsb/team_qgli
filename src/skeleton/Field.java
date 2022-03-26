package skeleton;

import java.util.ArrayList;

public class Field {

    //szomszédokat tároló lista
    private ArrayList<Field> neighbours;
    //egy mezőn tartózkodó virológusokat tároló lista
    private ArrayList<Virologist> virologists;

    //konstruktor
    public Field(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.constructor()");
        neighbours = new ArrayList<>();
        virologists = new ArrayList<>();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //visszatér egy adott mező szomszédos mezőivel
    public ArrayList<Field> getNeighbours() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.getNeighbours()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return neighbours;
    }

    //szomszédokat ad egy mező mellé
    public void addNeighbour(Field n){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.addNeighbour()");
        neighbours.add(n);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    //visszatér a virológusokkal amelyek az adott mezőn tartózkodnak
    public ArrayList<Virologist> getVirologists() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.getVirologists()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return virologists;
    }

    //ha egy virológus arra a mezőre szeretne lépni, eldöntheti, hogy léphet e oda vagy sem
    public boolean accept(Virologist v){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.accept()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return virologists.add(v);
    }

    //eltávolít egy virológust az adott mezőről
    public void remove(Virologist v){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.remove()");
        virologists.remove(v);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}