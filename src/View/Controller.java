package View;

import main.Game;

public class Controller {
    private View view;
    private Game game;

    public Controller(View v, Game g) {
        view = v;
        game = g;
    }
}
