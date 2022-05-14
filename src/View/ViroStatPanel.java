package View;

import javax.swing.*;
import java.awt.*;

public class ViroStatPanel extends JPanel {
    private JTextArea viroStat = new JTextArea(10,50);
    private String stats;

    public ViroStatPanel() {
        Font font = new Font("ViroStat", Font.BOLD, 15);
        this.viroStat.setEditable(false);
        this.viroStat.setVisible(true);
        viroStat.setFont(font);
        this.setBackground(Color.WHITE);
        this.add(viroStat);
    }

    public void showViroStat(){
        this.viroStat.setText(stats);
    }

    public void setStats(String values){
        stats = values;
    }
}
