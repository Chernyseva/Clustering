import javax.swing.*;
import java.awt.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Field extends JPanel {
    int x, y, w, h;
    int n;
    String col_;

    public void ololo(int n) {
        this.n = n;
        x = 70;
        y = 100;
        w = n * 5;
        h = 40;

    }


    public void paint(Graphics g) {
        g.drawRect(x, y, w, h);
        int xl;
        int hl = h;
        for (int i = 0; i < n; i++) {
            xl = x + i * 5;
            if (i % 10 == 0) {
                hl = h + 20;
                g.drawString(Integer.valueOf(i).toString(), xl, y + hl + 30);
            }
            g.drawLine(xl, y, xl, y + hl);
            hl = h;
        }
    }

    public void borders(Graphics g,ArrayList<Integer> borders){
        g.setColor(new Color(91,0,24));
        int xl;
        for (int i : borders){
            xl = x + (i-1)*5;
            g.drawLine(xl,y,xl,y-50);
        }
    }
    public void fill(Graphics g, ArrayList<ArrayList<Double>> arrs) {
        int t = 0;
        Map<Integer,Color> map = new HashMap<>();
        map.put(0,Color.cyan);
        map.put(1,Color.MAGENTA);
        map.put(2,Color.ORANGE);
        map.put(3,Color.green);
        map.put(4,Color.PINK);
        map.put(5,Color.BLUE);
        map.put(6,Color.red);
        map.put(7,Color.YELLOW);
        map.put(8,new Color(49,3,66));
        map.put(9,new Color(65,94,0));
        for (ArrayList<Double> i : arrs) {
            Color newColor = map.get(t);
            System.out.println(newColor);
            g.setColor(newColor);
            for (double b : i) {
                System.out.print(x + b * 5 + 1 + " ");
                g.fillRect((int) (x + b * 5 + 1), y, 4, 40);
            }
            System.out.println();
            t++;
        }
        g.setColor(Color.black);
        g.drawRect(x, y, w, h);
        int xl;
        int hl = h;
        for (int i = 0; i < n; i++) {
            xl = x + i * 5;
            if (i % 10 == 0) {
                hl = h + 20;
                g.drawString(Integer.valueOf(i).toString(), xl, y + hl + 30);
            }
            g.drawLine(xl, y, xl, y + hl);
            hl = h;
        }
    }
}

