import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

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
        setSize(600, 615);
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
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        g2.setPaint(new Color(62, 163, 70));
        g2.fill(new Rectangle2D.Double(0, 15, 600, 600));
    }
}