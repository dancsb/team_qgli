package skeleton;

import java.util.ArrayList;

public class Field {
    private ArrayList<Field> neighbours;
    private ArrayList<Virologist> virologists;

    public Field(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.constructor()");
        neighbours = new ArrayList<>();
        virologists = new ArrayList<>();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    public ArrayList<Field> getNeighbours() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.getNeighbours()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return neighbours;
    }

    public void addNeighbour(Field n){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.addNeighbour()");
        neighbours.add(n);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    public ArrayList<Virologist> getVirologists() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.getVirologists()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return virologists;
    }

    public boolean accept(Virologist v){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.accept()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return virologists.add(v);
    }

    public void remove(Virologist v){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.remove()");
        virologists.remove(v);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}