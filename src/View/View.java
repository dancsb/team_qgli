package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JFrame {
    private MapView mapView = new MapView();

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.GREEN);
        g.fillPolygon(this.getMapView().getPolygons().get(0));
        this.invalidate();
        this.validate();
        this.repaint();
    }

    public void drawVirologist(){

    }
    public void drawBear(){

    }

    public void drawField(int idx){
      //  this.getGraphics().setColor(Color.GREEN);
       // this.getGraphics().fillPolygon(mapView.getPolygons().get(idx));
      //  SwingUtilities.updateComponentTreeUI(this);
        //this.repaint();
    }
    public void drawLab(int idx){
     /*   this.getMapView().getGraphics().setColor(Color.BLUE);
        this.getMapView().getGraphics().fillPolygon(mapView.getPolygons().get(idx));
        this.invalidate();
        this.validate();*/
    }
    public void drawShelter(int idx){
       /* this.getMapView().getGraphics().setColor(new Color(205,133,63));
        this.getMapView().getGraphics().fillPolygon(mapView.getPolygons().get(idx));
        this.invalidate();
        this.validate();*/
    }
    public void drawStorage(int idx) {
       /* this.getMapView().getGraphics().setColor(Color.YELLOW);
        this.getGraphics().fillPolygon(mapView.getPolygons().get(idx));
        this.invalidate();
        this.validate();*/
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
