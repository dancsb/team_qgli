package team_qgli;

import java.util.ArrayList;

public class Field {
    private ArrayList<Field> neighbours;
    private ArrayList<Virologist> virologists;

    public Field(){
        neighbours = new ArrayList<>();
        virologists = new ArrayList<>();
    }

    public ArrayList<Field> getNeighbours() {
        System.out.println("Field.getNeighbours()");
        return neighbours;
    }

    public void addNeighbour(Field n){
        System.out.println("Field.addNeighbour()");
        neighbours.add(n);
    }

    public ArrayList<Virologist> getVirologists() {
        System.out.println("Field.getVirologists()");
        return virologists;
    }

    public boolean accept(Virologist v){
        System.out.println("Field.accept()");
        return virologists.add(v);
    }

    public void remove(Virologist v){
        System.out.println("Field.remove()");
        virologists.remove(v);
    }
}