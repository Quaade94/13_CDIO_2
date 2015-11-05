package Game;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class GUI implements ActionListener {
	//Overfører alt texten
	Language X = new Language();
	Die Roll = new Die();
	Game_board Board = new Game_board();
	Player Player = new Player();

	//laver variables
	private int P1_points = 1000;
	private int P2_points = 1000;
	private int player_switch = 0;
	private JLabel P1_label = new JLabel(X.lang()[0] + P1_points);
	private JLabel P2_label = new JLabel(X.lang()[1] + P2_points);;
	private JLabel player_turn = new JLabel(X.lang()[2], SwingConstants.CENTER);
	//private JLabel map_title = new JLabel(X.lang()[6]);
	private JLabel player1_map = new JLabel(X.lang()[7]);
	private JLabel player2_map = new JLabel(X.lang()[8]);
	private JLabel roll_msg = new JLabel(X.lang()[9]);
	private JLabel message = new JLabel(X.lang()[13]);
	private JFrame frame = new JFrame();
	private JLabel player1 = new JLabel(X.lang()[26]);
	private JLabel player2 = new JLabel(X.lang()[27]);
	private JPanel panel3 = new JPanel();
	private JButton button = new JButton(X.lang()[4]);

	
	
	
	
	public GUI() {

		// knappen
		button.addActionListener(this);

		
		//label customization
		player_turn.setFont(new Font("Sherif", Font.PLAIN, 20));
		player1.setFont(new Font("Sherif", Font.PLAIN, 20));
		player2.setFont(new Font("Sherif", Font.PLAIN, 20));
		
		
		
		//container panel
		JPanel container = new JPanel();
		JPanel container2 = new JPanel();

		//panel med text
		JPanel pointPanel = new JPanel();
		pointPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		pointPanel.setLayout(new GridLayout(0,1));
		pointPanel.add(player1);
		pointPanel.add(P1_label);
		pointPanel.add(player1_map);
		pointPanel.setBackground(Color.lightGray);

		// panel med map??
		JPanel mappanel = new JPanel();
		mappanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		mappanel.setLayout(new GridLayout(0,1));
		mappanel.add(player2);
		mappanel.add(P2_label);
		mappanel.add(player2_map);
		mappanel.setBackground(Color.lightGray);

		//placere text og map ved siden af hinanden
		container.setLayout(new GridLayout(1,2));
		container.add(pointPanel);
		container.add(mappanel);

		//panel med knap
		panel3.add(player_turn);
		panel3.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel3.setLayout(new GridLayout(1,2));
		panel3.add(button);
		panel3.add(roll_msg);
		//panel3.add(button);
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
	public void actionPerformed(ActionEvent F) {
						
		if (player_switch == 0) {
			int[] roll = Roll.Roll();

			Player.setPlayerPlace(true, roll[2]);
			Player.setPlayerScorre(true);

			//        	Denne her skal have en ny kasse Sebastian ;)
			// 			J_LableStuffs: ((X.lang()[10] + Player.getPlayerPlace(true));)

			P1_label.setText(X.lang()[0] + Player.getPlayerScorre(true));
			roll_msg.setText(X.lang()[9] + roll[0] + " and " + roll[1]);
			
			
			
			if(Player.getPlayerScorre(true)>2999){
				message.setFont(new Font("Sherif", Font.PLAIN, 35));
				message.setText(X.lang()[28]);
				player_turn.setText("");
				button.setEnabled(false);
				return;
				
			}
			
			else if(Board.getFieldEffect(Player.getPlayerPlace(true))>=0){
				message.setText(X.lang()[10] + Board.getFieldName(Player.getPlayerPlace(true)) + X.lang()[11]  + " " + Board.getFieldEffect(Player.getPlayerPlace(true))+ " " + X.lang()[25]);	
			}
			else if(Board.getFieldEffect(Player.getPlayerPlace(true))<0){
				message.setText(X.lang()[10] + Board.getFieldName(Player.getPlayerPlace(true)) + X.lang()[12]  + " " + Math.abs(Board.getFieldEffect(Player.getPlayerPlace(true))) + " " + X.lang()[25]);	
			}
			player1_map.setText(X.lang()[7] + Player.getPlayerPlace(true)+". "+ Board.getFieldName(Player.getPlayerPlace(true)));

			if (Player.getPlayerPlace(false)==9){
				player_turn.setText(X.lang()[2]);
				player_switch = 0;
						}
			else {
				player_turn.setText(X.lang()[3]);
				player_switch = 1;
			}

		} else if (player_switch == 1) {
			int[] roll = Roll.Roll();

			Player.setPlayerPlace(false, roll[2]);
			Player.setPlayerScorre(false);

			//    		Denne her skal have en ny kasse Sebastian ;)
			//			J_LableStuffs: ((X.lang()[10] + Player.getPlayerPlace(false));)

			P2_label.setText(X.lang()[1] + Player.getPlayerScorre(false));
			roll_msg.setText(X.lang()[9] + roll[0] + " and " + roll[1]);
			
			
			if (Player.getPlayerScorre(false)>2999){
				message.setFont(new Font("Sherif", Font.PLAIN, 35));
				message.setText(X.lang()[29]);
				player_turn.setText("");
				button.setEnabled(false);
				return;
			}
			
			else if(Board.getFieldEffect(Player.getPlayerPlace(false))>=0){
				message.setText(X.lang()[10] + Board.getFieldName(Player.getPlayerPlace(false)) + X.lang()[11]  + " " + Board.getFieldEffect(Player.getPlayerPlace(false)) + " " + X.lang()[25]);	
			}
			else if(Board.getFieldEffect(Player.getPlayerPlace(false))<0){
				message.setText(X.lang()[10] + Board.getFieldName(Player.getPlayerPlace(false)) + X.lang()[12]  + " " + Math.abs(Board.getFieldEffect(Player.getPlayerPlace(false))) + " " + X.lang()[25]);	
			}    			player2_map.setText(X.lang()[8]+Player.getPlayerPlace(false)+". "+ Board.getFieldName(Player.getPlayerPlace(false)));
				if (Player.getPlayerPlace(false)==9){
					player_turn.setText(X.lang()[3]);
					player_switch = 1;
							}
				else {
					player_turn.setText(X.lang()[2]);
					player_switch = 0;
				}
									
		} else {
			System.out.println("Fejl i spillerskift");
		}
	};





	// Viser GUI
	public static void main(String[] args) {
		new GUI();

	}
}