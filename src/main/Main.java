package main;

import View.*;
import main.map.Map;

public class Main {
    private static Controller controller;
    /**
     * Main fuggveny itt kerulnek a tesztek meghivasra
     */
    public static void main(String[] args){
        View v = new View();
        controller = new Controller(v, new Game(new Map(v.getMapView().getPolygons())));
    }

    public static Controller getController() {
        return controller;
    }
}
