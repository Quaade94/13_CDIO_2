package Game;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class GUI implements ActionListener {
	//OverfÃ¸rer alt texten
	Language lang = new Language();
	Die Roll = new Die();
	GameBoard Board = new GameBoard();
	Player Player = new Player();

	long before1;
	long before2;
	long after1;
	long after2;

	//laver variables
	private int p1Points = 1000;
	private int p2Points = 1000;
	private int playerSwitch = 0;
	private JLabel p1Point = new JLabel(lang.lang()[0] + p1Points);
	private JLabel p2Point = new JLabel(lang.lang()[1] + p2Points);;
	private JLabel playerTurn = new JLabel(lang.lang()[2], SwingConstants.CENTER);
	
	//private JLabel map_title = new JLabel(X.lang()[6]);
	private JLabel player1Map = new JLabel(lang.lang()[7]);
	private JLabel player2Map = new JLabel(lang.lang()[8]);
	private JLabel rollMsg = new JLabel(lang.lang()[9]);
	private JLabel message = new JLabel(lang.lang()[13]);
	private JFrame frame = new JFrame();
	private JLabel player1 = new JLabel(lang.lang()[26]);
	private JLabel player2 = new JLabel(lang.lang()[27]);
	private JPanel bottompanel = new JPanel();
	private JButton button = new JButton(lang.lang()[4]);

	public GUI() {

		// knappen
		button.addActionListener(this);

		//label customization
		playerTurn.setFont(new Font("Sherif", Font.PLAIN, 20));
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
		pointPanel.add(p1Point);
		pointPanel.add(player1Map);
		pointPanel.setBackground(Color.lightGray);

		// panel med map??
		JPanel mappanel = new JPanel();
		mappanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		mappanel.setLayout(new GridLayout(0,1));
		mappanel.add(player2);
		mappanel.add(p2Point);
		mappanel.add(player2Map);
		mappanel.setBackground(Color.lightGray);

		//placere text og map ved siden af hinanden
		container.setLayout(new GridLayout(1,2));
		container.add(pointPanel);
		container.add(mappanel);

		//panel med knap
		bottompanel.add(playerTurn);
		bottompanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		bottompanel.setLayout(new GridLayout(1,2));
		bottompanel.add(button);
		bottompanel.add(rollMsg);
		//panel3.add(button);
		bottompanel.setBackground(Color.lightGray);

		//panel med meddelelse
		JPanel messagePanel = new JPanel();
		messagePanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		messagePanel.setLayout(new GridBagLayout());
		messagePanel.add(message);
		messagePanel.setBackground(Color.lightGray);

		//placere knap under text og map
		container2.setLayout(new GridLayout(0,1));
		container2.add(container);
		container2.add(messagePanel);
		container2.add(bottompanel);

		// saetter rammen op
		frame.add(container2, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle(lang.lang()[5]);
		frame.setSize(600, 400);
		frame.setResizable(false);
		//frame.pack();
		frame.setVisible(true);
	}

	// Hvad sker der, naar knappen bliver trykket:
	
	public void actionPerformed(ActionEvent F) {
		
		
		
		if (playerSwitch == 0) {
			
			//reaktionstid på player 1
			before1 = System.currentTimeMillis();
			
			int[] roll = Roll.roll();

			Player.setPlayerPlace(true, roll[2]);
			Player.setPlayerScore(true);

			p1Point.setText(lang.lang()[0] + Player.getPlayerScore(true));
			rollMsg.setText(lang.lang()[9] + roll[0] + " and " + roll[1]);

			if(Player.getPlayerScore(true) >= 3000){
				message.setFont(new Font("Sherif", Font.PLAIN, 35));
				message.setText(lang.lang()[28]);
				playerTurn.setText("");
				button.setEnabled(false);
				return;

			}

			else if(Board.getFieldEffect(Player.getPlayerPlace(true))>=0){
				message.setText(lang.lang()[10] + Board.getFieldName(Player.getPlayerPlace(true)) + lang.lang()[11]  + " " + Board.getFieldEffect(Player.getPlayerPlace(true))+ " " + lang.lang()[25]);	
			}
			else if(Board.getFieldEffect(Player.getPlayerPlace(true))<0){
				message.setText(lang.lang()[10] + Board.getFieldName(Player.getPlayerPlace(true)) + lang.lang()[12]  + " " + Math.abs(Board.getFieldEffect(Player.getPlayerPlace(true))) + " " + lang.lang()[25]);	
			}
			player1Map.setText(lang.lang()[7] + Player.getPlayerPlace(true)+". "+ Board.getFieldName(Player.getPlayerPlace(true)));

			if (Player.getPlayerPlace(true)==9){
				playerTurn.setText(lang.lang()[2]);
				playerSwitch = 0;
			}
			else {
				playerTurn.setText(lang.lang()[3]);
				playerSwitch = 1;
			}
			
			//reaktionstid på player 1
			after1 = System.currentTimeMillis();
			System.out.println("Player 1 response time: " + (after1-before1) + "Milliseconds");
			
		} else if (playerSwitch == 1) {
			
			//reaktionstid på player 2
			before2 = System.currentTimeMillis();
			
			int[] roll = Roll.roll();

			Player.setPlayerPlace(false, roll[2]);
			Player.setPlayerScore(false);

			p2Point.setText(lang.lang()[1] + Player.getPlayerScore(false));
			rollMsg.setText(lang.lang()[9] + roll[0] + " and " + roll[1]);

			if (Player.getPlayerScore(false) >= 3000){
				message.setFont(new Font("Sherif", Font.PLAIN, 35));
				message.setText(lang.lang()[29]);
				playerTurn.setText("");
				button.setEnabled(false);
				return;
			}

			else if(Board.getFieldEffect(Player.getPlayerPlace(false))>=0){
				message.setText(lang.lang()[10] + Board.getFieldName(Player.getPlayerPlace(false)) + lang.lang()[11]  + " " + Board.getFieldEffect(Player.getPlayerPlace(false)) + " " + lang.lang()[25]);	
			}
			else if(Board.getFieldEffect(Player.getPlayerPlace(false))<0){
				message.setText(lang.lang()[10] + Board.getFieldName(Player.getPlayerPlace(false)) + lang.lang()[12]  + " " + Math.abs(Board.getFieldEffect(Player.getPlayerPlace(false))) + " " + lang.lang()[25]);	
			}    			player2Map.setText(lang.lang()[8]+Player.getPlayerPlace(false)+". "+ Board.getFieldName(Player.getPlayerPlace(false)));
			if (Player.getPlayerPlace(false)==9){
				playerTurn.setText(lang.lang()[3]);
				playerSwitch = 1;
			}
			else {
				playerTurn.setText(lang.lang()[2]);
				playerSwitch = 0;
			}
			//reaktionstid på player 2
			after2 = System.currentTimeMillis();
			System.out.println("Player 2 resposne time: " + (after2-before2) + "Milliseconds");
			
		} else {
			System.out.println("Fejl i spillerskift");
		}
		
	};
	
	public void setRoll(Die roll) {
		Roll = roll;
	}

	// Viser GUI
	public static void main(String[] args) {
		
		long before3 = System.currentTimeMillis();
		new GUI();
		long after3 = System.currentTimeMillis();
		System.out.println("GUI launce respone time: " + (after3-before3) + " Milliseconds");
		
	}
}