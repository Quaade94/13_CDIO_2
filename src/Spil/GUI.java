package Spil;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class GUI implements ActionListener {
	//Overfører alt texten
	Language X = new Language();
	Terninger Roll = new Terninger();
	Spilleplade Board = new Spilleplade();
	Spiller Player = new Spiller();
	
	//laver variables
    private int P1_points = 1000;
    private int P2_points = 1000;
    private int player_switch = 0;
    private JLabel P1_label = new JLabel(X.lang()[0] + P1_points, SwingConstants.CENTER);
    private JLabel P2_label = new JLabel(X.lang()[1] + P2_points, SwingConstants.CENTER);;
    private JLabel player_turn = new JLabel(X.lang()[2], SwingConstants.CENTER);
    private JLabel map_title = new JLabel(X.lang()[6]);
    private JLabel player1_map = new JLabel(X.lang()[7]);
    private JLabel player2_map = new JLabel(X.lang()[8]);
    private JLabel roll_msg = new JLabel(X.lang()[9]);
    private JLabel message = new JLabel(X.lang()[13]);
    private JFrame frame = new JFrame();

    public GUI() {
    	
        // knappen
        JButton button = new JButton(X.lang()[4]);
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
        panel3.setLayout(new GridLayout(0,1));
        panel3.add(roll_msg);
        panel3.add(button);
        panel3.setBackground(Color.lightGray);
        
        //panel med meddelelse
        JPanel message_panel = new JPanel();
        message_panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        message_panel.setLayout(new GridBagLayout());
        message_panel.add(message);
       	message_panel.setBackground(Color.lightGray);
        
        //placere knap under text og map
        container2.setLayout(new GridLayout(0,1));
        container2.add(container);
        container2.add(message_panel);
        container2.add(panel3);
        
        // s�tter rammen op
        frame.add(container2, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(X.lang()[5]);
        frame.setSize(600, 400);
        frame.setResizable(false);
        //frame.pack();
        frame.setVisible(true);
    }

    // Hvad sker der, naar knappen bliver trykket:
//    public void actionPerformed(ActionEvent F) {
//    	int[] roll = Roll.Roll();
//        if (player_switch == 0) {
//            P1_points = P1_points + roll[2]; //skal vaere spillers totale points
//            P1_label.setText(X.lang()[0] + P1_points);
//            player_turn.setText(X.lang()[3]);
//            roll_msg.setText(X.lang()[9] + roll[0] + " and " + roll[1]);
//        	player_switch = 1;
//        } else if (player_switch == 1) {
//            P2_points = P2_points + roll[2]; //Not actual points plz mk plair cls
//            P2_label.setText(X.lang()[1] + P2_points);
//            player_turn.setText(X.lang()[2]);
//            roll_msg.setText(X.lang()[9] + roll[0] + " and " + roll[1]);
//        	player_switch = 0;
//        }
//    };

    // Hvad sker der, naar knappen bliver trykket:
    public void actionPerformed(ActionEvent F) {

        if (player_switch == 0) {
        	int[] roll = Roll.Roll();
        	
        		Player.setPlayerPlace(true, roll[2]);
        		Player.setPlayerScorre(true);
        		
//        	Denne her skal have en ny kasse Sebastian ;)
// 			J_LableStuffs: ((X.lang()[10] + Player.getPlayerPlace(true));)
        	
            P1_label.setText(X.lang()[0] + Player.getPlayerScorre(true));
            player_turn.setText(X.lang()[3]);
            roll_msg.setText(X.lang()[9] + roll[0] + " and " + roll[1]);
            if(Board.getFeltEffekt(Player.getPlayerPlace(true))>=0){
            message.setText(X.lang()[10] + Player.getPlayerPlace(true) + X.lang()[11]  + " " + Board.getFeltEffekt(Player.getPlayerPlace(true)));	
            }
            else if(Board.getFeltEffekt(Player.getPlayerPlace(true))<0){
            message.setText(X.lang()[10] + Player.getPlayerPlace(true) + X.lang()[12]  + " " + Board.getFeltEffekt(Player.getPlayerPlace(true)));	
            }
            player1_map.setText(X.lang()[7]+Player.getPlayerPlace(true)+". "+Board.getFeltNavn(Player.getPlayerPlace(true)));
            
            player_switch = 1;
             
        } else if (player_switch == 1) {
        	int[] roll = Roll.Roll();
        	
    			Player.setPlayerPlace(false, roll[2]);
    			Player.setPlayerScorre(false);
    		
//    		Denne her skal have en ny kasse Sebastian ;)
//			J_LableStuffs: ((X.lang()[10] + Player.getPlayerPlace(false));)

    			P2_label.setText(X.lang()[1] + Player.getPlayerScorre(false));
    			player_turn.setText(X.lang()[2]);
    			roll_msg.setText(X.lang()[9] + roll[0] + " and " + roll[1]);
    			if(Board.getFeltEffekt(Player.getPlayerPlace(true))>=0){
    	            message.setText(X.lang()[10] + Player.getPlayerPlace(true) + X.lang()[11]  + " " + Board.getFeltEffekt(Player.getPlayerPlace(true)));	
    	            }
    	            else if(Board.getFeltEffekt(Player.getPlayerPlace(true))<0){
    	            message.setText(X.lang()[10] + Player.getPlayerPlace(true) + X.lang()[12]  + " " + Board.getFeltEffekt(Player.getPlayerPlace(true)));	
    	            }    			player2_map.setText(X.lang()[8]+Player.getPlayerPlace(false)+". "+Board.getFeltNavn(Player.getPlayerPlace(false)));
    			player_switch = 0;
        } else {
        	System.out.println("Fejl i spillerskift");
        }
    };
    
    
    
    
    
    // Viser GUI
    public static void main(String[] args) {
        new GUI();
        
    }
}