package skeleton;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Skeleton {

    int selectedUseCase;
    GeneticCode gc = new GeneticCode("genCode");
    Virologist virologist = new Virologist();
    Virologist target = new Virologist();
    AminoAcid amino = new AminoAcid();
    Nucleotide nucleo = new Nucleotide();
    Gloves gloves = new Gloves();
    Cape cape = new Cape();
    Bag bag = new Bag();
    Field field = new Field();
    Lab lab = new Lab(gc);
    Shelter shelter = new Shelter(bag);
    Storage storage = new Storage(amino, nucleo);
    Invulnerable invulnerable = new Invulnerable(virologist, 10,10 ,10, 10,"genCode");
    Vitusdance vitusdance = new Vitusdance(virologist,10,10,10,10,"genCode");
    Amnesia amnesia = new Amnesia(virologist, 10 , 10, 10,10, "genCode");
    Paralyzer paralyzer = new Paralyzer(virologist,10,10,10,10,"genCode");

    public Skeleton(){}

    public void runTests() {
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
        System.out.println();
        System.out.println("Ird be a megfelelo szamot:");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            String selectedUseCase = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

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
                default:
                throw new IllegalStateException("Ervenytelen szam: " + selectedUseCase);
        }
    }
    private void usesVitusdanceTest(){
        virologist.useAgent(vitusdance, target);
    }

    private void usesParalyzerTest() {
        virologist.useAgent(paralyzer, target);
    }

    private void usesInvulnerableTest() {
        virologist.useAgent(invulnerable, target);
    }

    private void usesAmnesiaTest() {
        virologist.useAgent(amnesia, target);
    }


    private void stepsOnStorageTest() {
        virologist.move(storage);
    }

    private void stepsOnShelterTest() {
        virologist.move(shelter);
    }

    private void stepsOnLabTest() {
        virologist.move(lab);
    }

    private void stepsOnFieldTest() {
        virologist.move(field);
    }

    private void stealsNucleotideTest() {
        virologist.stealResources(nucleo);
    }

    private void stealsGlovesTest() {
        virologist.stealEquipment(gloves);
    }

    private void stealsCapeTest() {
        virologist.stealEquipment(cape);
    }

    private void stealsBagTest() {
        virologist.stealEquipment(bag);
    }

    private void stealsAminoAcidTest() {
        virologist.stealResources(amino);
    }

    private void picksUpNucleotideTest() {
        virologist.pickUpResource(nucleo);
    }

    private void picksUpGlovesTest() {
        virologist.pickUpEquipment(gloves);
    }

    private void picksUpCapeTest() {
        virologist.pickUpEquipment(cape);
    }

    private void picksUpBagTest() {
        virologist.pickUpEquipment(bag);
    }

    private void picksUpAminoAcidTest() {
        virologist.pickUpResource(amino);
    }

    private void losesNucleotideTest() {
        virologist.loseResources(nucleo);
    }

    private void losesGlovesTest() {
        virologist.loseEquipment(gloves);
    }

    private void losesCapeTest() {
        virologist.loseEquipment(cape);
    }

    private void losesAminoAcidTest() {
        virologist.loseResources(amino);
    }

    private void losesBagTest() {
        virologist.loseEquipment(bag);
    }

    private void craftsParalyzerTest() {
        boolean canCraft = virologist.craftAgent(paralyzer);
    }

    private void craftsInvulnerableTest() {
        boolean canCraft = virologist.craftAgent(invulnerable);
    }

    public void craftsAmenesiaTest(){
        boolean canCraft = virologist.craftAgent(amnesia);
    }
    private void craftsVitusdanceTest() {
        boolean canCraft = virologist.craftAgent(vitusdance);
    }
}
