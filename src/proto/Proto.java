package proto;

import main.items.agents.Amnesia;
import main.items.agents.Invulnerable;
import main.items.agents.Paralyzer;
import main.items.agents.Vitusdance;
import main.items.collectibles.*;
import main.map.*;
import main.virologist.Virologist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Proto {
    /**
     * Eltároljuk benne a virológusokat. Az azonosító a key.
     */
    private HashMap<String, Virologist> virologists;
    private Map map;



    public void running() throws IOException {
        while (true) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            String[] cmd = line.split(" ");
            switch (cmd[0]) {
                case "field":
                    for (int i = 0; i < Integer.parseInt(cmd[1]); i++)
                        map.addField(new Field());
                    break;

                case "lab":
                    GeneticCode gc = new GeneticCode(cmd[3]);
                    boolean virusos = Boolean.parseBoolean(cmd[2]);
                    for (int i = 0; i < Integer.parseInt(cmd[1]); i++)
                        map.addField(new Lab(virusos, gc));
                    break;

                case "shelter":
                    for (int i = 0; i < Integer.parseInt(cmd[1]); i++) {
                        switch (cmd[2]) {
                            case "axe" -> map.addField(new Shelter(new Axe()));
                            case "gloves" -> map.addField(new Shelter(new Gloves()));
                            case "cape" -> map.addField(new Shelter(new Cape(82.3)));
                            case "bag" -> map.addField(new Shelter(new Bag(50)));
                        }
                    }
                    break;

                case "storage":
                    for (int i = 0; i < Integer.parseInt(cmd[1]); i++)
                        map.addField(new Storage(new AminoAcid(30,50), new Nucleotide(30, 50)));
                    break;

                case "setRoute":
                    map.getFields().get(Integer.parseInt(cmd[1])).addNeighbour(map.getFields().get(Integer.parseInt(cmd[2])));
                    break;

                case "virologist":
                    Virologist viro=new Virologist();
                    viro.setF(map.getFields().get(Integer.parseInt(cmd[2])));
                    map.getFields().get(Integer.parseInt(cmd[2])).getVirologists().add(viro);
                    virologists.put(cmd[1],viro);
                    break;

                case "agent":
                    switch (cmd[2]) {
                        case "amnesia" -> virologists.get(cmd[1]).getAgents().add(new Amnesia(virologists.get(cmd[1]), 50, 50, "amnesia"));
                        case "invulnerable" -> virologists.get(cmd[1]).getAgents().add(new Invulnerable(virologists.get(cmd[1]), 50, 50, "invulnerable"));
                        case "paralyzer" -> virologists.get(cmd[1]).getAgents().add(new Paralyzer(virologists.get(cmd[1]), 50, 50, "paralyzer"));
                        case "vitusdance" -> virologists.get(cmd[1]).getAgents().add(new Vitusdance(virologists.get(cmd[1]), 50, 50, "vitusdance"));
                    }
                    break;

                case "genCode":
                    switch (cmd[2]) {
                        case "amnesia", "invulnerable", "paralyzer", "vitusdance" -> virologists.get(cmd[1]).addGeneticCode(new GeneticCode(cmd[2]));
                    }
                    break;

                case "axe":
                    virologists.get(cmd[1]).getEquipments().add(new Axe());
                    virologists.get(cmd[1]).getEquipments().forEach(a->a.setUsed(Boolean.parseBoolean(cmd[2])));
                    break;

                case "cape":
                    virologists.get(cmd[1]).getEquipments().add(new Cape(80));
                    break;

                case "bag":
                    virologists.get(cmd[1]).getEquipments().add(new Bag(50));
                    break;

                case "gloves":
                    virologists.get(cmd[1]).getEquipments().add(new Gloves());
                    virologists.get(cmd[1]).getEquipments().forEach(a->a.setDurability(Integer.parseInt(cmd[2])));
                    break;

                case "beardance":
                    virologists.get(cmd[1]).setBearDance(true);
                    break;

                case "paralyze":
                    virologists.get(cmd[1]).getAttributes().forEach(a->a.setTimePara(Integer.parseInt(cmd[2])));
                    break;

                case "invulnerable":
                    virologists.get(cmd[1]).getAttributes().forEach(a->a.setTimeInvu(Integer.parseInt(cmd[2])));
                    virologists.get(cmd[1]).getAttributes().forEach(a->a.changeDefPerc(Double.parseDouble(cmd[2])));
                    break;

                case "dancing":
                    virologists.get(cmd[1]).getAttributes().forEach(a->a.setTimeDance(Integer.parseInt(cmd[2])));
                    break;

                case "resource":
                    virologists.get(cmd[1]).getResources().forEach(r->r.changeAmountAminoAcid(Integer.parseInt(cmd[2])));
                    virologists.get(cmd[1]).getResources().forEach(r->r.changeAmountNucleotide(Integer.parseInt(cmd[3])));
                    virologists.get(cmd[1]).getResources().forEach(r->r.setMaxAmount(Integer.parseInt(cmd[4])));
                    break;

                case "move":
                    virologists.get(cmd[1]).move(map.getFields().get(Integer.parseInt(cmd[2])));
                    break;

                case "stealEquipment":
                    virologists.get(cmd[1]).stealEquipment(virologists.get(cmd[2]),virologists.get(cmd[2]).getEquipments().get(Integer.parseInt(cmd[3])));
                    break;

                case "stealResource ":
                    //ezt nem értem hogy működik Gabó találd majd ki
                    virologists.get(cmd[1]).stealResources(virologists.get(cmd[2]),virologists.get(cmd[2]).getResources().get(Integer.parseInt(cmd[3])));
                    break;

                case "useAgent":
                    virologists.get(cmd[1]).useAgent(virologists.get(cmd[2]),virologists.get(cmd[1]).getAgents().get(Integer.parseInt(cmd[3])));
                    break;

                case "craftAgent":
                    switch (cmd[2]) {
                        case "amnesia" -> virologists.get(cmd[1]).craftAgent((new Amnesia(virologists.get(cmd[1]), 100, 100, "amnesia")));
                        case "invulnerable" -> virologists.get(cmd[1]).craftAgent(new Invulnerable(virologists.get(cmd[1]), 100, 100, "invulnerable"));
                        case "paralyzer" -> virologists.get(cmd[1]).craftAgent(new Paralyzer(virologists.get(cmd[1]), 100, 100, "paralyzer"));
                        case "vitusdance" -> virologists.get(cmd[1]).craftAgent(new Vitusdance(virologists.get(cmd[1]), 100, 100, "vitusdance"));
                    }
                    break;

                case "loseEquipment":
                    virologists.get(cmd[1]).loseEquipment(virologists.get(cmd[1]).getEquipments().get(Integer.parseInt(cmd[2])));
                    break;

                case "pickUpResource":
                    //Nem értem hogy működik a pickUpResource
                    //virologists.get(cmd[1]).pickUpResource()
                    break;

                case "die":
                    //Írja meg valaki
                    break;

                case "stat":
                    switch (cmd[1]) {
                        case "v" -> virologists.get(cmd[1]).printStat(cmd[2]);
                        case "f" ->
                            //nincs megírva
                                map.getFields().get(Integer.parseInt(cmd[1])).printStat();
                    }
                    break;
            }
        }
    }
}
