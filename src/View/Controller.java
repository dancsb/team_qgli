package View;

import main.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controller {
    private View view;
    private Game game;

    public Controller(View v, Game g) {
        view = v;
        game = g;
        game.getMap().getFields().forEach(f->f.mustDraw(view,game.getMap().getFields().indexOf(f)));
    }
}
