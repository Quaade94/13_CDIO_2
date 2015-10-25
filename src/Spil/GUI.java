package Spil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    private int P1_points = 0;
    private int P2_points = 0;
    private JLabel P1_label = new JLabel("Player 1 points:  0     ");
    private JLabel P2_label = new JLabel("Player 2 points:  0     ");
    private JFrame frame = new JFrame();

    public GUI() {

        // knappen
        JButton button = new JButton("Throw Dice");
        button.addActionListener(this);

        // panel med text og knap
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(P1_label);
        panel.add(P2_label);
        panel.add(button);

        // sætter rammen op
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);
    }

    // Hvad sker der, når knappen bliver trykket:
    public void actionPerformed(ActionEvent e) {
        P1_points++;
        P1_label.setText("Player 1 points:  " + P1_points);
    };

    // Viser GUI
    public static void main(String[] args) {
        new GUI();
    }
}