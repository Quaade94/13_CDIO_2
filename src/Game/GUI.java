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
	GameBoard Board = new GameBoard();
	Player Player = new Player();

	//laver variables
	private int p1Points = 1000;
	private int p2Points = 1000;
	private int playerSwitch = 0;
	private JLabel p1Point = new JLabel(X.lang()[0] + p1Points);
	private JLabel p2Point = new JLabel(X.lang()[1] + p2Points);;
	private JLabel playerTurn = new JLabel(X.lang()[2], SwingConstants.CENTER);
	
	//private JLabel map_title = new JLabel(X.lang()[6]);
	private JLabel player1Map = new JLabel(X.lang()[7]);
	private JLabel player2Map = new JLabel(X.lang()[8]);
	private JLabel rollMsg = new JLabel(X.lang()[9]);
	private JLabel message = new JLabel(X.lang()[13]);
	private JFrame frame = new JFrame();
	private JLabel player1 = new JLabel(X.lang()[26]);
	private JLabel player2 = new JLabel(X.lang()[27]);
	private JPanel bottompanel = new JPanel();
	private JButton button = new JButton(X.lang()[4]);

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
		frame.setTitle(X.lang()[5]);
		frame.setSize(600, 400);
		frame.setResizable(false);
		//frame.pack();
		frame.setVisible(true);
	}

	// Hvad sker der, naar knappen bliver trykket:
	public void actionPerformed(ActionEvent F) {

		if (playerSwitch == 0) {
			int[] roll = Roll.Roll();

			Player.setPlayerPlace(true, roll[2]);
			Player.setPlayerScorre(true);

			p1Point.setText(X.lang()[0] + Player.getPlayerScorre(true));
			rollMsg.setText(X.lang()[9] + roll[0] + " and " + roll[1]);

			if(Player.getPlayerScorre(true)>2999){
				message.setFont(new Font("Sherif", Font.PLAIN, 35));
				message.setText(X.lang()[28]);
				playerTurn.setText("");
				button.setEnabled(false);
				return;

			}

			else if(Board.getFieldEffect(Player.getPlayerPlace(true))>=0){
				message.setText(X.lang()[10] + Board.getFieldName(Player.getPlayerPlace(true)) + X.lang()[11]  + " " + Board.getFieldEffect(Player.getPlayerPlace(true))+ " " + X.lang()[25]);	
			}
			else if(Board.getFieldEffect(Player.getPlayerPlace(true))<0){
				message.setText(X.lang()[10] + Board.getFieldName(Player.getPlayerPlace(true)) + X.lang()[12]  + " " + Math.abs(Board.getFieldEffect(Player.getPlayerPlace(true))) + " " + X.lang()[25]);	
			}
			player1Map.setText(X.lang()[7] + Player.getPlayerPlace(true)+". "+ Board.getFieldName(Player.getPlayerPlace(true)));

			if (Player.getPlayerPlace(false)==9){
				playerTurn.setText(X.lang()[2]);
				playerSwitch = 0;
			}
			else {
				playerTurn.setText(X.lang()[3]);
				playerSwitch = 1;
			}

		} else if (playerSwitch == 1) {
			int[] roll = Roll.Roll();

			Player.setPlayerPlace(false, roll[2]);
			Player.setPlayerScorre(false);

			p2Point.setText(X.lang()[1] + Player.getPlayerScorre(false));
			rollMsg.setText(X.lang()[9] + roll[0] + " and " + roll[1]);

			if (Player.getPlayerScorre(false)>2999){
				message.setFont(new Font("Sherif", Font.PLAIN, 35));
				message.setText(X.lang()[29]);
				playerTurn.setText("");
				button.setEnabled(false);
				return;
			}

			else if(Board.getFieldEffect(Player.getPlayerPlace(false))>=0){
				message.setText(X.lang()[10] + Board.getFieldName(Player.getPlayerPlace(false)) + X.lang()[11]  + " " + Board.getFieldEffect(Player.getPlayerPlace(false)) + " " + X.lang()[25]);	
			}
			else if(Board.getFieldEffect(Player.getPlayerPlace(false))<0){
				message.setText(X.lang()[10] + Board.getFieldName(Player.getPlayerPlace(false)) + X.lang()[12]  + " " + Math.abs(Board.getFieldEffect(Player.getPlayerPlace(false))) + " " + X.lang()[25]);	
			}    			player2Map.setText(X.lang()[8]+Player.getPlayerPlace(false)+". "+ Board.getFieldName(Player.getPlayerPlace(false)));
			if (Player.getPlayerPlace(false)==9){
				playerTurn.setText(X.lang()[3]);
				playerSwitch = 1;
			}
			else {
				playerTurn.setText(X.lang()[2]);
				playerSwitch = 0;
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