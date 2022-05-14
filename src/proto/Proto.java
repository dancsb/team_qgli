package proto;
import main.items.agents.Amnesia;
import main.items.agents.Invulnerable;
import main.items.agents.Paralyzer;
import main.items.agents.Vitusdance;
import main.items.collectibles.*;
import main.map.*;
import main.virologist.DieException;
import main.virologist.Virologist;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Proto {
    /**
     * Eltaroljuk benne a virologusokat. Az azonosito a kulcs.
     */
    private HashMap<String, Virologist> virologists=new HashMap<>();
    /**
     * A palya
     */
    private Map map=new Map(new ArrayList<>());

//
    /**
     * Parancsokat fogado es vegrahajto fuggveny
     * @throws IOException kivetel
     */
    public void running() throws IOException {
        while(true){
            String[]cmd=new Scanner(System.in).nextLine().split(" ");
            if(cmd[0].equals("exit"))break;
            commandAnalyzer(cmd);
        }
    }
    private void readIn(String fileName) throws IOException {
        virologists.clear();
        map.getFields().clear();
        Scanner sc=new Scanner(new File("bemenetek/"+fileName));
        while(sc.hasNext()){
            commandAnalyzer(sc.nextLine().split(" "));
        }
    }
    public void tesztelekHaha(){
        int i=1;
        while(i!=68){
            try {
                System.out.println(i+". teszt");
                String[]s={"runtest",i+".in"};
                commandAnalyzer(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            i++;
        }

    }
    private void commandAnalyzer(String []cmd) throws IOException {
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
                        case "axe" : map.addField(new Shelter(new Axe())); break;
                        case "gloves" : map.addField(new Shelter(new Gloves())); break;
                        case "cape" : map.addField(new Shelter(new Cape(82.3))); break;
                        case "bag" : map.addField(new Shelter(new Bag(50))); break;
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
                Virologist viro=new Virologist(new Field(),0);
                viro.setField(map.getFields().get(Integer.parseInt(cmd[2])));
                viro.getField().accept(viro);
                virologists.put(cmd[1],viro);
                break;

            case "agent":
                switch (cmd[2]) {
                    case "amnesia" : virologists.get(cmd[1]).getAgents().add(new Amnesia(virologists.get(cmd[1]), 50, 50, "amnesia")); break;
                    case "invulnerable" : virologists.get(cmd[1]).getAgents().add(new Invulnerable(virologists.get(cmd[1]), 50, 50, "invulnerable")); break;
                    case "paralyzer" : virologists.get(cmd[1]).getAgents().add(new Paralyzer(virologists.get(cmd[1]), 50, 50, "paralyzer")); break;
                    case "vitusdance" : virologists.get(cmd[1]).getAgents().add(new Vitusdance(virologists.get(cmd[1]), 50, 50, "vitusdance")); break;
                }
                break;

            case "genCode":
                switch (cmd[1]) {
                    case "amnesia": case "invulnerable": case "paralyzer": case "vitusdance": virologists.get(cmd[2]).addGeneticCode(new GeneticCode(cmd[1])); break;
                }
                break;

            case "axe":
                virologists.get(cmd[1]).pickUpEquipment(new Axe());
                virologists.get(cmd[1]).getEquipments().forEach(a->a.setUsed(Boolean.parseBoolean(cmd[2])));
                break;

            case "cape":
                virologists.get(cmd[1]).pickUpEquipment(new Cape(Double.parseDouble(cmd[2])));
                break;

            case "bag":
                virologists.get(cmd[1]).pickUpEquipment(new Bag(Integer.parseInt(cmd[2])));
                break;

            case "gloves":
                virologists.get(cmd[1]).pickUpEquipment(new Gloves());
                virologists.get(cmd[1]).getEquipments().forEach(a->a.setDurability(Integer.parseInt(cmd[2])));
                break;

            case "bearDance":
                virologists.get(cmd[1]).setBearDance(true);
                break;

            case "paralyze":
                virologists.get(cmd[1]).getAttributes().forEach(a->a.setTimePara(Integer.parseInt(cmd[2])));
                break;

            case "invulnerable":
                virologists.get(cmd[1]).getAttributes().forEach(a->a.setTimeInvu(Integer.parseInt(cmd[2])));
                virologists.get(cmd[1]).getAttributes().forEach(a->a.changeDefPerc(100));
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
                try {
                    virologists.get(cmd[1]).move(map.getFields().get(Integer.parseInt(cmd[2])));
                } catch (DieException e) {
                }
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
                    case "amnesia" : virologists.get(cmd[1]).craftAgent((new Amnesia(virologists.get(cmd[1]), 100, 100, "amnesia"))); break;
                    case "invulnerable" : virologists.get(cmd[1]).craftAgent(new Invulnerable(virologists.get(cmd[1]), 100, 100, "invulnerable")); break;
                    case "paralyzer" : virologists.get(cmd[1]).craftAgent(new Paralyzer(virologists.get(cmd[1]), 100, 100, "paralyzer")); break;
                    case "vitusdance" : virologists.get(cmd[1]).craftAgent(new Vitusdance(virologists.get(cmd[1]), 100, 100, "vitusdance")); break;
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
                try {
                    virologists.get(cmd[1]).die();
                } catch (DieException e) {

                }
                break;

            case "stat":
                switch (cmd[1]) {
                    case "v" : virologists.get(cmd[2]).printStat(cmd[2],map.getFields().indexOf(virologists.get(cmd[2]).getField())); break;
                    case "f" : map.getFields().get(Integer.parseInt(cmd[2])).printStat(virologists,map.getFields()); break;
                }
                break;
            case "runtest":
                String tempFilename = cmd[1].substring(0, cmd[1].indexOf('.')) + ".temp";
                String outFilename = cmd[1].substring(0, cmd[1].indexOf('.')) + ".out";
                System.setOut(new PrintStream(tempFilename));
                readIn(cmd[1]);
                Path outFileP = new File(outFilename).toPath();
                Path tempFileP = new File(tempFilename).toPath();
                System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
                if (compareFiles(outFileP, tempFileP))
                    System.out.println("Megfelelo teszt!");
                else
                    System.out.println("Rossz teszt!");
                tempFileP.toFile().delete();
                break;
        }
    }

    private boolean compareFiles(Path outFile, Path tempFile) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader("kimenetek/"+ outFile));
        BufferedReader reader2 = new BufferedReader(new FileReader(String.valueOf(tempFile)));
        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        while (line1 != null || line2 != null)
        {
            if(line1 == null || line2 == null)
            {
                reader1.close();
                reader2.close();
                return false;
            }
            else if(!line1.equals(line2))
            {
                System.out.println("az elvárt output sora: "+line1);
                System.out.println("a temp: "+line2);
                reader1.close();
                reader2.close();
                return false;
            }

            line1 = reader1.readLine();
            line2 = reader2.readLine();
        }
        reader1.close();
        reader2.close();
        return true;
    }
}
