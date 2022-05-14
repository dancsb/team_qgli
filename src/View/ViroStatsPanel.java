package View;

import javax.swing.*;
import java.awt.*;

public class ViroStatsPanel extends JPanel {
    private JTextArea viroID=new JTextArea();
    private Image currentVirImage;

    public ViroStatsPanel() {
        this.viroID.setText("Kismalac");
        this.setPreferredSize(new Dimension(300,800));
        this.setLayout(new BorderLayout());
        //this.viroID.setBounds(100,50,100,100);
       // this.add(viroID,BorderLayout.NORTH);
        this.viroID.setBounds(0,100,100,100);
        viroID.setEditable(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(currentVirImage,0,0,null);
    }

    public void setCurrentVirImage(Image currentVirImage) {
        this.currentVirImage = currentVirImage;
    }
}
