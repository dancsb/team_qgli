package View;

import main.Game;
import main.map.Field;
import main.virologist.DieException;
import main.virologist.Virologist;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
            view.getViroStatPanel().showViroStat();
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
                    virologists.get(currentVirologist).move(game.getMap().getFields().get(destField));
                } catch (DieException ex) {
                    exceptionHandling(ex);
                }
                virologists.get(currentVirologist).mustDraw(view,game.getMap().getFields().indexOf(virologists.get(currentVirologist).getField()));
                if(virologists.get(currentVirologist).checkWin()){view.endGame(currentVirologist);return;}
                currentVirologist++;
                if(currentVirologist>=numberOfViros)currentVirologist=0;
            }
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
            view.getViroStatPanel().showViroStat();


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
}
