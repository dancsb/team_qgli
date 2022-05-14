package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private MapView mapView = new MapView();
    private StartView startView = new StartView();
    private ViroImagePanel viroImagePanel = new ViroImagePanel();
    private ViroStatPanel viroStatPanel = new ViroStatPanel();
    private JSplitPane jSplitPane;
    private EndGamePanel endGamePanel;
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem craftAmnesia = new JMenuItem("Amnesia");
    private JMenuItem craftInvulnerable = new JMenuItem("Invulnerable");
    private JMenuItem craftParalyzed = new JMenuItem("Paralyzed");
    private JMenuItem craftVitusdance = new JMenuItem("Vitusdance");

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(startView, BorderLayout.CENTER);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    public void startGame() {
        this.remove(startView);
        this.setLayout(new BorderLayout());
        this.add(mapView, BorderLayout.CENTER);
        jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, viroImagePanel, viroStatPanel);
        jSplitPane.setEnabled(false);
        this.add(jSplitPane, BorderLayout.EAST);


        //menu item hozzaadas
        JMenu craftMenu = new JMenu("Craft");

        craftMenu.add(craftAmnesia);
        craftMenu.add(craftInvulnerable);
        craftMenu.add(craftParalyzed);
        craftMenu.add(craftVitusdance);

        menuBar.add(craftMenu);
        this.add(menuBar, BorderLayout.NORTH);

        this.pack();
        this.setResizable(false);
    }

    public void endGame(int currentVirologist){
        endGamePanel = new EndGamePanel(currentVirologist);
        this.remove(mapView);
        this.remove(jSplitPane);
        this.remove(menuBar);
        this.setLayout(new BorderLayout());
        this.add(endGamePanel);
        this.pack();
        this.setResizable(false);
    }

    public MapView getMapView() {
        return mapView;
    }

    public void drawVirologist(int whichViro,int fieldIdx){
        mapView.addViroPos(whichViro,fieldIdx);
    }
    public void drawBear(int whichBear, int fieldIdx){
        mapView.addBearPos(whichBear,fieldIdx);
    }

    public void drawField(int idx){
        mapView.addC(Color.GREEN);
    }
    public void drawLab(int idx){
        mapView.addC(Color.BLUE);
    }
    public void drawShelter(int idx){
        mapView.addC(new Color(205,133,63));
    }
    public void drawStorage(int idx) {
        mapView.addC(Color.YELLOW);
    }

    public void paintMap() {
        mapView.repaint();
    }

    public ViroImagePanel getViroImagePanel() {
        return viroImagePanel;
    }

    public ViroStatPanel getViroStatPanel(){return viroStatPanel;}

    public JMenuItem getCraftAmnesia(){return craftAmnesia;}

    public JMenuItem getCraftInvulnerable() {
        return craftInvulnerable;
    }

    public JMenuItem getCraftParalyzed() {
        return craftParalyzed;
    }

    public JMenuItem getCraftVitusdance() {
        return craftVitusdance;
    }
}

