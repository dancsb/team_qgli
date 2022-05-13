package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MapView extends JPanel {
    /**
     * Polygonok listája amik a mezőket jelképezik majd vizuálisan.
     */
    private ArrayList<Polygon> polygons = new ArrayList<>();

    private Color c;
    private int currentIndex;

    public MapView() {
        this.setPreferredSize(new Dimension(600,600));
        for (int i = 0; i < 12; i++) {
            int[] x = {i * 50, (i + 1) * 50, (i + 1) * 50, i * 50};
            for (int j = 0; j < 12; j++) {
                int[] y = {j * 50, j * 50, (j + 1) * 50, (j + 1) * 50};
                polygons.add(new Polygon(x, y, 4));
            }
        }
    }

    public ArrayList<Polygon> getPolygons() {
        return polygons;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void paintComponent(Graphics g) {
        g.setColor(c);
        g.fillPolygon(polygons.get(currentIndex));
        g.setColor(Color.black);
        g.drawPolygon(polygons.get(currentIndex));
    }
}
