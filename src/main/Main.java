package main;

import proto.Proto;

import java.io.IOException;

public class Main {

    /**
     * Main fuggveny itt kerulnek a tesztek meghivasra
     */
    public static void main(String[] args){
        Proto p = new Proto();
        try {
            p.running();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
