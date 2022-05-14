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
    private Integer bearPositions[]=new Integer[8];

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
            bearPositions[i]=-1;
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

    public void addBearPos(int whichBear,int fieldIdx) {
        viroPositions[whichBear]=-1;
        bearPositions[whichBear]=fieldIdx;
    }

    private void paintPicture(int idx,String pic, Graphics g) throws IOException {
        int x=0;
        int y=0;
        for(int j=0;j<polygons.get(viroPositions[idx]).npoints;j++){
            x+=polygons.get(viroPositions[idx]).xpoints[j];
            y+=polygons.get(viroPositions[idx]).ypoints[j];
        }
        x/=polygons.get(viroPositions[idx]).npoints;
        y/=polygons.get(viroPositions[idx]).npoints;

        Image bufferedImage = (ImageIO.read(new File(pic))).getScaledInstance(32,32,Image.SCALE_DEFAULT);
        g.drawImage(bufferedImage, x-bufferedImage.getWidth(null)/2, y-bufferedImage.getHeight(null)/2, null);
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
                    paintPicture(i,"src/img/virologist_" + (i + 1) + ".png",g);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for(int i=0;i<bearPositions.length;i++){
            if (bearPositions[i]!=-1) {
                try {
                    paintPicture(i,"src/img/bear.png",g);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
