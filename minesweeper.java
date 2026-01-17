import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class minesweeper {
    public static void main(String[] args) {
        minesweeperFrame frame = new minesweeperFrame();
        frame.show();
    }
}

class minesweeperFrame extends JFrame {
    public minesweeperFrame() {
        setTitle("Minesweeper");
        setSize(600, 665);
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JComboBox difficulty = new JComboBox(new String[] {"Easy", "Normal", "Hard"});
        panel.add(difficulty);
        panel.add(new JLabel("Time:"));

        JLabel time = new JLabel("0:00");
        panel.add(time);

        add(panel, "North");

        minesweeperPanel game = new minesweeperPanel();
        add(game);
    }
}

class minesweeperPanel extends JPanel {
    int[][] arr = new int[10][10];
    
    public minesweeperPanel() {
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if((e.getModifiers() & MouseEvent.BUTTON1_MASK) != 0) {
                    arr[(int) Math.floor(e.getX() / 60)][(int) Math.floor(e.getY() / 60)] = 1;
                    repaint();
                }
            }
        });
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(arr[i][j] == 0) {
                    g2.setPaint(new Color(62, 163, 70));
                } else {
                    g2.setPaint(new Color(242, 203, 97));
                }
                g2.fill(new Rectangle2D.Double(i * 60, j * 60, 60, 60));
                g2.setPaint(g2.getColor().darker());
                g2.draw(new Rectangle2D.Double(i * 60, j * 60, 60, 60));
            }
        }
    }
}