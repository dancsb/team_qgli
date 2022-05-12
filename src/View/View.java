package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame {
    private MapView mapView = new MapView();
    public void drawVirologist(){

    }
    public void drawBear(){

    }
    public void drawField(){

    }
    public void drawLab(){

    }
    public void drawShelter(){

    }
    public void drawStorage() {

    }
    public void update(){

    }

    public View() {
        this.setSize(new Dimension(600,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout());
        this.add(mapView);
        pack();
        this.setVisible(true);
    }

    public MapView getMapView() {
        return mapView;
    }
}
