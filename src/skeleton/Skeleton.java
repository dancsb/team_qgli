package skeleton;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.CodeSigner;
import java.util.Scanner;

public class Skeleton {

    int selectedUseCase;

    public Skeleton(){}

    public void runTests() {
        while (true) {
            System.out.println("1. Virologist crafts Amnesia");
            System.out.println("2. Virologist crafts Invulnerable");
            System.out.println("3. Virologist crafts Paralyzer");
            System.out.println("4. Virologist crafts Vitusdance");
            System.out.println("5. Virologist loses AminoAcid");
            System.out.println("6. Virologist loses Bag");
            System.out.println("7. Virologist loses Cape");
            System.out.println("8. Virologist loses Gloves");
            System.out.println("9. Virologist loses Nucleotide");
            System.out.println("10. Virologist picks up AminoAcid");
            System.out.println("11. Virologist picks up Bag");
            System.out.println("12. Virologist picks up Cape");
            System.out.println("13. Virologist picks up Glove");
            System.out.println("14. Virologist picks up Nucleotide");
            System.out.println("15. Virologist steals AminoAcid");
            System.out.println("16. Virologist steals Bag");
            System.out.println("17. Virologist steals Cape");
            System.out.println("18. Virologist steals Glove");
            System.out.println("19. Virologist steals Nucleotide");
            System.out.println("20. Virologist steps on Field");
            System.out.println("21. Virologist steps on Lab");
            System.out.println("22. Virologist steps on Shelter");
            System.out.println("23. Virologist steps on Storage");
            System.out.println("24. Virologist uses Amnesia");
            System.out.println("25. Virologist uses Invulnerable");
            System.out.println("26. Virologist uses Paralyzer");
            System.out.println("27. Virologist uses Vitusdance");
            System.out.println("28. Exit");
            System.out.println();
            System.out.println("Ird be a megfelelo szamot:");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            int selectedUseCase=new Scanner(System.in).nextInt();

            switch (selectedUseCase) {
                case 1:
                    craftsAmenesiaTest();
                    break;
                case 2:
                    craftsInvulnerableTest();
                    break;
                case 3:
                    craftsParalyzerTest();
                    break;
                case 4:
                    craftsVitusdanceTest();
                    break;
                case 5:
                    losesAminoAcidTest();
                    break;
                case 6:
                    losesBagTest();
                    break;
                case 7:
                    losesCapeTest();
                    break;
                case 8:
                    losesGlovesTest();
                    break;
                case 9:
                    losesNucleotideTest();
                case 10:
                    picksUpAminoAcidTest();
                    break;
                case 11:
                    picksUpBagTest();
                    break;
                case 12:
                    picksUpCapeTest();
                    break;
                case 13:
                    picksUpGlovesTest();
                    break;
                case 14:
                    picksUpNucleotideTest();
                    break;
                case 15:
                    stealsAminoAcidTest();
                    break;
                case 16:
                    stealsBagTest();
                    break;
                case 17:
                    stealsCapeTest();
                    break;
                case 18:
                    stealsGlovesTest();
                    break;
                case 19:
                    stealsNucleotideTest();
                    break;
                case 20:
                    stepsOnFieldTest();
                    break;
                case 21:
                    stepsOnLabTest();
                    break;
                case 22:
                    stepsOnShelterTest();
                    break;
                case 23:
                    stepsOnStorageTest();
                    break;
                case 24:
                    usesAmnesiaTest();
                    break;
                case 25:
                    usesInvulnerableTest();
                    break;
                case 26:
                    usesParalyzerTest();
                    break;
                case 27:
                    usesVitusdanceTest();
                    break;
                case 28:
                    System.exit(0);
                    break;
                default:
                    throw new IllegalStateException("Ervenytelen szam: " + selectedUseCase);
            }
            System.out.println("Üss egy billentyűt a továbblépéshez");
            new Scanner(System.in).nextLine();
        }
    }
    private void usesVitusdanceTest(){
        System.out.println("Virologist uses Vitusdance");
        Virologist v = new Virologist();
        Virologist targetV = new Virologist();
        Vitusdance vD=new Vitusdance(v,10,10,10,10,"asd");
        v.useAgent(targetV, vD);
    }

    private void usesParalyzerTest() {
        System.out.println("Virologist uses Paralyzer");
        Virologist v = new Virologist();
        Virologist targetV = new Virologist();
        Paralyzer p=new Paralyzer(v,10,10,10,10,"asd");
        v.useAgent(targetV, p);
    }

    private void usesInvulnerableTest() {
        System.out.println("Virologist uses Invulnerable");
        Virologist v = new Virologist();
        Virologist targetV = new Virologist();
        Invulnerable p=new Invulnerable(v,10,10,10,10,"asd");
        v.useAgent(targetV, p);
    }

    private void usesAmnesiaTest() {
        System.out.println("Virologist uses Amnesia");
        Virologist v = new Virologist();
        Virologist targetV = new Virologist();
        Amnesia p=new Amnesia(v,10,10,10,10,"asd");
        v.useAgent(targetV, p);
    }


    private void stepsOnStorageTest() {
        System.out.println("Virologist steps on Storage");
        Virologist virologist = new Virologist();
        AminoAcid amino = new AminoAcid();
        Nucleotide nucleo = new Nucleotide();
        Storage storage = new Storage(amino, nucleo);
        virologist.move(storage);
    }

