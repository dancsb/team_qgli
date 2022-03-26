package skeleton;

import java.util.ArrayList;

public class Field {
    private ArrayList<Field> neighbours;
    private ArrayList<Virologist> virologists;

    public Field(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Field.constructor()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        neighbours = new ArrayList<>();
        virologists = new ArrayList<>();
    }

    public ArrayList<Field> getNeighbours() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Field.getNeighbours()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return neighbours;
    }

    public void addNeighbour(Field n){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Field.addNeighbour()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        neighbours.add(n);
    }

    public ArrayList<Virologist> getVirologists() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Field.getVirologists()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return virologists;
    }

    public boolean accept(Virologist v){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Field.accept()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return virologists.add(v);
    }

    public void remove(Virologist v){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.Println("Field.remove()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        virologists.remove(v);
    }
}