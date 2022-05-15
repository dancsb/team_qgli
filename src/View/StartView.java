package View;

import main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StartView extends JPanel {
    private JButton start ;
    private String[]options={"2 virologists","3 virologists","4 virologists","5 virologists","6 virologists","7 virologists","8 virologists"};
    private JComboBox numberOfViros=new JComboBox(options);

    public StartView(){
        this.setPreferredSize(new Dimension(600,600));
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridwidth = GridBagConstraints.REMAINDER;
        gbc1.insets = new Insets(20, 0, 20, 0);

        JPanel polyFun = new JPanel();
        polyFun.setPreferredSize(new Dimension(400, 165));
        polyFun.setLayout(new BorderLayout());

        JPanel polyFunRadios = new JPanel();
        polyFunRadios.setLayout(new GridBagLayout());

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.gridheight = GridBagConstraints.REMAINDER;
        gbc2.insets = new Insets(0, 90, 0, 90);

        class PolyFunPictures extends JPanel {
            Image square = null;
            Image polygon = null;

            PolyFunPictures() {
                try {
                    square = (ImageIO.read(new File("src/img/square.png")));
                    polygon = (ImageIO.read(new File("src/img/polygon.png")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void paintComponent(Graphics g) {
                g.drawImage(square, 25, 0, null);
                g.drawImage(polygon, 225, 0, null);
            }
        }

        PolyFunPictures polyFunPictures = new PolyFunPictures();

        ButtonGroup bg = new ButtonGroup();
        JRadioButton rb1 = new JRadioButton();
        JRadioButton rb2 = new JRadioButton();
        bg.add(rb1);
        bg.add(rb2);
        polyFunRadios.add(rb1, gbc2);
        polyFunRadios.add(rb2, gbc2);
        rb1.setSelected(true);

        polyFun.add(polyFunPictures, BorderLayout.CENTER);
        polyFun.add(polyFunRadios, BorderLayout.SOUTH);
        this.add(polyFun, gbc1);

        numberOfViros.setPreferredSize(new Dimension(270, 20));
        this.add(numberOfViros,gbc1);

        Icon icon = new ImageIcon("src/img/startbutton.png");
        start = new JButton(icon);
        start.setBorderPainted(false);
        start.setContentAreaFilled(false);
        this.add(start,gbc1);

        start.addActionListener(e -> Main.getController().startGame(numberOfViros.getSelectedIndex() + 2,rb2.isSelected()));
    }
}
