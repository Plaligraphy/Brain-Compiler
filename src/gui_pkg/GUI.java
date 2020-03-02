package gui_pkg;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class GUI {
    public void init() {
        createFrame(400,400,0,"Test");
    }
    private void createFrame(int x, int y, int opt, String title) {
        JFrame f = new JFrame(title);
        JPanel m = new JPanel(new BorderLayout());
        JPanel n = new JPanel();m.add(n,BorderLayout.NORTH);
        JPanel s = new JPanel();m.add(s,BorderLayout.SOUTH);
        JPanel c = new JPanel();m.add(c,BorderLayout.CENTER);
        switch(opt) {
            case 0:
                JLabel title_ = new JLabel("title");

                c.add(title_);
                break;
            case 1:
                break;
        }
        f.add(m);
        f.setSize(x,y);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }
}
