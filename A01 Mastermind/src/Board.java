import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

public class Board extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board frame = new Board();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Board() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelTitle, BorderLayout.NORTH);
		
		JLabel titleLabel = new JLabel("Mastermind");
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		panelTitle.add(titleLabel);
		
		JPanel panelResults = new JPanel();
		panelResults.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelResults, BorderLayout.EAST);
		GridBagLayout gbl_panelResults = new GridBagLayout();
		gbl_panelResults.columnWidths = new int[]{0, 0};
		gbl_panelResults.rowHeights = new int[]{0, 0};
		gbl_panelResults.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelResults.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelResults.setLayout(gbl_panelResults);
		
		JButton btnResultsOne = new JButton("Submit");
		GridBagConstraints gbc_btnResultsOne = new GridBagConstraints();
		gbc_btnResultsOne.gridx = 0;
		gbc_btnResultsOne.gridy = 0;
		panelResults.add(btnResultsOne, gbc_btnResultsOne);
		
		JPanel panelWinningCode = new JPanel();
		contentPane.add(panelWinningCode, BorderLayout.SOUTH);
		GridBagLayout gbl_panelWinningCode = new GridBagLayout();
		gbl_panelWinningCode.columnWidths = new int[]{634, 0, 0, 0};
		gbl_panelWinningCode.rowHeights = new int[]{16, 0};
		gbl_panelWinningCode.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelWinningCode.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelWinningCode.setLayout(gbl_panelWinningCode);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panelWinningCode.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 94, 94, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton redMarbleBtn = new JButton("");
		redMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/RedMarble.JPG")));
		GridBagConstraints gbc_redMarbleBtn = new GridBagConstraints();
		gbc_redMarbleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_redMarbleBtn.gridx = 0;
		gbc_redMarbleBtn.gridy = 0;
		panel.add(redMarbleBtn, gbc_redMarbleBtn);
		
		JButton yellowMarbleBtn = new JButton("");
		yellowMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/YellowMarble.JPG")));
		GridBagConstraints gbc_yellowMarbleBtn = new GridBagConstraints();
		gbc_yellowMarbleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_yellowMarbleBtn.gridx = 1;
		gbc_yellowMarbleBtn.gridy = 0;
		panel.add(yellowMarbleBtn, gbc_yellowMarbleBtn);
		
		JButton blueMarbleBtn = new JButton("");
		blueMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlueMarble.JPG")));
		GridBagConstraints gbc_blueMarbleBtn = new GridBagConstraints();
		gbc_blueMarbleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_blueMarbleBtn.gridx = 2;
		gbc_blueMarbleBtn.gridy = 0;
		panel.add(blueMarbleBtn, gbc_blueMarbleBtn);
		
		JButton greenMarbleBtn = new JButton("");
		greenMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/GreenMarble.JPG")));
		GridBagConstraints gbc_greenMarbleBtn = new GridBagConstraints();
		gbc_greenMarbleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_greenMarbleBtn.gridx = 3;
		gbc_greenMarbleBtn.gridy = 0;
		panel.add(greenMarbleBtn, gbc_greenMarbleBtn);
		
		JButton blackMarbleBtn = new JButton("");
		blackMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlackMarble.JPG")));
		GridBagConstraints gbc_blackMarbleBtn = new GridBagConstraints();
		gbc_blackMarbleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_blackMarbleBtn.gridx = 4;
		gbc_blackMarbleBtn.gridy = 0;
		panel.add(blackMarbleBtn, gbc_blackMarbleBtn);
		
		JButton whiteMarbleBtn = new JButton("");
		whiteMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/WhiteMarble.JPG")));
		GridBagConstraints gbc_whiteMarbleBtn = new GridBagConstraints();
		gbc_whiteMarbleBtn.gridx = 5;
		gbc_whiteMarbleBtn.gridy = 0;
		panel.add(whiteMarbleBtn, gbc_whiteMarbleBtn);
		
		JButton submitBtn = new JButton("SUBMIT");
		GridBagConstraints gbc_submitBtn = new GridBagConstraints();
		gbc_submitBtn.insets = new Insets(0, 0, 0, 5);
		gbc_submitBtn.gridx = 1;
		gbc_submitBtn.gridy = 0;
		panelWinningCode.add(submitBtn, gbc_submitBtn);
		
		JButton btnMenu = new JButton("Menu");
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.gridx = 2;
		gbc_btnMenu.gridy = 0;
		panelWinningCode.add(btnMenu, gbc_btnMenu);
		
		JPanel panelGame = new JPanel();
		panelGame.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelGame, BorderLayout.CENTER);
		GridBagLayout gbl_panelGame = new GridBagLayout();
		gbl_panelGame.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelGame.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panelGame.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelGame.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelGame.setLayout(gbl_panelGame);
		
		JButton btnOne = new JButton("New button");
		GridBagConstraints gbc_btnOne = new GridBagConstraints();
		gbc_btnOne.insets = new Insets(0, 0, 5, 5);
		gbc_btnOne.gridx = 0;
		gbc_btnOne.gridy = 0;
		panelGame.add(btnOne, gbc_btnOne);
		
		JButton btnTwo = new JButton("New button");
		GridBagConstraints gbc_btnTwo = new GridBagConstraints();
		gbc_btnTwo.insets = new Insets(0, 0, 5, 5);
		gbc_btnTwo.gridx = 1;
		gbc_btnTwo.gridy = 0;
		panelGame.add(btnTwo, gbc_btnTwo);
		
		JButton btnThree = new JButton("New button");
		GridBagConstraints gbc_btnThree = new GridBagConstraints();
		gbc_btnThree.insets = new Insets(0, 0, 5, 5);
		gbc_btnThree.gridx = 2;
		gbc_btnThree.gridy = 0;
		panelGame.add(btnThree, gbc_btnThree);
		
		JButton btnFour = new JButton("New button");
		GridBagConstraints gbc_btnFour = new GridBagConstraints();
		gbc_btnFour.insets = new Insets(0, 0, 5, 0);
		gbc_btnFour.gridx = 3;
		gbc_btnFour.gridy = 0;
		panelGame.add(btnFour, gbc_btnFour);
	}

}
