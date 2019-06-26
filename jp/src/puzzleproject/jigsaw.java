package puzzleproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class jigsaw extends JFrame {

    JButton b[] = new JButton[9];
    ImageIcon[] im = new ImageIcon[9];
    private ImageIcon i, i2, i3;
    JButton jb1, jb2, jb3, t;
    private ImageIcon[] im3 = new ImageIcon[9];
    GridLayout grid = new GridLayout(4, 4);

    jigsaw() {

        i3 = new ImageIcon(getClass().getResource("e6.PNG"));
        t = new JButton(i3);
        event e = new event();
        im3[0] = new ImageIcon(getClass().getResource("e1.png"));
        im3[1] = new ImageIcon(getClass().getResource("e1.png"));
        im3[2] = new ImageIcon(getClass().getResource("e2.png"));
        im3[3] = new ImageIcon(getClass().getResource("e3.png"));
        im3[4] = new ImageIcon(getClass().getResource("e3.png"));
        im3[5] = new ImageIcon(getClass().getResource("e2.png"));
        im3[6] = new ImageIcon(getClass().getResource("e4.png"));
        im3[7] = new ImageIcon(getClass().getResource("e4.png"));
        im3[8] = new ImageIcon(getClass().getResource("e5.png"));

        im[0] = new ImageIcon(getClass().getResource("e1.png"));
        im[1] = new ImageIcon(getClass().getResource("e5.png"));
        im[2] = new ImageIcon(getClass().getResource("e3.png"));
        im[3] = new ImageIcon(getClass().getResource("e4.png"));
        im[4] = new ImageIcon(getClass().getResource("e1.png"));
        im[5] = new ImageIcon(getClass().getResource("e2.png"));
        im[6] = new ImageIcon(getClass().getResource("e3.png"));
        im[7] = new ImageIcon(getClass().getResource("e4.png"));
        im[8] = new ImageIcon(getClass().getResource("e2.png"));
        i = new ImageIcon(getClass().getResource("e5.png"));
        setLayout(new GridLayout(4, 4));
        for (int i = 0; i < b.length; i++) {
            b[i] = new JButton(im[i]);
            b[i].addActionListener(e);
            add(b[i]);
        }
        jb1 = new JButton("Exit");
        add(jb1);
        jb3 = new JButton("Done");
        add(jb3);
        jb3.addActionListener(e);
        jb1.addActionListener(e);
        add(t);
    }

    public static void main(String[] args) {
        jigsaw obj = new jigsaw();
        obj.setSize(600, 600);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public class event implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            for (int in = 0; in < 9; in++) {
                if (e.getSource() == b[in]) {
                    if (in != 8 && in != 2 && in != 5) {
                        if (im[in + 1].getImage() == i.getImage()) {
                            replace(im[in], im[in + 1]);
                        }
                    }
                    if (in != 6 && in != 7 && in != 8) {
                        if (im[in + 3].getImage() == i.getImage()) {
                            replace(im[in], im[in + 3]);
                        }
                    }
                    if (in != 0 && in != 3 && in != 6) {
                        if (im[in - 1].getImage() == i.getImage()) {
                            replace(im[in], im[in - 1]);
                        }
                    }
                    if (in != 0 && in != 1 && in != 2) {
                        if (im[in - 3].getImage() == i.getImage()) {
                            replace(im[in], im[in - 3]);
                        }
                    }
                }
            }
            if (e.getSource() == jb3) {
                int count = 0;
                for (int i = 0; i < 9; i++) {
                    if (im[i].getImage() == im3[i].getImage()) {
                        count++;
                        if (count >= 8) {
                            Done obj = new Done();
                            obj.setVisible(true);
                            dispose();
                        }

                    }
                }

            }
            if (e.getSource() == jb1) {
                System.exit(0);
            }
        }
    }

    public void replace(ImageIcon ic0, ImageIcon ic1) {

        ic1.setImage(ic0.getImage());
        ic0.setImage(i.getImage());
    }
}
