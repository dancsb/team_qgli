package View;

import javax.swing.*;
import java.awt.*;

/**
 * A virológus státuszának panelje
 */
public class ViroStatPanel extends JPanel {
    /**
     * Virológus státuszát megjelenítő textarea
     */
    private JTextArea viroStat = new JTextArea(10,50);

    /**
     * Konstruktor
     */
    public ViroStatPanel() {
        Font font = new Font("ViroStat", Font.BOLD, 15);
        this.viroStat.setEditable(false);
        this.viroStat.setVisible(true);
        viroStat.setFont(font);
        this.setBackground(Color.WHITE);
        this.add(viroStat);
    }

    /**
     *
     * @param values, amivé beállítjuk a "textarea értékét
     */
    public void setStats(String values){
        this.viroStat.setText(values);
    }
}
