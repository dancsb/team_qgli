package View;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private MapView mapView;
    private Color c;
    private int currentIndex;

    public View() {
        //this.setSize(new Dimension(600,600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        mapView = new MapView();
        this.add(mapView, BorderLayout.CENTER);
        this.pack();
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
        c = Color.GREEN;
        currentIndex = idx;
        paintComponents(this.getGraphics());
    }
    public void drawLab(int idx){
        c = Color.BLUE;
        currentIndex = idx;
        paintComponents(this.getGraphics());
    }
    public void drawShelter(int idx){
        c = new Color(205,133,63);
        currentIndex = idx;
        paintComponents(this.getGraphics());
    }
    public void drawStorage(int idx) {
        c = Color.YELLOW;
        currentIndex = idx;
        paintComponents(this.getGraphics());
    }
    public void update(){

    }
    @Override
    public void paintComponents(Graphics g) {
        g.drawPolygon(mapView.getPolygons().get(currentIndex));
        g.setColor(c);
        g.fillPolygon(mapView.getPolygons().get(currentIndex));
    }
}