    private void stepsOnShelterTest() {
        System.out.println("Virologist steps on Shelter");
        Virologist virologist = new Virologist();
        Gloves gloves = new Gloves();
        Shelter shelter = new Shelter(gloves);
        virologist.move(shelter);
    }

    private void stepsOnLabTest() {
        System.out.println("Virologist steps on Lab");
        Virologist virologist = new Virologist();
        GeneticCode genCode = new GeneticCode("genCode");
        Lab lab = new Lab(genCode);
        virologist.move(lab);
    }

    private void stepsOnFieldTest() {
        System.out.println("Virologist steps on Field");
        Virologist virologist = new Virologist();
        Field field = new Field();
        virologist.move(field);
    }

    private void stealsNucleotideTest() {
        System.out.println("Virologist steals Nucleotide");
        Virologist virologist = new Virologist();
        Virologist target = new Virologist();
        Nucleotide nucleo = new Nucleotide();
        virologist.stealResources(target, nucleo);
    }

    private void stealsGlovesTest() {
        System.out.println("Virologist steals Glove");
        Virologist virologist = new Virologist();
        Virologist virologistTarget = new Virologist();
        virologist.getField().getVirologists().add(virologistTarget);
        Gloves gloves = new Gloves();
        virologist.stealEquipment(virologistTarget, gloves);
    }

    private void stealsCapeTest() {
        System.out.println("Virologist steals Cape");
        Virologist virologist = new Virologist();
        Virologist target = new Virologist();
        Cape cape =new Cape();
        virologist.stealEquipment(target, cape);
    }

    private void stealsBagTest() {
        System.out.println("Virologist steals Bag");
        Virologist virologist = new Virologist();
        Virologist target = new Virologist();
        Bag bag = new Bag();
        virologist.stealEquipment(target, bag);
    }

    private void stealsAminoAcidTest() {
        System.out.println("Virologist steals AminoAcid");
        Virologist virologist = new Virologist();
        Virologist target = new Virologist();
        AminoAcid amino = new AminoAcid();
        virologist.stealResources(target, amino);
    }

    private void picksUpNucleotideTest() {
        System.out.println("Virologist picks up Nucleotide");
        Virologist v=new Virologist();
        AminoAcid a=new AminoAcid();
        Nucleotide n=new Nucleotide();
        Storage s=new Storage(a,n);
        v.getField().addNeighbour(s);
        v.move(s);
    }

    private void picksUpGlovesTest() {
        System.out.println("Virologist picks up Glove");
        Virologist v=new Virologist();
        Gloves g=new Gloves();
        v.pickUpEquipment(g);
    }

    private void picksUpCapeTest() {
        System.out.println("Virologist picks up Cape");
        Virologist v=new Virologist();
        Cape g=new Cape();
        v.pickUpEquipment(g);
    }

    private void picksUpBagTest() {
        System.out.println("Virologist picks up Bag");
        Virologist v=new Virologist();
        Bag g=new Bag();
        v.pickUpEquipment(g);
    }

    private void picksUpAminoAcidTest() {
        Virologist v=new Virologist();
        AminoAcid a=new AminoAcid();
        Nucleotide n=new Nucleotide();
        Storage s=new Storage(a,n);
        v.getField().addNeighbour(s);
        v.move(s);
    }

    private void losesNucleotideTest() {
        System.out.println("Virologist loses Nucleotide");
        Virologist virologist = new Virologist();
        Nucleotide nucleo = new Nucleotide();
        virologist.loseResources(nucleo);
    }

    private void losesGlovesTest() {
        System.out.println("Virologist loses Gloves");
        Virologist v=new Virologist();
        Gloves g=new Gloves();
        v.loseEquipment(g);
    }

    private void losesCapeTest() {
        System.out.println("Virologist loses Cape");
        Virologist v=new Virologist();
        Cape g=new Cape();
        v.loseEquipment(g);
    }

    private void losesAminoAcidTest() {
        System.out.println("Virologist loses AminoAcid");
        Virologist virologist = new Virologist();
        AminoAcid amino =  new AminoAcid();
        virologist.loseResources(amino);
    }

    private void losesBagTest() {
        System.out.println("Virologist loses Bag");
        Virologist v=new Virologist();
        Bag g=new Bag();
        v.loseEquipment(g);
    }

    private void craftsParalyzerTest() {
        System.out.println("Virologist crafts Paralyzer");
        Virologist v=new Virologist();
        Paralyzer g=new Paralyzer(v,10,10,10,10,"a");
        v.craftAgent(g);
    }

    private void craftsInvulnerableTest() {
        System.out.println("Virologist crafts Invulnerable");
        Virologist v=new Virologist();
        Invulnerable g=new Invulnerable(v,10,10,10,10,"a");
        v.craftAgent(g);
    }

    public void craftsAmenesiaTest(){
        System.out.println("Virologist crafts Amnesia");
        Virologist v=new Virologist();
        Amnesia g=new Amnesia(v,10,10,10,10,"a");
        v.craftAgent(g);
    }
    private void craftsVitusdanceTest() {
        System.out.println("Virologist crafts Vitusdance");
        Virologist v=new Virologist();
        Vitusdance g=new Vitusdance(v,10,10,10,10,"a");
        v.craftAgent(g);
    }
}
