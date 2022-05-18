package View;

import main.Game;
import main.items.agents.*;
import main.items.collectibles.Axe;
import main.items.collectibles.Equipment;
import main.map.Field;
import main.virologist.DieException;
import main.virologist.Virologist;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * A logikát és a kinézetet kontrolláló osztály
 */
public class Controller implements MouseListener{
    /**
     * A kinézet
     */
    private View view;
    /**
     * A logika
     */
    private Game game;
    /**
     * Az adott virológus statjai
     */
    private String viroStatString;
    /**
     * a virológusok száma
     */
    private int numberOfViros;
    /**
     * A field ahová lépni szeretne a felhasználó
     */
    private int destField=-1;
    /**
     * A virológus akinek a köre jön
     */
    private int currentVirologist=0;
    /**
     * A virológus lépett-e már
     */
    private boolean moved = false;
    /**
     * A virológus lopott-e már
     */
    private boolean stole = false;
    /**
     * A virológus használt-e ágenst már
     */
    private boolean used = false;

    private int command;

    public Controller(View v, Game g) {
        view = v;
        game = g;
        view.getCraftParalyzed().addActionListener(new AgentCrafter());
        view.getCraftInvulnerable().addActionListener(new AgentCrafter());
        view.getCraftAmnesia().addActionListener(new AgentCrafter());
        view.getCraftVitusdance().addActionListener(new AgentCrafter());
        view.getEndTurnButton().addActionListener(new EndTurnListener());
        view.getUseAgentMenu().addActionListener(new UseAgentListener());
        view.getStealEquipmentMenu().addActionListener(new StealEquipmentListener());
        view.getStealResourceMenu().addActionListener(new StealResourceListener());
    }

