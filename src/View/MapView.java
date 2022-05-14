package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MapView extends JPanel {
    /**
     * Polygonok listája amik a mezőket jelképezik majd vizuálisan.
     */
    private ArrayList<Polygon> polygons = new ArrayList<>();
    private boolean firstRepaint=false;
    private ArrayList<Color> c=new ArrayList<>();
    private Integer viroPositions[]=new Integer[8];

    public MapView() {
        this.setPreferredSize(new Dimension(800,800));
        for (int i = 0; i < 8; i++) {
            int[] x = {i * 100, (i + 1) * 100, (i + 1) * 100, i * 100};
            for (int j = 0; j < 8; j++) {
                int[] y = {j * 100, j * 100, (j + 1) * 100, (j + 1) * 100};
                polygons.add(new Polygon(x, y, 4));
            }
        }
        for (int i = 0; i < 8; i++) {
            viroPositions[i]=-1;
        }
    }

    public ArrayList<Polygon> getPolygons() {
        return polygons;
    }

    public void addC(Color c) {
        this.c.add(c);
    }
    public void addViroPos(int whichViro,int fieldIdx) {
        viroPositions[whichViro]=fieldIdx;
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
        for(int i=0;i<viroPositions.length;i++){
            if (viroPositions[i]!=-1) {
                try {
                    int x=0;
                    int y=0;
                    for(int j=0;j<polygons.get(viroPositions[i]).npoints;j++){
                        x+=polygons.get(viroPositions[i]).xpoints[j];
                        y+=polygons.get(viroPositions[i]).ypoints[j];
                    }
                    x/=polygons.get(viroPositions[i]).npoints;
                    y/=polygons.get(viroPositions[i]).npoints;

                    Image bufferedImage = (ImageIO.read(new File("src/img/virologist_" + (i + 1) + ".png"))).getScaledInstance(32,32,Image.SCALE_DEFAULT);
                    g.drawImage(bufferedImage, x-bufferedImage.getWidth(null)/2, y-bufferedImage.getHeight(null)/2, null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
