package View;

import javax.swing.*;
import java.awt.*;

/**
 * Grafikus részeket összefogó osztály
 */
public class View extends JFrame {
    private MapView mapView = new MapView(false);
    private StartView startView = new StartView();
    private ChooseView chooseView;
    private ViroImagePanel viroImagePanel = new ViroImagePanel();
    private ViroStatPanel viroStatPanel = new ViroStatPanel();
    private JSplitPane jSplitPane;
    private EndGamePanel endGamePanel;
    private JMenuBar menuBar = new JMenuBar();
    private JMenuItem craftAmnesia = new JMenuItem("Amnesia");
    private JMenuItem craftInvulnerable = new JMenuItem("Invulnerable");
    private JMenuItem craftParalyzed = new JMenuItem("Paralyzed");
    private JMenuItem craftVitusdance = new JMenuItem("Vitusdance");
    private JButton endTurnButton = new JButton("END TURN");
    private JButton useAgentMenu = new JButton("Use Agent");
    private JButton stealEquipmentMenu = new JButton("Steal Equipment");
    private JButton stealResourceMenu = new JButton("Steal Resource");

    /**
     * Konstruktor
     */
    public View() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.add(startView, BorderLayout.CENTER);
        this.pack();
        this.setResizable(false);
        this.setTitle("Medve Futam");
        this.setVisible(true);
    }

    /**
     * Játék kezdetekor megjelenő rész
     */
    public void startGame() {
        this.remove(startView);
        this.setLayout(new BorderLayout());
        this.add(mapView, BorderLayout.CENTER);
        jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, viroImagePanel, viroStatPanel);
        jSplitPane.setEnabled(false);
        this.add(jSplitPane, BorderLayout.EAST);

        //menu item hozzaadas
        JMenu craftMenu = new JMenu("Craft");

        useAgentMenu.setBorder(BorderFactory.createEmptyBorder());
        stealEquipmentMenu.setBorder(BorderFactory.createEmptyBorder());
        stealResourceMenu.setBorder(BorderFactory.createEmptyBorder());
        endTurnButton.setBorder(BorderFactory.createEmptyBorder());
        menuBar.setBackground(Color.WHITE);
        endTurnButton.setBackground(Color.WHITE);
        useAgentMenu.setBackground(Color.WHITE);
        stealEquipmentMenu.setBackground(Color.WHITE);
        stealResourceMenu.setBackground(Color.WHITE);
        craftMenu.add(craftAmnesia);
        craftMenu.add(craftInvulnerable);
        craftMenu.add(craftParalyzed);
        craftMenu.add(craftVitusdance);
        menuBar.add(craftMenu);
        menuBar.add(useAgentMenu);
        menuBar.add( Box.createHorizontalStrut( 10 ) );
        menuBar.add(stealEquipmentMenu);
        menuBar.add( Box.createHorizontalStrut( 10 ) );
        menuBar.add(stealResourceMenu);
        menuBar.add( Box.createHorizontalStrut( 10 ) );
        menuBar.add(endTurnButton);
        this.add(menuBar, BorderLayout.NORTH);
        this.pack();
        this.setResizable(false);
    }

    /**
     * Játék befejezéséhez szolgáló rész
     * @param currentVirologist nyertes virológus
     */
    public void endGame(int currentVirologist){
        endGamePanel = new EndGamePanel(currentVirologist);
        this.remove(mapView);
        this.remove(jSplitPane);
        this.remove(menuBar);
        this.setLayout(new BorderLayout());
        this.add(endGamePanel);
        this.pack();
        this.setResizable(false);
    }

    public MapView getMapView() {
        return mapView;
    }

    /**
     * Kirajzol egy virológust
     * @param whichViro virológus indexe
     * @param fieldIdx virológus mezőpoziciója
     */
    public void drawVirologist(int whichViro,int fieldIdx){
        mapView.addViroPos(whichViro,fieldIdx);
    }

    /**
     * Kirajzol egy medvét
     * @param whichBear medve indexe
     * @param fieldIdx medvemezőpoziciója
     */
    public void drawBear(int whichBear, int fieldIdx){
        mapView.addBearPos(whichBear,fieldIdx);
    }

    /**
     * Zöld színnel megjeleníti az általános mezőt
     */
    public void drawField(){
        mapView.addC(Color.GREEN);
    }

    /**
     * Kék színnel megjeleníti a labort
     */
    public void drawLab(){
        mapView.addC(Color.BLUE);
    }

    /**
     * Barna színnel megjeleníti az óvóhelyet
     */
    public void drawShelter(){
        mapView.addC(new Color(205,133,63));
    }

    /**
     * Sárga színnel megjeleníti a raktárat
     */
    public void drawStorage() {
        mapView.addC(Color.YELLOW);
    }

    /**
     * Újrarajzolja a pályát
     */
    public void paintMap() {
        mapView.repaint();
    }

    public ViroImagePanel getViroImagePanel() {
        return viroImagePanel;
    }

    public ViroStatPanel getViroStatPanel(){return viroStatPanel;}

    public JMenuItem getCraftAmnesia(){return craftAmnesia;}

    public JMenuItem getCraftInvulnerable() {
        return craftInvulnerable;
    }

    public JMenuItem getCraftParalyzed() {
        return craftParalyzed;
    }

    public JMenuItem getCraftVitusdance() {
        return craftVitusdance;
    }

    public JButton getEndTurnButton(){ return endTurnButton; }

    public JButton getUseAgentMenu() {
        return useAgentMenu;
    }

    public JButton getStealEquipmentMenu() {
        return stealEquipmentMenu;
    }

    public JButton getStealResourceMenu() {
        return stealResourceMenu;
    }

    public void setChooseView(ChooseView chooseView) {
        this.chooseView = chooseView;
    }

    public ChooseView getChooseView() {
        return chooseView;
    }

    public void genMapView(boolean poly){
        mapView=new MapView(poly);
    }
}

