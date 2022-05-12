package main;

import View.*;
import main.map.Map;
import proto.Proto;

import java.io.IOException;

public class Main {
    private View view;
    private Game game;
    /**
     * Main fuggveny itt kerulnek a tesztek meghivasra
     */
    public static void main(String[] args){
        View v = new View();
        new Controller(v, new Game(new Map(v.getMapView().getPolygons())));
    }
}
