package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UseAgentView extends JFrame {

    private ArrayList<JButton>virosButtons=new ArrayList<>();
    //private ArrayList<Integer>viroIDs=new ArrayList<>();
    private JComboBox agentList=new JComboBox();

    public UseAgentView(ArrayList<Integer>viroIDs) {
        this.setSize(new Dimension(600,400));
        this.setResizable(false);
        this.setLayout(new GridLayout());
        for(int i=0;i<viroIDs.size();i++){
            try {
                virosButtons.add(new JButton());
                virosButtons.get(i).setIcon(new ImageIcon((ImageIO.read(new File("src/img/virologist_" +(viroIDs.get(i)+1)+ ".png"))).getScaledInstance(128,128,Image.SCALE_DEFAULT)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.add(virosButtons.get(i));
        }
        //this.add(agentList);
        this.setVisible(true);
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);

    }
    public void addViroId(int id){
        //viroIDs.add(id);
        virosButtons.add(new JButton());
    }
    public ArrayList<JButton> getVirosButtons() {
        return virosButtons;
    }

    public ArrayList<Integer> getViroIDs() {
        return null;
    }

    public JComboBox getAgentList() {
        return agentList;
    }
}
