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
import java.awt.Dimension;

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
		setBounds(100, 100, 700, 1500);
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
		gbl_panelResults.columnWidths = new int[]{166, 0};
		gbl_panelResults.rowHeights = new int[]{0, 0};
		gbl_panelResults.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelResults.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelResults.setLayout(gbl_panelResults);
		
		JButton btnResultsOne = new JButton("");
		GridBagConstraints gbc_btnResultsOne = new GridBagConstraints();
		gbc_btnResultsOne.gridx = 0;
		gbc_btnResultsOne.gridy = 0;
		panelResults.add(btnResultsOne, gbc_btnResultsOne);
		
		JPanel panelWinningCode = new JPanel();
		panelWinningCode.setMaximumSize(new Dimension(20767, 20767));
		contentPane.add(panelWinningCode, BorderLayout.SOUTH);
		GridBagLayout gbl_panelWinningCode = new GridBagLayout();
		gbl_panelWinningCode.columnWidths = new int[]{634, 0, 0, 0};
		gbl_panelWinningCode.rowHeights = new int[]{100, 0};
		gbl_panelWinningCode.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelWinningCode.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelWinningCode.setLayout(gbl_panelWinningCode);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(22767, 22767));
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
		gbl_panelGame.columnWidths = new int[]{125, 125, 125, 125, 0};
		gbl_panelGame.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelGame.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelGame.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelGame.setLayout(gbl_panelGame);
		
		JButton btn1Row1 = new JButton("");
		btn1Row1.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn1Row1 = new GridBagConstraints();
		gbc_btn1Row1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row1.gridx = 0;
		gbc_btn1Row1.gridy = 0;
		panelGame.add(btn1Row1, gbc_btn1Row1);
		
		JButton btn2Row1 = new JButton("");
		btn2Row1.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn2Row1 = new GridBagConstraints();
		gbc_btn2Row1.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row1.gridx = 1;
		gbc_btn2Row1.gridy = 0;
		panelGame.add(btn2Row1, gbc_btn2Row1);
		
		JButton btn3Row1 = new JButton("");
		btn3Row1.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn3Row1 = new GridBagConstraints();
		gbc_btn3Row1.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row1.gridx = 2;
		gbc_btn3Row1.gridy = 0;
		panelGame.add(btn3Row1, gbc_btn3Row1);
		
		JButton btn4Row1 = new JButton("");
		btn4Row1.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn4Row1 = new GridBagConstraints();
		gbc_btn4Row1.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row1.gridx = 3;
		gbc_btn4Row1.gridy = 0;
		panelGame.add(btn4Row1, gbc_btn4Row1);
		
		JButton btn1Row2 = new JButton("");
		btn1Row2.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn1Row2 = new GridBagConstraints();
		gbc_btn1Row2.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row2.gridx = 0;
		gbc_btn1Row2.gridy = 1;
		panelGame.add(btn1Row2, gbc_btn1Row2);
		
		JButton btn2Row2 = new JButton("");
		btn2Row2.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn2Row2 = new GridBagConstraints();
		gbc_btn2Row2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row2.gridx = 1;
		gbc_btn2Row2.gridy = 1;
		panelGame.add(btn2Row2, gbc_btn2Row2);
		
		JButton btn3Row2 = new JButton("");
		btn3Row2.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn3Row2 = new GridBagConstraints();
		gbc_btn3Row2.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row2.gridx = 2;
		gbc_btn3Row2.gridy = 1;
		panelGame.add(btn3Row2, gbc_btn3Row2);
		
		JButton btn4Row2 = new JButton("");
		btn4Row2.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn4Row2 = new GridBagConstraints();
		gbc_btn4Row2.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row2.gridx = 3;
		gbc_btn4Row2.gridy = 1;
		panelGame.add(btn4Row2, gbc_btn4Row2);
		
		JButton btn1Row3 = new JButton("");
		btn1Row3.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn1Row3 = new GridBagConstraints();
		gbc_btn1Row3.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row3.gridx = 0;
		gbc_btn1Row3.gridy = 2;
		panelGame.add(btn1Row3, gbc_btn1Row3);
		
		JButton btn2Row3 = new JButton("");
		btn2Row3.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn2Row3 = new GridBagConstraints();
		gbc_btn2Row3.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row3.gridx = 1;
		gbc_btn2Row3.gridy = 2;
		panelGame.add(btn2Row3, gbc_btn2Row3);
		
		JButton btn3Row3 = new JButton("");
		btn3Row3.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn3Row3 = new GridBagConstraints();
		gbc_btn3Row3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row3.gridx = 2;
		gbc_btn3Row3.gridy = 2;
		panelGame.add(btn3Row3, gbc_btn3Row3);
		
		JButton btn4Row3 = new JButton("");
		btn4Row3.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn4Row3 = new GridBagConstraints();
		gbc_btn4Row3.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row3.gridx = 3;
		gbc_btn4Row3.gridy = 2;
		panelGame.add(btn4Row3, gbc_btn4Row3);
		
		JButton btn1Row4 = new JButton("");
		btn1Row4.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn1Row4 = new GridBagConstraints();
		gbc_btn1Row4.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row4.gridx = 0;
		gbc_btn1Row4.gridy = 3;
		panelGame.add(btn1Row4, gbc_btn1Row4);
		
		JButton btn2Row4 = new JButton("");
		btn2Row4.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn2Row4 = new GridBagConstraints();
		gbc_btn2Row4.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row4.gridx = 1;
		gbc_btn2Row4.gridy = 3;
		panelGame.add(btn2Row4, gbc_btn2Row4);
		
		JButton btn3Row4 = new JButton("");
		btn3Row4.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn3Row4 = new GridBagConstraints();
		gbc_btn3Row4.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row4.gridx = 2;
		gbc_btn3Row4.gridy = 3;
		panelGame.add(btn3Row4, gbc_btn3Row4);
		
		JButton btn4Row4 = new JButton("");
		btn4Row4.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn4Row4 = new GridBagConstraints();
		gbc_btn4Row4.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row4.gridx = 3;
		gbc_btn4Row4.gridy = 3;
		panelGame.add(btn4Row4, gbc_btn4Row4);
		
		JButton btn1Row5 = new JButton("");
		btn1Row5.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn1Row5 = new GridBagConstraints();
		gbc_btn1Row5.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row5.gridx = 0;
		gbc_btn1Row5.gridy = 4;
		panelGame.add(btn1Row5, gbc_btn1Row5);
		
		JButton btn2Row5 = new JButton("");
		btn2Row5.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn2Row5 = new GridBagConstraints();
		gbc_btn2Row5.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row5.gridx = 1;
		gbc_btn2Row5.gridy = 4;
		panelGame.add(btn2Row5, gbc_btn2Row5);
		
		JButton btn3Row5 = new JButton("");
		btn3Row5.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn3Row5 = new GridBagConstraints();
		gbc_btn3Row5.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row5.gridx = 2;
		gbc_btn3Row5.gridy = 4;
		panelGame.add(btn3Row5, gbc_btn3Row5);
		
		JButton btn4Row5 = new JButton("");
		btn4Row5.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn4Row5 = new GridBagConstraints();
		gbc_btn4Row5.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row5.gridx = 3;
		gbc_btn4Row5.gridy = 4;
		panelGame.add(btn4Row5, gbc_btn4Row5);
		
		JButton btn1Row6 = new JButton("");
		btn1Row6.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn1Row6 = new GridBagConstraints();
		gbc_btn1Row6.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row6.gridx = 0;
		gbc_btn1Row6.gridy = 5;
		panelGame.add(btn1Row6, gbc_btn1Row6);
		
		JButton btn2Row6 = new JButton("");
		btn2Row6.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn2Row6 = new GridBagConstraints();
		gbc_btn2Row6.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row6.gridx = 1;
		gbc_btn2Row6.gridy = 5;
		panelGame.add(btn2Row6, gbc_btn2Row6);
		
		JButton btn3Row6 = new JButton("");
		btn3Row6.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn3Row6 = new GridBagConstraints();
		gbc_btn3Row6.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row6.gridx = 2;
		gbc_btn3Row6.gridy = 5;
		panelGame.add(btn3Row6, gbc_btn3Row6);
		
		JButton btn4Row6 = new JButton("");
		btn4Row6.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn4Row6 = new GridBagConstraints();
		gbc_btn4Row6.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row6.gridx = 3;
		gbc_btn4Row6.gridy = 5;
		panelGame.add(btn4Row6, gbc_btn4Row6);
		
		JButton btn1Row7 = new JButton("");
		btn1Row7.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn1Row7 = new GridBagConstraints();
		gbc_btn1Row7.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row7.gridx = 0;
		gbc_btn1Row7.gridy = 6;
		panelGame.add(btn1Row7, gbc_btn1Row7);
		
		JButton btn2Row7 = new JButton("");
		btn2Row7.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn2Row7 = new GridBagConstraints();
		gbc_btn2Row7.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row7.gridx = 1;
		gbc_btn2Row7.gridy = 6;
		panelGame.add(btn2Row7, gbc_btn2Row7);
		
		JButton btn3Row7 = new JButton("");
		btn3Row7.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn3Row7 = new GridBagConstraints();
		gbc_btn3Row7.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row7.gridx = 2;
		gbc_btn3Row7.gridy = 6;
		panelGame.add(btn3Row7, gbc_btn3Row7);
		
		JButton btn4Row7 = new JButton("");
		btn4Row7.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn4Row7 = new GridBagConstraints();
		gbc_btn4Row7.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row7.gridx = 3;
		gbc_btn4Row7.gridy = 6;
		panelGame.add(btn4Row7, gbc_btn4Row7);
		
		JButton btn1Row8 = new JButton("");
		btn1Row8.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn1Row8 = new GridBagConstraints();
		gbc_btn1Row8.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row8.gridx = 0;
		gbc_btn1Row8.gridy = 7;
		panelGame.add(btn1Row8, gbc_btn1Row8);
		
		JButton btn2Row8 = new JButton("");
		btn2Row8.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn2Row8 = new GridBagConstraints();
		gbc_btn2Row8.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row8.gridx = 1;
		gbc_btn2Row8.gridy = 7;
		panelGame.add(btn2Row8, gbc_btn2Row8);
		
		JButton btn3Row8 = new JButton("");
		btn3Row8.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn3Row8 = new GridBagConstraints();
		gbc_btn3Row8.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row8.gridx = 2;
		gbc_btn3Row8.gridy = 7;
		panelGame.add(btn3Row8, gbc_btn3Row8);
		
		JButton btn4Row8 = new JButton("");
		btn4Row8.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn4Row8 = new GridBagConstraints();
		gbc_btn4Row8.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row8.gridx = 3;
		gbc_btn4Row8.gridy = 7;
		panelGame.add(btn4Row8, gbc_btn4Row8);
		
		JButton btn1Row9 = new JButton("");
		btn1Row9.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn1Row9 = new GridBagConstraints();
		gbc_btn1Row9.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row9.gridx = 0;
		gbc_btn1Row9.gridy = 8;
		panelGame.add(btn1Row9, gbc_btn1Row9);
		
		JButton btn2Row9 = new JButton("");
		btn2Row9.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn2Row9 = new GridBagConstraints();
		gbc_btn2Row9.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row9.gridx = 1;
		gbc_btn2Row9.gridy = 8;
		panelGame.add(btn2Row9, gbc_btn2Row9);
		
		JButton btn3Row9 = new JButton("");
		btn3Row9.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn3Row9 = new GridBagConstraints();
		gbc_btn3Row9.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row9.gridx = 2;
		gbc_btn3Row9.gridy = 8;
		panelGame.add(btn3Row9, gbc_btn3Row9);
		
		JButton btn4Row9 = new JButton("");
		btn4Row9.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn4Row9 = new GridBagConstraints();
		gbc_btn4Row9.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row9.gridx = 3;
		gbc_btn4Row9.gridy = 8;
		panelGame.add(btn4Row9, gbc_btn4Row9);
		
		JButton btn1Row10 = new JButton("");
		btn1Row10.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn1Row10 = new GridBagConstraints();
		gbc_btn1Row10.insets = new Insets(0, 0, 0, 5);
		gbc_btn1Row10.gridx = 0;
		gbc_btn1Row10.gridy = 9;
		panelGame.add(btn1Row10, gbc_btn1Row10);
		
		JButton btn2Row10 = new JButton("");
		btn2Row10.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn2Row10 = new GridBagConstraints();
		gbc_btn2Row10.insets = new Insets(0, 0, 0, 5);
		gbc_btn2Row10.gridx = 1;
		gbc_btn2Row10.gridy = 9;
		panelGame.add(btn2Row10, gbc_btn2Row10);
		
		JButton btn3Row10 = new JButton("");
		btn3Row10.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn3Row10 = new GridBagConstraints();
		gbc_btn3Row10.insets = new Insets(0, 0, 0, 5);
		gbc_btn3Row10.gridx = 2;
		gbc_btn3Row10.gridy = 9;
		panelGame.add(btn3Row10, gbc_btn3Row10);
		
		JButton btn4Row10 = new JButton("");
		btn4Row10.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		GridBagConstraints gbc_btn4Row10 = new GridBagConstraints();
		gbc_btn4Row10.gridx = 3;
		gbc_btn4Row10.gridy = 9;
		panelGame.add(btn4Row10, gbc_btn4Row10);
	}

}
