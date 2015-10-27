package Spil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

public class GUI implements ActionListener {
	//laver variables
    private int P1_points = 0;
    private int P2_points = 0;
    private int player_switch = 0;
    private JLabel P1_label = new JLabel("Player 1 points: 0", SwingConstants.CENTER);
    private JLabel P2_label = new JLabel("Player 2 points: 0", SwingConstants.CENTER);;
    private JLabel player_turn = new JLabel("Player 1's turn!", SwingConstants.CENTER);
    private JLabel map_title = new JLabel("Spillerposition!");
    private JLabel player1_map = new JLabel("Spiller 1 position: 1");
    private JLabel player2_map = new JLabel("Spiller 2 position: 1");
    private JFrame frame = new JFrame();

    public GUI() {
    	
        // knappen
        JButton button = new JButton("Throw Dice!");
        button.addActionListener(this);

        //label customization
        player_turn.setFont(new Font("Sherif", Font.PLAIN, 20));
        map_title.setFont(new Font("Sherif", Font.PLAIN, 20));
        
        //container panel
        JPanel container = new JPanel();
        JPanel container2 = new JPanel();
        
        //panel med text
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.add(player_turn);
        panel.add(P1_label);
        panel.add(P2_label);
        panel.setBackground(Color.lightGray);
        
        // panel med map??
        JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel2.add(map_title);
        panel2.add(player1_map);
        panel2.add(player2_map);
        panel2.setBackground(Color.lightGray);
        
        //placere text og map ved siden af hinanden
        container.setLayout(new GridLayout(1,2));
        container.add(panel);
        container.add(panel2);
        
        //panel med knap
        JPanel panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel3.add(button);
        panel3.setBackground(Color.lightGray);
        
        //placere knap under text og map
        container2.setLayout(new GridLayout(0,1));
        container2.add(container);
        container2.add(panel3);
        
        // sætter rammen op
        frame.add(container2, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Terningespil");
        frame.setSize(450, 400);
        frame.setResizable(false);
        //frame.pack();
        frame.setVisible(true);
    }

    // Hvad sker der, når knappen bliver trykket:
    public void actionPerformed(ActionEvent e) {

        if (player_switch == 0) {
            P1_points++; //skal være spillers totale points
            P1_label.setText("Player 1 points:  " + P1_points);
            player_turn.setText("Player 2's turn!");
        	player_switch = 1;
        } else if (player_switch == 1) {
            P2_points++;
            P2_label.setText("Player 2 points:  " + P2_points);
            player_turn.setText("Player 1's turn!");
        	player_switch = 0;
        }
    };

    // Viser GUI
    public static void main(String[] args) {
        new GUI();
    }
}