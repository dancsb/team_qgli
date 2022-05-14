package View;

import javax.swing.*;
import java.awt.*;

public class ViroImagePanel extends JPanel {
    private Image currentVirImage;

    public ViroImagePanel() {
        this.setPreferredSize(new Dimension(400,400));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(currentVirImage,72,72,null);
    }

    public void setCurrentVirImage(Image currentVirImage) {
        this.currentVirImage = currentVirImage;
    }
}
