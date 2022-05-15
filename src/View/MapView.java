package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class MapView extends JPanel {
    /**
     * Polygonok listája amik a mezőket jelképezik majd vizuálisan.
     */
    private ArrayList<Polygon> polygons = new ArrayList<>();
    private ArrayList<int[]> polyLabel = new ArrayList<>();
    private boolean firstRepaint=false;
    private ArrayList<Color> c=new ArrayList<>();
    private Integer[] viroPositions =new Integer[8];
    private Integer[] bearPositions =new Integer[8];
    private boolean epicPolygons=false;

    public MapView(boolean epicPolygons) {
        this.setPreferredSize(new Dimension(800,800));
        //Négyzetes pálya
        for (int i = 0; i < 8; i++) {
            int[] x = {i * 100, (i + 1) * 100, (i + 1) * 100, i * 100};
            for (int j = 0; j < 8; j++) {
                int[] y = {j * 100, j * 100, (j + 1) * 100, (j + 1) * 100};
                polygons.add(new Polygon(x, y, 4));
            }
        }
        //Polygonos pálya
        if(epicPolygons){
            polygons=MapGen.genMap(new Dimension(800,800));
        }


        for (Polygon p: polygons)
            polyLabel.add(getCenter(p));
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

    private void paintPicture(int pos, String pic, Graphics g) throws IOException {
        Image bufferedImage = (ImageIO.read(new File(pic))).getScaledInstance(32,32,Image.SCALE_DEFAULT);
        int[] position = getCenter(polygons.get(pos));
        g.drawImage(bufferedImage, position[0]-bufferedImage.getWidth(null)/2, position[1]-bufferedImage.getHeight(null)/2, null);
    }

    private int[] getCenter(Polygon polygon) {
        int[] temp = new int[2];
        Rectangle rect = polygon.getBounds();
        float maxTav = 0;

        for (int y = rect.y; y < rect.y + rect.height; y++) {
            for (int x = rect.x; x < rect.x + rect.width; x++) {
                if (polygon.contains(x, y)) {
                    ArrayList<Float> oldalaktolTav = new ArrayList<>();
                    for (int i = 0; i < polygon.npoints; i++)
                        oldalaktolTav.add(pEsVonalTav(x, y, polygon.xpoints[i], polygon.ypoints[i], polygon.xpoints[(i + 1) % polygon.npoints], polygon.ypoints[(i + 1) % polygon.npoints]));
                    Collections.sort(oldalaktolTav);
                    if (oldalaktolTav.get(0) > maxTav) {
                        temp[0] = x;
                        temp[1] = y;
                        maxTav = oldalaktolTav.get(0);
                    }
                }
            }
        }
        return temp;
    }

    public static float pEsVonalTav(float x, float y, float x1, float y1, float x2, float y2) {

        float t1 = -(y2 - y1);
        float t2 = x2 - x1;

        float dot = (x - x1) * t1 + (y - y1) * t2;
        float len_sq = t1 * t1 + t2 * t2;

        return (float) (Math.abs(dot) / Math.sqrt(len_sq));
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
                    int pos=viroPositions[i];
                    paintPicture(pos,"src/img/virologist_" + (i + 1) + ".png",g);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for(int i=0;i<bearPositions.length;i++){
            if (bearPositions[i]!=-1) {
                try {
                    int pos=bearPositions[i];
                    paintPicture(pos,"src/img/bear.png",g);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setEpicPolygons(boolean epicPolygons) {
        this.epicPolygons = epicPolygons;
    }
}
