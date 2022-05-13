package View;

import main.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
        game.getMap().getFields().forEach(f->f.mustDraw(view,game.getMap().getFields().indexOf(f)));
        game.getMap().generateVirologists(numberOfViros);
        view.paintMap();
    }
}
