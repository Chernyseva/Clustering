import javax.swing.*;
import java.awt.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ring extends JPanel {
    int x_,y_,w_,h_;
    String col_;
    public void ololo(int x, int y, int w, int h) {
        x_=x;
        y_=y;
        w_=w;
        h_=h;

    }
    public void paint(Graphics g) {
        g.setColor (Color.blue);
        g.drawOval(x_,y_,w_,h_);
        g.fillOval (x_,y_,w_,h_);

        g.setColor (Color.white);
        g.drawOval(x_+10,y_+10,w_-20,h_-20);
        g.fillOval(x_+10,y_+10,w_-20,h_-20);
    }
}
