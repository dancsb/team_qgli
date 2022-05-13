package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MapView extends JPanel {
    /**
     * Polygonok listája amik a mezőket jelképezik majd vizuálisan.
     */
    private ArrayList<Polygon> polygons = new ArrayList<>();
    private boolean firstRepaint=false;
    private ArrayList<Color> c=new ArrayList<>();
    private ArrayList<Integer>viroPositions=new ArrayList();

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

    public void addC(Color c) {
        this.c.add(c);
    }
    public void addViroPos(int whichViro,int fieldIdx) {
        if(whichViro<viroPositions.size()){
            viroPositions.remove(whichViro);
            viroPositions.add(whichViro,fieldIdx);
        }
        else viroPositions.add(fieldIdx);
    }

    public void paintComponent(Graphics g) {
        if(!firstRepaint){
            firstRepaint=true;
            this.setBackground(Color.WHITE);
        }
        for(int i=0;i<c.size();i++) {
            g.setColor(c.get(i));
            g.fillPolygon(polygons.get(i));
            g.setColor(Color.black);
            g.drawPolygon(polygons.get(i));
        }
        for(int i=0;i<viroPositions.size();i++){
            try {
                BufferedImage bufferedImage = ImageIO.read(new File("src/img/virologist_"+(i+1)+".png"));
                g.drawImage(bufferedImage,polygons.get(viroPositions.get(i)).xpoints[0],polygons.get(viroPositions.get(i)).ypoints[0],null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
