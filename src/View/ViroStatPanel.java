package View;

import javax.swing.*;
import java.awt.*;

public class ViroStatPanel extends JPanel {
    private JTextArea viroStat = new JTextArea();
    private String stats;

    public ViroStatPanel() {
        this.viroStat.setEditable(false);
        this.viroStat.setVisible(true);
        this.add(viroStat);
    }

    public void showViroStat(){
        this.viroStat.setText(stats);
    }

    public void setStats(String values){
        stats = values;
    }
}
