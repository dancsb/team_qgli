package View;

import main.Game;
import main.map.Field;
import main.virologist.Virologist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;

public class Controller {
    private View view;
    private Game game;
    private int numberOfViros;

    public Controller(View v, Game g) {
        view = v;
        game = g;
    }

    public void startGame(int viros) {
        numberOfViros = viros;
        view.startGame();
        game.getMap().generateVirologists(numberOfViros);
        for (Field f:
             game.getMap().getFields()) {
            int idx = game.getMap().getFields().indexOf(f);
            f.mustDraw(view, idx);
        }
        //game.getMap().getFields().forEach(f->{f.mustDraw(view,game.getMap().getFields().indexOf(f));});
        view.paintMap();
    }
}
