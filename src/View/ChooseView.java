package View;

import main.items.agents.Agent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ChooseView extends JFrame {

    private ArrayList<JButton>virosButtons=new ArrayList<>();
    private JComboBox agentList;

    public ChooseView(ArrayList<Integer>viroIDs, ArrayList<Agent>agents, boolean needComboBox) {
        JPanel p1 = new JPanel();

        this.setSize(new Dimension(600,400));
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        ArrayList<String>agentNames=new ArrayList<>();
        agents.forEach(x->agentNames.add(x.getRequireGenCode()));
        agentList=new JComboBox(agentNames.toArray());
        p1.setLayout(new GridLayout(2,4));
        viroIDs.add(1);
        viroIDs.add(2);
        viroIDs.add(3);
        viroIDs.add(4);
        viroIDs.add(5);
        viroIDs.add(6);
        viroIDs.add(7);
        for(int i=0;i<viroIDs.size();i++){
            try {
                virosButtons.add(new JButton());
                virosButtons.get(i).setIcon(new ImageIcon((ImageIO.read(new File("src/img/virologist_" +(viroIDs.get(i)+1)+ ".png"))).getScaledInstance(128,128,Image.SCALE_DEFAULT)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            p1.add(virosButtons.get(i));
        }
        this.add(p1, needComboBox ? BorderLayout.NORTH : BorderLayout.CENTER);
        if (needComboBox) {
            JPanel p2 = new JPanel();
            p2.add(agentList);
            this.add(p2,BorderLayout.SOUTH);
        }
        this.setVisible(true);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

    }
}
