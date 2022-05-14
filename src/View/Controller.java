package View;

import main.Game;
import main.map.Field;
import main.virologist.Virologist;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;

public class Controller implements MouseListener{
    private View view;
    private Game game;
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
            view.getViroStatView().setCurrentVirImage((ImageIO.read(new File("src/img/virologist_" +(currentVirologist+1)+ ".png"))).getScaledInstance(256,256,Image.SCALE_DEFAULT));
            view.getViroStatView().paintComponent(view.getViroStatView().getGraphics());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(SwingUtilities.isLeftMouseButton(e)){
            for(Polygon p:view.getMapView().getPolygons()){
                if(p.contains(new Point(e.getX(),e.getY())))destField=view.getMapView().getPolygons().indexOf(p);
            }
            if(game.getViros().get(currentVirologist).getField().getNeighbours().contains(game.getMap().getFields().get(destField))&&!game.getViros().get(currentVirologist).isBearDance()){
                game.getViros().get(currentVirologist).move(game.getMap().getFields().get(destField));
                game.getViros().get(currentVirologist).mustDraw(view,game.getMap().getFields().indexOf(game.getViros().get(currentVirologist).getField()));
                currentVirologist++;
                if(currentVirologist==numberOfViros)currentVirologist=0;
            }
            while(game.getViros().get(currentVirologist).isBearDance()){
                game.getViros().get(currentVirologist).step();
                game.getViros().get(currentVirologist).mustDraw(view,game.getMap().getFields().indexOf(game.getViros().get(currentVirologist).getField()));
                currentVirologist++;
                if(currentVirologist==numberOfViros){
                    currentVirologist=0;
                    break;
                }
            }
            try {
                view.getViroStatView().setCurrentVirImage((ImageIO.read(new File("src/img/virologist_" +(currentVirologist+1)+ ".png"))).getScaledInstance(256,256,Image.SCALE_DEFAULT));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            view.getViroStatView().paintComponent(view.getViroStatView().getGraphics());
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
