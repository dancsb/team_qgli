package View;

import main.Main;

import javax.swing.*;
import java.awt.*;

public class StartView extends JPanel {
    private JButton start =new JButton("Start");
    private String[]options={"2","3","4","5","6","7","8"};
    private JComboBox numberOfViros=new JComboBox(options);

    public StartView(){
        this.setPreferredSize(new Dimension(600,600));
        this.setLayout(new BorderLayout());
        this.add(start,BorderLayout.CENTER);
        this.add(numberOfViros,BorderLayout.SOUTH);
        start.addActionListener(e -> Main.getController().startGame(numberOfViros.getSelectedIndex() + 2));
    }
}
