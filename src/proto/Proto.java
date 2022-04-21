package proto;

import main.items.collectibles.*;
import main.map.*;
import main.virologist.Virologist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

public class Proto {
    /**
     * Eltároljuk benne a virológusokat. Az azonosító a key.
     */
    private HashMap<String, Virologist>virologists;
    private Map map;



    private void running() throws IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            String[] cmd = line.split(" ");
            switch (cmd[0]) {
                case "Field":
                    for (int i = 0; i < Integer.parseInt(cmd[1]); i++)
                        map.addField(new Field());
                    break;

                case "Lab":
                    GeneticCode gc = new GeneticCode(cmd[2]);
                    boolean virusos = Boolean.parseBoolean(cmd[2]);
                    for (int i = 0; i < Integer.parseInt(cmd[1]); i++)
                        map.addField(new Lab(virusos, gc));
                    break;

                case "Shelter":
                    Equipment eq = null;
                        eq = new Bag(new Random().nextInt(101));
                    for (int i = 0; i < Integer.parseInt(cmd[1]); i++) {
                        if (cmd[2].equals("axe"))
                            map.addField(new Shelter(new Axe()));
                        else if (cmd[2].equals("gloves"))
                            map.addField(new Shelter(new Gloves()));
                        else if (cmd[2].equals("cape"))
                            map.addField(new Shelter(new Cape(82.3)));
                        else if (cmd[2].equals("bag"))
                            map.addField(new Shelter(new Bag(new Random().nextInt(101))));
                    }
                    break;

                case "Storage":
                    for (int i = 0; i < Integer.parseInt(cmd[1]); i++)
                        map.addField(new Storage(new AminoAcid(10,20), new Nucleotide(10, 20)));
                    break;
            }
        }
    }
}