    /**
     * A játékot indító függvény
     * @param viros a virológusok száma
     * @param polygon polygon map legyen-e
     */
    public void startGame(int viros,boolean polygon) {
        view.genMapView(polygon);
        game.generateMap(view.getMapView().getPolygons());
        view.getMapView().addMouseListener(this);
        numberOfViros = viros;
        game.getMap().generateVirologists(numberOfViros);
        view.startGame();
        for(Field f:game.getMap().getFields()){
            if(f.getVirologists().size()>0){
                for(Virologist v:f.getVirologists()){
                    game.getViros().add(v);
                }
            }
        }
        game.getViros().sort(Comparator.comparingInt(Virologist::getViroID));
        for (Field f:
             game.getMap().getFields()) {
            int idx = game.getMap().getFields().indexOf(f);
            f.mustDraw(view, idx);
        }
        view.paintMap();
        try {
            viroStatString = game.getViros().get(currentVirologist).toString();
            view.getViroStatPanel().setStats(viroStatString);
            view.getViroImagePanel().setCurrentVirImage((ImageIO.read(new File("src/img/virologist_" +(currentVirologist+1)+ ".png"))).getScaledInstance(256,256,Image.SCALE_DEFAULT));
            view.getViroImagePanel().paintComponent(view.getViroImagePanel().getGraphics());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ha meghal egy virológus ez kezeli le
     * @param ex egy DieException
     */
    private void exceptionHandling(DieException ex){
        if(game.getViros().get(currentVirologist)==ex.getVirologist())
            currentVirologist--;
        game.getViros().remove(ex.getVirologist());
        numberOfViros--;
        ex.getVirologist().mustDraw(view,-1);
    }

    /**
     * Újrarajzolja a windowt
     */
    private void resetWindow(){
        if(currentVirologist!=-1) {
            try {
                view.getViroImagePanel().setCurrentVirImage((ImageIO.read(new File("src/img/virologist_" + (game.getViros().get(currentVirologist).getViroID() + 1) + ".png"))).getScaledInstance(256, 256, Image.SCALE_DEFAULT));
            } catch (Exception ignored) {
            }
            view.getViroImagePanel().paintComponent(view.getViroImagePanel().getGraphics());

            viroStatString = game.getViros().get(currentVirologist).toString();
            view.getViroStatPanel().setStats(viroStatString);
        }

        view.paintMap();
    }

    /**
     * lépteti a medvéket
     */
    private void medveSteps(){
        ArrayList<Virologist> virologists = game.getViros();
        while(virologists.get(currentVirologist).isBearDance()){
            try {
                virologists.get(currentVirologist).step();
            } catch (DieException ex) {
                exceptionHandling(ex);
            }
            virologists.get(currentVirologist).mustDraw(view,game.getMap().getFields().indexOf(virologists.get(currentVirologist).getField()));
            currentVirologist++;
            if(currentVirologist>=numberOfViros){
                currentVirologist=0;
            }
            int medvek = 0;
            for (Virologist v:
                    virologists) {
                if (v.isBearDance()){
                    medvek++;
                }
            }
            if (medvek==virologists.size()) {
                currentVirologist=-1;
                view.endGame(currentVirologist);
                return;
            }
            moved = false;
        }
    }

    /**
     * Az egérkattintásra lejátszódó eseményeket tartalmazza
     * @param e egy MouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
            ArrayList<Virologist> virologists = game.getViros();
            for(Polygon p:view.getMapView().getPolygons()){
                if(p.contains(new Point(e.getX(),e.getY())))destField=view.getMapView().getPolygons().indexOf(p);
            }
            if(virologists.get(currentVirologist).getField().getNeighbours().contains(game.getMap().getFields().get(destField))
                    && !virologists.get(currentVirologist).isBearDance()
                    && !moved){
                try {
                    virologists.get(currentVirologist).step();
                    virologists.get(currentVirologist).move(game.getMap().getFields().get(destField));
                } catch (DieException ex) {
                    exceptionHandling(ex);
                }
                virologists.get(currentVirologist).mustDraw(view,game.getMap().getFields().indexOf(virologists.get(currentVirologist).getField()));
                if(virologists.get(currentVirologist).checkWin()){view.endGame(currentVirologist);return;}
                moved = true;
            }
            medveSteps();
            resetWindow();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Az ágenscraftoláshoz tartozó ActionListener
     */
    public class AgentCrafter implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == view.getCraftParalyzed()){
                game.getViros().get(currentVirologist).craftAgent(new Paralyzer(game.getViros().get(currentVirologist), 100,100, "paralyzer"));
            }
            if(e.getSource() == view.getCraftVitusdance()){
                game.getViros().get(currentVirologist).craftAgent(new Vitusdance(game.getViros().get(currentVirologist), 100,100, "vitusdance"));
            }
            if(e.getSource() == view.getCraftAmnesia()){
                game.getViros().get(currentVirologist).craftAgent(new Amnesia(game.getViros().get(currentVirologist), 100,100, "amnesia"));
            }
            if(e.getSource() == view.getCraftInvulnerable()){
                game.getViros().get(currentVirologist).craftAgent(new Invulnerable(game.getViros().get(currentVirologist), 100,100, "invulnerable"));
            }
            resetWindow();
        }
    }
    /**
     * A kör vége gombhoz tartozó ActionListener
     */
    public class EndTurnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(moved) {
                currentVirologist++;
                if (currentVirologist >= numberOfViros) currentVirologist = 0;

                medveSteps();
                resetWindow();
                while (game.getViros().get(currentVirologist).isParalyzed()){
                    try {
                        game.getViros().get(currentVirologist).step();
                    } catch (DieException ex) {
                        exceptionHandling(ex);
                    }
                    currentVirologist++;
                    if (currentVirologist >= numberOfViros) currentVirologist = 0;
                }
                resetWindow();
                moved = false;
                stole = false;
                used = false;
            }
        }
    }
    /**
     * Az ágenshasználathoz tartozó ActionListener
     */
    public class UseAgentListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!used) {
                ArrayList<Integer> viroIDs = fillViroIDs();
                ArrayList<Agent> agents = game.getViros().get(currentVirologist).getAgents();
                ArrayList<String> agentNames = new ArrayList<>();
                agents.forEach(agent -> agentNames.add(agent.getRequireGenCode()));

                view.setChooseView(new ChooseView(viroIDs, agentNames, true));
                ArrayList<JButton> virosButtons = view.getChooseView().getVirosButtons();
                for (JButton j :
                        virosButtons) {
                    j.addActionListener(new ChooseViroListener(virosButtons, viroIDs, view.getChooseView().getComboBox()));
                }
                command = 0;
            }
        }
    }
    /**
     * A felszereléslopáshoz tartozó ActionListener
     */
    private class StealEquipmentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(!stole) {
                ArrayList<Integer> viroIDs = fillViroIDs();
                viroIDs.remove(game.getViros().get(currentVirologist).getViroID());
                String[] names = {"axe", "bag", "cape", "gloves"};
                ArrayList<String> equipmentNames = new ArrayList<>(java.util.List.of(names));
                view.setChooseView(new ChooseView(viroIDs, equipmentNames, true));
                ArrayList<JButton> virosButtons = view.getChooseView().getVirosButtons();
                for (JButton j :
                        virosButtons) {
                    j.addActionListener(new ChooseViroListener(virosButtons, viroIDs, view.getChooseView().getComboBox()));
                }
                command = 1;
            }
        }

    }
    /**
     * Az anyaglopáshoz tartozó ActionListener
     */
    private class StealResourceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!stole) {
                ArrayList<Integer> viroIDs = fillViroIDs();
                viroIDs.remove(game.getViros().get(currentVirologist).getViroID());
                view.setChooseView(new ChooseView(viroIDs, null, false));
                ArrayList<JButton> virosButtons = view.getChooseView().getVirosButtons();
                for (JButton j :
                        virosButtons) {
                    j.addActionListener(new ChooseViroListener(virosButtons, viroIDs, null));
                }
                command = 2;
            }
        }
    }
    /**
     * Visszaad egy ArrayListet a soron következő virológus mezőin lévő virológusok azonosítóival
     */
    private ArrayList<Integer> fillViroIDs() {
        ArrayList<Integer> viroIDs = new ArrayList<>();
        for(Virologist v:game.getViros().get(currentVirologist).getField().getVirologists())
            viroIDs.add(v.getViroID());
        viroIDs.sort(Integer::compare);
        return viroIDs;
    }

    /**
     * Egy olyan ActionListener, ami a ChooseViewhoz tartozik és akkor szükséges
     * ha az egyik virológus valami akciót csinál magán/másik virológuson
     */
    private class ChooseViroListener implements ActionListener{
        private final ArrayList<JButton> viroButtons;
        private final ArrayList<Integer> viroIDs ;
        private final JComboBox<String> options;

        public ChooseViroListener(ArrayList<JButton> jButtons, ArrayList<Integer> viroIDs, JComboBox<String> options){
            viroButtons=jButtons;
            this.viroIDs = viroIDs;
            this.options = options;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Virologist target = game.getViros().get(viroIDs.get(viroButtons.indexOf(e.getSource())));
            Virologist attacker = game.getViros().get(currentVirologist);
            switch (command){
                case 0:{
                    String nev = (String) options.getSelectedItem();
                    Agent usethis=null;
                    for (Agent a:
                        attacker.getAgents()){
                        if (a.getRequireGenCode().equals(nev)){
                            usethis=a;
                            break;
                        }
                    }
                    if(usethis==null) return;
                    attacker.useAgent(target,usethis);
                    used=true;
                    break;
                }
                case 1:{
                    Equipment desiredEquipment=null;
                    for(Equipment equipment:target.getEquipments()){
                        if(equipment.getName().equals((String) options.getSelectedItem())){
                            desiredEquipment=equipment;
                        }
                    }
                    if(desiredEquipment!=null){
                        attacker.stealEquipment(target,desiredEquipment);
                        stole=true;
                    }
                    break;
                }
                case 2:{
                    attacker.stealResources(target,target.getResources().get(0));
                    attacker.stealResources(target,target.getResources().get(1));
                    stole=true;
                    break;
                }
            }
            view.getChooseView().setVisible(false);
            resetWindow();
        }
    }
}
