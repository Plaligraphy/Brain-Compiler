package gui_pkg;
//GUI Portion of Evan's Brainfuck compiler (March 1st, 2020)
import javax.swing.*;
import java.awt.*;

public class GUI {
    pkg.FileHandler fh = new pkg.FileHandler();
    pkg.LogicHandler lh = new pkg.LogicHandler();

    public void init() {
        createFrame(400,400,0,"BrainFuck Compiler");
    }
    private void createFrame(int x, int y, int opt, String title) {
        JFrame f = new JFrame(title);
        JPanel m = new JPanel(new BorderLayout());
        JPanel n = new JPanel();m.add(n,BorderLayout.NORTH);
        JPanel s = new JPanel();m.add(s,BorderLayout.SOUTH);
        JPanel c = new JPanel();m.add(c,BorderLayout.CENTER);
        switch(opt) {
            case 0:
                JLabel title_ = new JLabel("BrainFuck Compiler");
                JLabel creator = new JLabel("by: Evan Carter");

                JButton exit = new JButton("Exit"); exit.addActionListener(e -> System.exit(0));
                creator.setFont(new Font("Times Roman", Font.PLAIN, 10));


                n.add(title_);
                n.add(creator);

                s.add(exit);
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







/// hows ashley buddy?