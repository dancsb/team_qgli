package View;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private MapView mapView = new MapView();
    private StartView startView = new StartView();
    private ViroImagePanel viroImagePanel = new ViroImagePanel();
    private ViroStatPanel viroStatPanel = new ViroStatPanel();

    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(startView, BorderLayout.CENTER);
        this.pack();
        this.setResizable(true);
        this.setVisible(true);
    }

    public void startGame() {
        this.remove(startView);
        this.setLayout(new BorderLayout());
        this.add(mapView,BorderLayout.LINE_START);
        JSplitPane sl = new JSplitPane(SwingConstants.HORIZONTAL, viroImagePanel, viroStatPanel);
        sl.setEnabled(false);
        this.add(sl);
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
}
