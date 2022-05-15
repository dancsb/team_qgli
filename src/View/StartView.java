package View;

import main.Main;

import javax.swing.*;
import java.awt.*;

public class StartView extends JPanel {
    private JButton start ;
    private String[]options={"2 virologist","3 virologist","4 virologist","5 virologist","6 virologist","7 virologist","8 virologist"};
    private JComboBox numberOfViros=new JComboBox(options);

    public StartView(){
        this.setPreferredSize(new Dimension(600,600));
        this.setLayout(new BorderLayout());
        Icon icon = new ImageIcon("src/img/startbutton.png");
        start = new JButton(icon);
        start.setBackground(Color.WHITE);
        start.setBorderPainted(true);
        this.add(start,BorderLayout.CENTER);
        this.add(numberOfViros,BorderLayout.SOUTH);
        start.addActionListener(e -> Main.getController().startGame(numberOfViros.getSelectedIndex() + 2));
    }
}
