package View;

import main.Game;
import main.items.agents.Amnesia;
import main.items.agents.Invulnerable;
import main.items.agents.Paralyzer;
import main.items.agents.Vitusdance;
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


    public Controller(View v, Game g) {
        view = v;
        game = g;
        v.getMapView().addMouseListener(this);
        view.getCraftParalyzed().addActionListener(new AgentCrafter());
        view.getCraftInvulnerable().addActionListener(new AgentCrafter());
        view.getCraftAmnesia().addActionListener(new AgentCrafter());
        view.getCraftVitusdance().addActionListener(new AgentCrafter());
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
        if(game.getViros().get(currentVirologist)==ex.getVirologist()){
            currentVirologist--;
        }
        game.getViros().remove(ex.getVirologist());
        numberOfViros--;
        ex.getVirologist().mustDraw(view,-1);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
            ArrayList<Virologist> virologists = game.getViros();
            for(Polygon p:view.getMapView().getPolygons()){
                if(p.contains(new Point(e.getX(),e.getY())))destField=view.getMapView().getPolygons().indexOf(p);
            }
            if(virologists.get(currentVirologist).getField().getNeighbours().contains(game.getMap().getFields().get(destField))&&!virologists.get(currentVirologist).isBearDance()){
                try {
                    virologists.get(currentVirologist).step();
                    virologists.get(currentVirologist).move(game.getMap().getFields().get(destField));
                } catch (DieException ex) {
                    exceptionHandling(ex);
                }
                virologists.get(currentVirologist).mustDraw(view,game.getMap().getFields().indexOf(virologists.get(currentVirologist).getField()));
                if(virologists.get(currentVirologist).checkWin()){view.endGame(currentVirologist);return;}
                currentVirologist++;
                if(currentVirologist>=numberOfViros)currentVirologist=0;
            }
            //GABÓ ???? ez mi a halál??? azt bágod h ez mindig true és fölösleges????? @Jeges
            boolean mindmedve = false;
            while(virologists.get(currentVirologist).isBearDance() && !mindmedve){
                try {
                    virologists.get(currentVirologist).step();
                } catch (DieException ex) {
                    exceptionHandling(ex);
                }
                virologists.get(currentVirologist).mustDraw(view,game.getMap().getFields().indexOf(virologists.get(currentVirologist).getField()));
                //if(virologists.get(currentVirologist).checkWin()){view.endGame(currentVirologist);return;}
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
            }
            try {
                view.getViroImagePanel().setCurrentVirImage((ImageIO.read(new File("src/img/virologist_" +(virologists.get(currentVirologist).getViroID()+1)+ ".png"))).getScaledInstance(256,256,Image.SCALE_DEFAULT));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            view.getViroImagePanel().paintComponent(view.getViroImagePanel().getGraphics());

            viroStatString = virologists.get(currentVirologist).toString();
            view.getViroStatPanel().setStats(viroStatString);


            view.paintMap();
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
        }
    }
}
