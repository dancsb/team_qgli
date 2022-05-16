package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Ez az osztály ugrik be ha valaki nyert a játékban
 */
public class EndGamePanel extends JPanel {
    /**
     * A nyertes virológus (vagy medvék) képe
     */
    private Image virologistImage;
    /**
     * Az Winner feliratos kép
     */
    private Image winnerImage;

    public EndGamePanel(int currentVirologist){
        this.setPreferredSize(new Dimension(800,500));

        if(currentVirologist==-1){
            try {
                virologistImage = (ImageIO.read(new File("src/img/bear.png"))).getScaledInstance(384,384,Image.SCALE_DEFAULT);
                winnerImage =  (ImageIO.read(new File("src/img/winner.png"))).getScaledInstance(400,160,Image.SCALE_DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                virologistImage = (ImageIO.read(new File("src/img/virologist_" + (currentVirologist + 1) + ".png"))).getScaledInstance(384, 384, Image.SCALE_DEFAULT);
                winnerImage = (ImageIO.read(new File("src/img/winner.png"))).getScaledInstance(400, 160, Image.SCALE_DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(virologistImage,208,120,null);
        g.drawImage(winnerImage, 200,10, null);
    }
}
