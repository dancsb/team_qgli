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
import java.util.Comparator;

public class Controller implements MouseListener{
    private View view;
    private Game game;
    private String viroStatString;
    private int numberOfViros;
    private int destField=-1;
    private int currentVirologist=0;
    private boolean moved = false;

    private int command;

    public Controller(View v, Game g) {
        view = v;
        game = g;
        v.getMapView().addMouseListener(this);
        view.getCraftParalyzed().addActionListener(new AgentCrafter());
        view.getCraftInvulnerable().addActionListener(new AgentCrafter());
        view.getCraftAmnesia().addActionListener(new AgentCrafter());
        view.getCraftVitusdance().addActionListener(new AgentCrafter());
        view.getEndTurnButton().addActionListener(new EndTurnListener());
        view.getUseAgentMenu().addActionListener(new UseAgentListener());
        view.getStealEquipmentMenu().addActionListener(new StealEquipmentListener());
        view.getStealResourceMenu().addActionListener(new StealResourceListener());
    }

    public void startGame(int viros) {
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

    private void exceptionHandling(DieException ex){
        if(game.getViros().get(currentVirologist)==ex.getVirologist())
            currentVirologist--;
        game.getViros().remove(ex.getVirologist());
        numberOfViros--;
        ex.getVirologist().mustDraw(view,-1);
    }

    private void resetWindow(){
        try {
            view.getViroImagePanel().setCurrentVirImage((ImageIO.read(new File("src/img/virologist_" +(game.getViros().get(currentVirologist).getViroID()+1)+ ".png"))).getScaledInstance(256,256,Image.SCALE_DEFAULT));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        view.getViroImagePanel().paintComponent(view.getViroImagePanel().getGraphics());

        viroStatString = game.getViros().get(currentVirologist).toString();
        view.getViroStatPanel().setStats(viroStatString);

        view.paintMap();
    }

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

    @Override
    public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {

        }
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

    public class EndTurnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(moved) {
                currentVirologist++;
                if (currentVirologist >= numberOfViros) currentVirologist = 0;

                medveSteps();
                resetWindow();
                moved = false;
            }
        }
    }

    public class UseAgentListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Integer> viroIDs = fillViroIDs();
            ArrayList<Agent> agents = game.getViros().get(currentVirologist).getAgents();
            ArrayList<String> agentNames = new ArrayList<>();
            agents.forEach(agent->agentNames.add(agent.getRequireGenCode()));

            view.setChooseView(new ChooseView(viroIDs, agentNames, true));
            ArrayList<JButton> virosButtons = view.getChooseView().getVirosButtons();
            for (JButton j:
                    virosButtons) {
                j.addActionListener(new ChooseViroListener(virosButtons, view.getChooseView().getComboBox()));
            }
            command=0;
        }
    }

    private class StealEquipmentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Integer> viroIDs = fillViroIDs();
            ArrayList<Equipment> equipments = game.getViros().get(currentVirologist).getEquipments();
            ArrayList<String> equipmentNames = new ArrayList<>();
            equipments.forEach(eq->equipmentNames.add(eq.getName()));
            // TODO: 2022. 05. 15. a comboboxot frissiteni, ha megnyomunk egy virologusgombot es neki lekerdezni a cuccait 
            view.setChooseView(new ChooseView(viroIDs, equipmentNames, true));
            ArrayList<JButton> virosButtons = view.getChooseView().getVirosButtons();
            for (JButton j:
                    virosButtons) {
                j.addActionListener(new ChooseViroListener(virosButtons, view.getChooseView().getComboBox()));
            }
            command=1;
        }

    }

    private class StealResourceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Integer> viroIDs = fillViroIDs();

            view.setChooseView(new ChooseView(viroIDs, null, false));
            ArrayList<JButton> virosButtons = view.getChooseView().getVirosButtons();
            for (JButton j:
                    virosButtons) {
                j.addActionListener(new ChooseViroListener(virosButtons, null));
            }
            command=2;
        }
    }

    private ArrayList<Integer> fillViroIDs() {
        ArrayList<Integer> viroIDs = new ArrayList<>();
        for(Virologist v:game.getViros().get(currentVirologist).getField().getVirologists())
            viroIDs.add(v.getViroID());
        viroIDs.sort(Integer::compare);
        return viroIDs;
    }

    private class ChooseViroListener implements ActionListener{
        private final ArrayList<JButton> viroButtons;
        private final JComboBox<String> options;

        public ChooseViroListener(ArrayList<JButton> jButtons, JComboBox<String> options){
            viroButtons=jButtons;
            this.options = options;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Virologist target = game.getViros().get(viroButtons.indexOf(e.getSource()));
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
                    break;
                }
                case 1:{

                    attacker.stealEquipment(target,new Axe());
                    break;
                }
                case 2:{
                    attacker.stealResources(target,target.getResources().get(0));
                    attacker.stealResources(target,target.getResources().get(1));
                    break;
                }
            }
            view.getChooseView().setVisible(false);
        }
    }
}
