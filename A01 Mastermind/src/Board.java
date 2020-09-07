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
		setBounds(100, 100, 625, 450);
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
		gbl_panelWinningCode.columnWidths = new int[]{176, 31, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelWinningCode.rowHeights = new int[]{16, 0};
		gbl_panelWinningCode.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelWinningCode.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelWinningCode.setLayout(gbl_panelWinningCode);
		
		JLabel lblWinningCode = new JLabel("\"Winning Code\"");
		GridBagConstraints gbc_lblWinningCode = new GridBagConstraints();
		gbc_lblWinningCode.insets = new Insets(0, 0, 0, 5);
		gbc_lblWinningCode.anchor = GridBagConstraints.NORTH;
		gbc_lblWinningCode.gridx = 0;
		gbc_lblWinningCode.gridy = 0;
		panelWinningCode.add(lblWinningCode, gbc_lblWinningCode);
		
		JButton btnMenu = new JButton("Menu");
		GridBagConstraints gbc_btnMenu = new GridBagConstraints();
		gbc_btnMenu.insets = new Insets(0, 0, 0, 5);
		gbc_btnMenu.gridx = 11;
		gbc_btnMenu.gridy = 0;
		panelWinningCode.add(btnMenu, gbc_btnMenu);
		
		JPanel panelGame = new JPanel();
		panelGame.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelGame, BorderLayout.CENTER);
		GridBagLayout gbl_panelGame = new GridBagLayout();
		gbl_panelGame.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelGame.rowHeights = new int[]{0, 0};
		gbl_panelGame.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelGame.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelGame.setLayout(gbl_panelGame);
		
		JButton btnOne = new JButton("New button");
		GridBagConstraints gbc_btnOne = new GridBagConstraints();
		gbc_btnOne.insets = new Insets(0, 0, 0, 5);
		gbc_btnOne.gridx = 0;
		gbc_btnOne.gridy = 0;
		panelGame.add(btnOne, gbc_btnOne);
		
		JButton btnTwo = new JButton("New button");
		GridBagConstraints gbc_btnTwo = new GridBagConstraints();
		gbc_btnTwo.insets = new Insets(0, 0, 0, 5);
		gbc_btnTwo.gridx = 1;
		gbc_btnTwo.gridy = 0;
		panelGame.add(btnTwo, gbc_btnTwo);
		
		JButton btnThree = new JButton("New button");
		GridBagConstraints gbc_btnThree = new GridBagConstraints();
		gbc_btnThree.insets = new Insets(0, 0, 0, 5);
		gbc_btnThree.gridx = 2;
		gbc_btnThree.gridy = 0;
		panelGame.add(btnThree, gbc_btnThree);
		
		JButton btnFour = new JButton("New button");
		GridBagConstraints gbc_btnFour = new GridBagConstraints();
		gbc_btnFour.insets = new Insets(0, 0, 0, 5);
		gbc_btnFour.gridx = 3;
		gbc_btnFour.gridy = 0;
		panelGame.add(btnFour, gbc_btnFour);
	}

}
