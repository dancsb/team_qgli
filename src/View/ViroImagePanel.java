package View;

import javax.swing.*;
import java.awt.*;

/**
 * A virológushoz tartozó képpanel, amelyen látszódik az aktív virológus képe.
 */
public class ViroImagePanel extends JPanel {
    /**
     * Aktív virológus képe
     */
    private Image currentVirImage;

    /**
     * Konstruktor
     */
    public ViroImagePanel() {
        this.setPreferredSize(new Dimension(400,400));
        this.setBackground(Color.WHITE);
    }

    /**
     * Képkirajzoló függvény
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(currentVirImage,175,72,null);
    }

    public void setCurrentVirImage(Image currentVirImage) {
        this.currentVirImage = currentVirImage;
    }
}
