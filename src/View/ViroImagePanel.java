package View;

import javax.swing.*;
import java.awt.*;

public class ViroImagePanel extends JPanel {
    private Image currentVirImage;

    public ViroImagePanel() {
        this.setPreferredSize(new Dimension(400,400));
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(currentVirImage,175,72,null);
    }

    public void setCurrentVirImage(Image currentVirImage) {
        this.currentVirImage = currentVirImage;
    }
}
