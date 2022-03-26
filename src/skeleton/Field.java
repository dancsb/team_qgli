package skeleton;

import java.util.ArrayList;

/**
 * Egy mezőt reprezentál.
 */
public class Field {

    /**
     * A szomszédos mezőket tároló lista
     */
    private ArrayList<Field> neighbours;
    /**
     * A mezőn tartózkodó virológusokat tároló lista
     */
    private ArrayList<Virologist> virologists;

    /**
     * Field konstruktora
     */
    public Field(){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.constructor()");
        neighbours = new ArrayList<>();
        virologists = new ArrayList<>();
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }



    /**
     * @return visszatér egy adott mező szomszédos mezőivel
     */
    public ArrayList<Field> getNeighbours() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.getNeighbours()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return neighbours;
    }

    /**
     * Hozzáad egy szomszédot egy mezőhöz
     * @param n a szomszéd mező amit hozzá akarunk adni
     */
    public void addNeighbour(Field n){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.addNeighbour()");
        neighbours.add(n);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }

    /**
     *
     * @return visszatér a virológusokkal amelyek az adott mezőn tartózkodnak
     */
    public ArrayList<Virologist> getVirologists() {
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.getVirologists()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return virologists;
    }
    /**
     * Ha egy virológus arra a mezőre szeretne lépni, eldöntheti, hogy léphet e oda vagy sem
     * @param v a virológus aki lépni akar
     * @return true ha léphet, false ha nem
     */
    public boolean accept(Virologist v){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.accept()");
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
        return virologists.add(v);
    }
    /**
     * Eltávolít egy virológust az adott mezőről
     * @param v az eltávolítandó virolgóus
     */
    public void remove(Virologist v){
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() + 1);
        SkeletonWriter.println("Field.remove()");
        virologists.remove(v);
        SkeletonWriter.setLevel(SkeletonWriter.getLevel() - 1);
    }
}