package View;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private MapView mapView = new MapView();


    public View() {
        //this.setSize(new Dimension(600,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(mapView, BorderLayout.CENTER);
        this.pack();
        this.setResizable(false);
        this.setVisible(true);

    }

    public MapView getMapView() {
        return mapView;
    }

    public void drawVirologist(){

    }
    public void drawBear(){

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

    public void update(){

    }

}
