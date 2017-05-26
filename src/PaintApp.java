import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class PaintApp extends JFrame {

    public PaintApp() {
        setTitle("Кластеризация");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1024, 768);
        setBackground(Color.white);
        setResizable(false);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        Field f = new Field();
        f.ololo(133);
        f.paint(g);

        f.fill(g, ClustersReader.getSubTrees());

        f.borders(g, ClustersReader.getBorders());
        g.setColor(Color.white);
    }

    public static void main(String[] args) {
        new PaintApp();
    }

}

