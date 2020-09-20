package mastermind;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class Board extends JFrame {
	private JLabel titleLabel;
	private String colorSelected = "";
	private String feedback = "";
	private JPanel contentPane;
	private boolean[][] marbleGrid = new boolean[10][4];
	private int guiRow = 0;
	//private int guiColumn = 0;
	private ArrayList<Codes> playerCodes = new ArrayList<>();
	private Codes[][] colorArray = new Codes[10][4];
	private boolean win = false;
	private JButton btn1Row1;
	private JButton btn2Row1;
	private JButton btn3Row1;
	private JButton btn4Row1;
	private JButton btn1Row2;
	private JButton btn2Row2;
	private JButton btn3Row2;
	private JButton btn4Row2;
	private JButton btn1Row3;
	private JButton btn2Row3;
	private JButton btn3Row3;
	private JButton btn4Row3;
	private JButton btn1Row4;
	private JButton btn2Row4;
	private JButton btn3Row4;
	private JButton btn4Row4;
	private JButton btn1Row5;
	private JButton btn2Row5;
	private JButton btn3Row5;
	private JButton btn4Row5;
	private JButton btn1Row6;
	private JButton btn2Row6;
	private JButton btn3Row6;
	private JButton btn4Row6;
	private JButton btn1Row7;
	private JButton btn2Row7;
	private JButton btn3Row7;
	private JButton btn4Row7;
	private JButton btn1Row8;
	private JButton btn2Row8;
	private JButton btn3Row8;
	private JButton btn4Row8;
	private JButton btn1Row9;
	private JButton btn2Row9;
	private JButton btn3Row9;
	private JButton btn4Row9;
	private JButton btn1Row10;
	private JButton btn2Row10;
	private JButton btn3Row10;
	private JButton btn4Row10;
	
	private JButton btnResults1;
	private JButton btnResults2;
	private JButton btnResults3;
	private JButton btnResults4;
	private JButton btnResults5;
	private JButton btnResults6;
	private JButton btnResults7;
	private JButton btnResults8;
	private JButton btnResults9;
	private JButton btnResults10;
	
	ArrayList<JButton> feedbackArr = new ArrayList<>();

	/*private JButton[] btns = new JButton[]{btn1Row1, btn2Row1, btn3Row1, btn4Row1, btn1Row2, btn2Row2, btn3Row2, btn4Row2, 
			btn1Row3, btn2Row3, btn3Row3, btn4Row3 btn1Row4, btn2Row4 ,btn3Row4, btn4Row4, btn1Row5, btn2Row5, btn3Row5, btn4Row5, 
			btn1Row6, btn2Row6, btn3Row6, btn4Row6, btn1Row7, btn2Row7, btn3Row7, btn4Row7, btn1Row8, btn2Row8, btn3Row8, btn4Row8, 
			btn1Row9, btn2Row9, btn3Row9, btn4Row9, btn1Row10, btn2Row10, btn3Row10, btn4Row10};
	*/
	private ArrayList<JButton> btns = new ArrayList<JButton>();
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
		Mastermind.createCodeToBreak();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 1500);
		menuBarItems();
		resetMarbleGridArray();
		btns.add(btn1Row1);
		btns.add(btn2Row1);
		btns.add(btn3Row1);
		btns.add(btn4Row1);
		btns.add(btn1Row2);
		btns.add(btn2Row2);
		btns.add(btn3Row2);
		btns.add(btn4Row2);
		btns.add(btn1Row3);
		btns.add(btn2Row3);
		btns.add(btn3Row3);
		btns.add(btn4Row3);
		btns.add(btn1Row4);
		btns.add(btn2Row4);
		btns.add(btn3Row4);
		btns.add(btn4Row4);
		btns.add(btn1Row5);
		btns.add(btn2Row5);
		btns.add(btn3Row5);
		btns.add(btn4Row5);
		btns.add(btn1Row6);
		btns.add(btn2Row6);
		btns.add(btn3Row6);
		btns.add(btn4Row6);
		btns.add(btn1Row7);
		btns.add(btn2Row7);
		btns.add(btn3Row7);
		btns.add(btn4Row7);
		btns.add(btn1Row8);
		btns.add(btn2Row8);
		btns.add(btn3Row8);
		btns.add(btn4Row8);
		btns.add(btn1Row9);
		btns.add(btn2Row9);
		btns.add(btn3Row9);
		btns.add(btn4Row9);
		btns.add(btn1Row10);
		btns.add(btn2Row10);
		btns.add(btn3Row10);
		btns.add(btn4Row10);
		
		

		titleOfGame();

		JPanel panelResults = new JPanel();
		panelResults.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelResults, BorderLayout.EAST);
		GridBagLayout gbl_panelResults = new GridBagLayout();
		gbl_panelResults.columnWidths = new int[] { 166, 0 };
		gbl_panelResults.rowHeights = new int[] { 60, 60, 60, 60, 60, 60, 60, 60, 60, 60, 0 };
		gbl_panelResults.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panelResults.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panelResults.setLayout(gbl_panelResults);

		feedbackIcons(panelResults);

		JPanel marbleColorPanel = new JPanel();
		marbleColorPanel.setMaximumSize(new Dimension(20767, 20767));
		contentPane.add(marbleColorPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_marbleColorPanel = new GridBagLayout();
		gbl_marbleColorPanel.columnWidths = new int[] { 634, 0, 0, 0 };
		gbl_marbleColorPanel.rowHeights = new int[] { 100, 0 };
		gbl_marbleColorPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_marbleColorPanel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		marbleColorPanel.setLayout(gbl_marbleColorPanel);

		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(22767, 22767));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		marbleColorPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 94, 94, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		createPlayerMarbles(panel);

		submitBtn(marbleColorPanel);

		JPanel panelGame = new JPanel();
		panelGame.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelGame, BorderLayout.CENTER);
		GridBagLayout gbl_panelGame = new GridBagLayout();
		gbl_panelGame.columnWidths = new int[] { 125, 125, 125, 125, 0 };
		gbl_panelGame.rowHeights = new int[] { 70, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelGame.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelGame.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelGame.setLayout(gbl_panelGame);

		createMarbleSlots(panelGame);
	}

	private void titleOfGame() {
		JPanel panelTitle = new JPanel();
		panelTitle.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelTitle, BorderLayout.NORTH);
<<<<<<< HEAD
		titleLabel = new JLabel("Mastermind - Row# "+(guiRow+1));
=======
		//TODO KELSIE Change to win or lose
		titleLabel = new JLabel("Mastermind");
>>>>>>> 43c7ff686dbe82a1e3de24c69849745bc2a46843
		titleLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		panelTitle.add(titleLabel);
	}
	


	private void feedbackIcons(JPanel panelResults) {
		btnResults1 = new JButton("");
		btnResults1.setIcon(null);
		GridBagConstraints gbc_btnResults1 = new GridBagConstraints();
		gbc_btnResults1.insets = new Insets(0, 0, 5, 0);
		gbc_btnResults1.gridx = 0;
		gbc_btnResults1.gridy = 0;
		panelResults.add(btnResults1, gbc_btnResults1);

		btnResults2 = new JButton("");
		btnResults2.setIcon(null);
		GridBagConstraints gbc_btnResults2 = new GridBagConstraints();
		gbc_btnResults2.insets = new Insets(0, 0, 5, 0);
		gbc_btnResults2.gridx = 0;
		gbc_btnResults2.gridy = 1;
		panelResults.add(btnResults2, gbc_btnResults2);

		btnResults3 = new JButton("");
		btnResults3.setIcon(null);
		GridBagConstraints gbc_btnResults3 = new GridBagConstraints();
		gbc_btnResults3.insets = new Insets(0, 0, 5, 0);
		gbc_btnResults3.gridx = 0;
		gbc_btnResults3.gridy = 2;
		panelResults.add(btnResults3, gbc_btnResults3);

		btnResults4 = new JButton("");
		btnResults4.setIcon(null);
		GridBagConstraints gbc_btnResults4 = new GridBagConstraints();
		gbc_btnResults4.insets = new Insets(0, 0, 5, 0);
		gbc_btnResults4.gridx = 0;
		gbc_btnResults4.gridy = 3;
		panelResults.add(btnResults4, gbc_btnResults4);

		btnResults5 = new JButton("");
		btnResults5.setIcon(null);
		GridBagConstraints gbc_btnResults5 = new GridBagConstraints();
		gbc_btnResults5.insets = new Insets(0, 0, 5, 0);
		gbc_btnResults5.gridx = 0;
		gbc_btnResults5.gridy = 4;
		panelResults.add(btnResults5, gbc_btnResults5);

		btnResults6 = new JButton("");
		btnResults6.setIcon(null);
		GridBagConstraints gbc_btnResults6 = new GridBagConstraints();
		gbc_btnResults6.insets = new Insets(0, 0, 5, 0);
		gbc_btnResults6.gridx = 0;
		gbc_btnResults6.gridy = 5;
		panelResults.add(btnResults6, gbc_btnResults6);

		btnResults7 = new JButton("");
		btnResults7.setIcon(null);
		GridBagConstraints gbc_btnResults7 = new GridBagConstraints();
		gbc_btnResults7.insets = new Insets(0, 0, 5, 0);
		gbc_btnResults7.gridx = 0;
		gbc_btnResults7.gridy = 6;
		panelResults.add(btnResults7, gbc_btnResults7);

		btnResults8 = new JButton("");
		btnResults8.setIcon(null);
		GridBagConstraints gbc_btnResults8 = new GridBagConstraints();
		gbc_btnResults8.insets = new Insets(0, 0, 5, 0);
		gbc_btnResults8.gridx = 0;
		gbc_btnResults8.gridy = 7;
		panelResults.add(btnResults8, gbc_btnResults8);

		btnResults9 = new JButton("");
		btnResults9.setIcon(null);
		GridBagConstraints gbc_btnResults9 = new GridBagConstraints();
		gbc_btnResults9.insets = new Insets(0, 0, 5, 0);
		gbc_btnResults9.gridx = 0;
		gbc_btnResults9.gridy = 8;
		panelResults.add(btnResults9, gbc_btnResults9);

		btnResults10 = new JButton("");
		btnResults10.setIcon(null);
		GridBagConstraints gbc_btnResults10 = new GridBagConstraints();
		gbc_btnResults10.gridx = 0;
		gbc_btnResults10.gridy = 9;
		panelResults.add(btnResults10, gbc_btnResults10);
		
		feedbackArr = new ArrayList<>(Arrays.asList(
				btnResults1,btnResults2,btnResults3,btnResults4,btnResults5,
				btnResults6,btnResults7,btnResults8,btnResults9,btnResults10));
	}
	
	private void feedbackIconResults(JButton btn) {
		btn.setIcon(new ImageIcon(Board.class.getResource("/pegIcons/"+feedback+".PNG")));
		System.out.println("Feedback: " + feedback);
	}

	private void menuBarItems() {
		// Menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu btnMenu = new JMenu("Menu");
		menuBar.add(btnMenu);

		JMenuItem restartGameBtn = new JMenuItem("Restart Game");
		restartGameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO KELSIE Finish
				//resetMarbleSlots();
			}
		});
		btnMenu.add(restartGameBtn);
		JMenuItem scoreBtn = new JMenuItem("Score: ");
		btnMenu.add(scoreBtn);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	/**
	 * This is for the game buttons for submitting the color code or go to menu
	 * 
	 * @param panelWinningCode
	 */
	private void submitBtn(JPanel panelWinningCode) {
		JButton submitBtn = new JButton("SUBMIT");
		submitBtn.setEnabled(true);
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag = false;
				playerCodes.addAll(Arrays.asList(colorArray[guiRow][0],
						colorArray[guiRow][1],
						colorArray[guiRow][2],
						colorArray[guiRow][3]));
				System.out.println(playerCodes);
				
				if(playerCodes.contains(null)) {
					titleLabel.setText("Mastermind - Can't have empty slots... try again");
					playerCodes.removeAll(playerCodes);
					flag = !flag;
				}
				
				//if color array isnt full dont enable submit button yet
				if (guiRow < 9 && !flag && !win) {
					titleLabel.setText("Mastermind - Row# "+(guiRow+2));

					feedback = Mastermind.checkForCodeBreak(playerCodes);
<<<<<<< HEAD
					if(feedback == "BBBB") {
						titleLabel.setText("WINNER!");
						win = true;
=======
					if(feedback == "Win") {
						titleLabel.setText("WINNER!");
>>>>>>> 43c7ff686dbe82a1e3de24c69849745bc2a46843
					}
					
					enableNextRow(guiRow);
					disableCurrentRow(guiRow);
					
					feedbackIconResults(feedbackArr.get(guiRow));
					guiRow++;
					
					playerCodes.removeAll(playerCodes);
					//feedback = "";
					//for testing purposes TODO
					/*for(int i = 0; i < 10; i++) {
						
						for(int j = 0; j < 4; j++) {
							System.out.println(marbleGrid[i][j]);
							System.out.println(i + " - " + j);
							System.out.println();
						}
					}*/
					
<<<<<<< HEAD
				}else if(guiRow >= 9 && !flag) {
					feedback = Mastermind.checkForCodeBreak(playerCodes);
					feedbackIconResults(feedbackArr.get(guiRow));
=======
				}else {
>>>>>>> 43c7ff686dbe82a1e3de24c69849745bc2a46843
					titleLabel.setText("LOSER!!");
				}
			}
		});
		GridBagConstraints gbc_submitBtn = new GridBagConstraints();
		gbc_submitBtn.insets = new Insets(0, 0, 0, 5);
		gbc_submitBtn.gridx = 1;
		gbc_submitBtn.gridy = 0;
		panelWinningCode.add(submitBtn, gbc_submitBtn);
	}

	/**
	 * This method is for the color marbles at the bottom to choose which color to
	 * play
	 * 
	 * @param panel
	 */
	private void createPlayerMarbles(JPanel panel) {
		JButton redMarbleBtn = new JButton("");
		redMarbleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorSelected = "RedMarble.JPG";
			}
		});
		redMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/RedMarble.JPG")));
		GridBagConstraints gbc_redMarbleBtn = new GridBagConstraints();
		gbc_redMarbleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_redMarbleBtn.gridx = 0;
		gbc_redMarbleBtn.gridy = 0;
		panel.add(redMarbleBtn, gbc_redMarbleBtn);

		JButton yellowMarbleBtn = new JButton("");
		yellowMarbleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorSelected = "YellowMarble.JPG";
			}
		});
		yellowMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/YellowMarble.JPG")));
		GridBagConstraints gbc_yellowMarbleBtn = new GridBagConstraints();
		gbc_yellowMarbleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_yellowMarbleBtn.gridx = 1;
		gbc_yellowMarbleBtn.gridy = 0;
		panel.add(yellowMarbleBtn, gbc_yellowMarbleBtn);

		JButton blueMarbleBtn = new JButton("");
		blueMarbleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorSelected = "BlueMarble.JPG";
			}
		});
		blueMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlueMarble.JPG")));
		GridBagConstraints gbc_blueMarbleBtn = new GridBagConstraints();
		gbc_blueMarbleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_blueMarbleBtn.gridx = 2;
		gbc_blueMarbleBtn.gridy = 0;
		panel.add(blueMarbleBtn, gbc_blueMarbleBtn);

		JButton greenMarbleBtn = new JButton("");
		greenMarbleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorSelected = "GreenMarble.JPG";
			}
		});
		greenMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/GreenMarble.JPG")));
		GridBagConstraints gbc_greenMarbleBtn = new GridBagConstraints();
		gbc_greenMarbleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_greenMarbleBtn.gridx = 3;
		gbc_greenMarbleBtn.gridy = 0;
		panel.add(greenMarbleBtn, gbc_greenMarbleBtn);

		JButton blackMarbleBtn = new JButton("");
		blackMarbleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorSelected = "BlackMarble.JPG";
			}
		});
		blackMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlackMarble.JPG")));
		GridBagConstraints gbc_blackMarbleBtn = new GridBagConstraints();
		gbc_blackMarbleBtn.insets = new Insets(0, 0, 0, 5);
		gbc_blackMarbleBtn.gridx = 4;
		gbc_blackMarbleBtn.gridy = 0;
		panel.add(blackMarbleBtn, gbc_blackMarbleBtn);

		JButton whiteMarbleBtn = new JButton("");
		whiteMarbleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colorSelected = "WhiteMarble.JPG";
			}
		});
		whiteMarbleBtn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/WhiteMarble.JPG")));
		GridBagConstraints gbc_whiteMarbleBtn = new GridBagConstraints();
		gbc_whiteMarbleBtn.gridx = 5;
		gbc_whiteMarbleBtn.gridy = 0;
		panel.add(whiteMarbleBtn, gbc_whiteMarbleBtn);
	}
	
	/**
	 * This method is used for the blank marble slots at the beginning of the game
	 * and changing them to the colored marbles
	 * 
	 * @param panelGame
	 */
	private void createMarbleSlots(JPanel panelGame) {

		btn1Row1 = new JButton("");
		GridBagConstraints gbc_btn1Row1 = new GridBagConstraints();
		gbc_btn1Row1.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row1.gridx = 0;
		gbc_btn1Row1.gridy = 0;
		btn1Row1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn1Row1, colorSelected, gbc_btn1Row1.gridx, gbc_btn1Row1.gridy);
				resetMarbleSlots(btn1Row1);
			}

		});
		btn1Row1.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn1Row1, gbc_btn1Row1);

		btn2Row1 = new JButton("");
		GridBagConstraints gbc_btn2Row1 = new GridBagConstraints();
		gbc_btn2Row1.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row1.gridx = 1;
		gbc_btn2Row1.gridy = 0;
		btn2Row1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn2Row1, colorSelected, gbc_btn2Row1.gridx, gbc_btn2Row1.gridy);
				resetMarbleSlots(btn2Row1);
			}
		});
		btn2Row1.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn2Row1, gbc_btn2Row1);

		btn3Row1 = new JButton("");
		GridBagConstraints gbc_btn3Row1 = new GridBagConstraints();
		gbc_btn3Row1.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row1.gridx = 2;
		gbc_btn3Row1.gridy = 0;
		btn3Row1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn3Row1, colorSelected, gbc_btn3Row1.gridx, gbc_btn3Row1.gridy);
				resetMarbleSlots(btn3Row1);
			}
		});
		btn3Row1.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn3Row1, gbc_btn3Row1);

		btn4Row1 = new JButton("");
		GridBagConstraints gbc_btn4Row1 = new GridBagConstraints();
		gbc_btn4Row1.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row1.gridx = 3;
		gbc_btn4Row1.gridy = 0;
		btn4Row1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn4Row1, colorSelected, gbc_btn4Row1.gridx, gbc_btn4Row1.gridy);
				resetMarbleSlots(btn4Row1);
			}
		});
		btn4Row1.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn4Row1, gbc_btn4Row1);

		btn1Row2 = new JButton("");
		GridBagConstraints gbc_btn1Row2 = new GridBagConstraints();
		gbc_btn1Row2.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row2.gridx = 0;
		gbc_btn1Row2.gridy = 1;
		btn1Row2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn1Row2, colorSelected, gbc_btn1Row2.gridx, gbc_btn1Row2.gridy);
				resetMarbleSlots(btn1Row2);
			}
		});
		btn1Row2.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn1Row2, gbc_btn1Row2);

		btn2Row2 = new JButton("");
		GridBagConstraints gbc_btn2Row2 = new GridBagConstraints();
		gbc_btn2Row2.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row2.gridx = 1;
		gbc_btn2Row2.gridy = 1;
		btn2Row2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn2Row2, colorSelected, gbc_btn2Row2.gridx, gbc_btn2Row2.gridy);
				resetMarbleSlots(btn2Row2);
			}
		});
		btn2Row2.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn2Row2, gbc_btn2Row2);

		btn3Row2 = new JButton("");
		GridBagConstraints gbc_btn3Row2 = new GridBagConstraints();
		gbc_btn3Row2.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row2.gridx = 2;
		gbc_btn3Row2.gridy = 1;
		btn3Row2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn3Row2, colorSelected, gbc_btn3Row2.gridx, gbc_btn3Row2.gridy);
				resetMarbleSlots(btn3Row2);
			}
		});
		btn3Row2.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn3Row2, gbc_btn3Row2);

		btn4Row2 = new JButton("");
		GridBagConstraints gbc_btn4Row2 = new GridBagConstraints();
		gbc_btn4Row2.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row2.gridx = 3;
		gbc_btn4Row2.gridy = 1;
		btn4Row2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn4Row2, colorSelected, gbc_btn4Row2.gridx, gbc_btn4Row2.gridy);
				resetMarbleSlots(btn4Row2);
			}
		});
		btn4Row2.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn4Row2, gbc_btn4Row2);

		btn1Row3 = new JButton("");
		GridBagConstraints gbc_btn1Row3 = new GridBagConstraints();
		gbc_btn1Row3.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row3.gridx = 0;
		gbc_btn1Row3.gridy = 2;
		btn1Row3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn1Row3, colorSelected, gbc_btn1Row3.gridx, gbc_btn1Row3.gridy);
				resetMarbleSlots(btn1Row3);
			}
		});
		btn1Row3.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn1Row3, gbc_btn1Row3);

		btn2Row3 = new JButton("");
		GridBagConstraints gbc_btn2Row3 = new GridBagConstraints();
		gbc_btn2Row3.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row3.gridx = 1;
		gbc_btn2Row3.gridy = 2;
		btn2Row3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn2Row3, colorSelected, gbc_btn2Row3.gridx, gbc_btn2Row3.gridy);
				resetMarbleSlots(btn2Row3);
			}

		});
		btn2Row3.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn2Row3, gbc_btn2Row3);

		btn3Row3 = new JButton("");
		GridBagConstraints gbc_btn3Row3 = new GridBagConstraints();
		gbc_btn3Row3.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row3.gridx = 2;
		gbc_btn3Row3.gridy = 2;
		btn3Row3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn3Row3, colorSelected, gbc_btn3Row3.gridx, gbc_btn3Row3.gridy);
				resetMarbleSlots(btn3Row3);
			}
		});
		btn3Row3.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn3Row3, gbc_btn3Row3);

		btn4Row3 = new JButton("");
		GridBagConstraints gbc_btn4Row3 = new GridBagConstraints();
		gbc_btn4Row3.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row3.gridx = 3;
		gbc_btn4Row3.gridy = 2;
		btn4Row3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn4Row3, colorSelected, gbc_btn4Row3.gridx, gbc_btn4Row3.gridy);
				resetMarbleSlots(btn4Row3);
			}
		});
		btn4Row3.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn4Row3, gbc_btn4Row3);

		btn1Row4 = new JButton("");
		GridBagConstraints gbc_btn1Row4 = new GridBagConstraints();
		gbc_btn1Row4.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row4.gridx = 0;
		gbc_btn1Row4.gridy = 3;
		btn1Row4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn1Row4, colorSelected, gbc_btn1Row4.gridx, gbc_btn1Row4.gridy);
				resetMarbleSlots(btn1Row4);
			}
		});
		btn1Row4.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn1Row4, gbc_btn1Row4);

		btn2Row4 = new JButton("");
		GridBagConstraints gbc_btn2Row4 = new GridBagConstraints();
		gbc_btn2Row4.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row4.gridx = 1;
		gbc_btn2Row4.gridy = 3;
		btn2Row4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn2Row4, colorSelected, gbc_btn2Row4.gridx, gbc_btn2Row4.gridy);
				resetMarbleSlots(btn2Row4);
			}
		});
		btn2Row4.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn2Row4, gbc_btn2Row4);

		btn3Row4 = new JButton("");
		GridBagConstraints gbc_btn3Row4 = new GridBagConstraints();
		gbc_btn3Row4.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row4.gridx = 2;
		gbc_btn3Row4.gridy = 3;
		btn3Row4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn3Row4, colorSelected, gbc_btn3Row4.gridx, gbc_btn3Row4.gridy);
				resetMarbleSlots(btn3Row4);
			}
		});
		btn3Row4.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn3Row4, gbc_btn3Row4);

		btn4Row4 = new JButton("");
		GridBagConstraints gbc_btn4Row4 = new GridBagConstraints();
		gbc_btn4Row4.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row4.gridx = 3;
		gbc_btn4Row4.gridy = 3;
		btn4Row4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn4Row4, colorSelected, gbc_btn4Row4.gridx, gbc_btn4Row4.gridy);
				resetMarbleSlots(btn4Row4);
			}
		});
		btn4Row4.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn4Row4, gbc_btn4Row4);

		btn1Row5 = new JButton("");
		GridBagConstraints gbc_btn1Row5 = new GridBagConstraints();
		gbc_btn1Row5.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row5.gridx = 0;
		gbc_btn1Row5.gridy = 4;
		btn1Row5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn1Row5, colorSelected, gbc_btn1Row5.gridx, gbc_btn1Row5.gridy);
				resetMarbleSlots(btn1Row5);
			}
		});
		btn1Row5.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn1Row5, gbc_btn1Row5);

		btn2Row5 = new JButton("");
		GridBagConstraints gbc_btn2Row5 = new GridBagConstraints();
		gbc_btn2Row5.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row5.gridx = 1;
		gbc_btn2Row5.gridy = 4;
		btn2Row5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn2Row5, colorSelected, gbc_btn2Row5.gridx, gbc_btn2Row5.gridy);
				resetMarbleSlots(btn2Row5);
			}
		});
		btn2Row5.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn2Row5, gbc_btn2Row5);

		btn3Row5 = new JButton("");
		GridBagConstraints gbc_btn3Row5 = new GridBagConstraints();
		gbc_btn3Row5.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row5.gridx = 2;
		gbc_btn3Row5.gridy = 4;
		btn3Row5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn3Row5, colorSelected, gbc_btn3Row5.gridx, gbc_btn3Row5.gridy);
				resetMarbleSlots(btn3Row5);
			}
		});
		btn3Row5.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn3Row5, gbc_btn3Row5);

		btn4Row5 = new JButton("");
		GridBagConstraints gbc_btn4Row5 = new GridBagConstraints();
		gbc_btn4Row5.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row5.gridx = 3;
		gbc_btn4Row5.gridy = 4;
		btn4Row5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn4Row5, colorSelected, gbc_btn4Row5.gridx, gbc_btn4Row5.gridy);
				resetMarbleSlots(btn4Row5);
			}
		});
		btn4Row5.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn4Row5, gbc_btn4Row5);

		btn1Row6 = new JButton("");
		GridBagConstraints gbc_btn1Row6 = new GridBagConstraints();
		gbc_btn1Row6.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row6.gridx = 0;
		gbc_btn1Row6.gridy = 5;
		btn1Row6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn1Row6, colorSelected, gbc_btn1Row6.gridx, gbc_btn1Row6.gridy);
				resetMarbleSlots(btn1Row6);
			}
		});
		btn1Row6.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn1Row6, gbc_btn1Row6);

		btn2Row6 = new JButton("");
		GridBagConstraints gbc_btn2Row6 = new GridBagConstraints();
		gbc_btn2Row6.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row6.gridx = 1;
		gbc_btn2Row6.gridy = 5;
		btn2Row6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn2Row6, colorSelected, gbc_btn2Row6.gridx , gbc_btn2Row6.gridy);
				resetMarbleSlots(btn2Row6);
			}
		});
		btn2Row6.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn2Row6, gbc_btn2Row6);

		btn3Row6 = new JButton("");
		GridBagConstraints gbc_btn3Row6 = new GridBagConstraints();
		gbc_btn3Row6.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row6.gridx = 2;
		gbc_btn3Row6.gridy = 5;
		btn3Row6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn3Row6, colorSelected, gbc_btn3Row6.gridx, gbc_btn3Row6.gridy);
				resetMarbleSlots(btn3Row6);
			}
		});
		btn3Row6.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn3Row6, gbc_btn3Row6);

		btn4Row6 = new JButton("");
		GridBagConstraints gbc_btn4Row6 = new GridBagConstraints();
		gbc_btn4Row6.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row6.gridx = 3;
		gbc_btn4Row6.gridy = 5;
		btn4Row6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn4Row6, colorSelected, gbc_btn4Row6.gridx, gbc_btn4Row6.gridy);
				resetMarbleSlots(btn4Row6);
			}
		});
		btn4Row6.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn4Row6, gbc_btn4Row6);

		btn1Row7 = new JButton("");
		GridBagConstraints gbc_btn1Row7 = new GridBagConstraints();
		gbc_btn1Row7.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row7.gridx = 0;
		gbc_btn1Row7.gridy = 6;
		btn1Row7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn1Row7, colorSelected, gbc_btn1Row7.gridx, gbc_btn1Row7.gridy);
				resetMarbleSlots(btn1Row7);
			}
		});
		btn1Row7.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn1Row7, gbc_btn1Row7);

		btn2Row7 = new JButton("");
		GridBagConstraints gbc_btn2Row7 = new GridBagConstraints();
		gbc_btn2Row7.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row7.gridx = 1;
		gbc_btn2Row7.gridy = 6;
		btn2Row7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn2Row7, colorSelected, gbc_btn2Row7.gridx, gbc_btn2Row7.gridy);
				resetMarbleSlots(btn2Row7);
			}
		});
		btn2Row7.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn2Row7, gbc_btn2Row7);

		btn3Row7 = new JButton("");
		GridBagConstraints gbc_btn3Row7 = new GridBagConstraints();
		gbc_btn3Row7.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row7.gridx = 2;
		gbc_btn3Row7.gridy = 6;
		btn3Row7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn3Row7, colorSelected, gbc_btn3Row7.gridx, gbc_btn3Row7.gridy);
				resetMarbleSlots(btn3Row7);
			}
		});
		btn3Row7.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn3Row7, gbc_btn3Row7);

		btn4Row7 = new JButton("");
		GridBagConstraints gbc_btn4Row7 = new GridBagConstraints();
		gbc_btn4Row7.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row7.gridx = 3;
		gbc_btn4Row7.gridy = 6;
		btn4Row7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn4Row7, colorSelected, gbc_btn4Row7.gridx, gbc_btn4Row7.gridy);
				resetMarbleSlots(btn4Row7);
			}
		});
		btn4Row7.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn4Row7, gbc_btn4Row7);

		btn1Row8 = new JButton("");
		GridBagConstraints gbc_btn1Row8 = new GridBagConstraints();
		gbc_btn1Row8.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row8.gridx = 0;
		gbc_btn1Row8.gridy = 7;
		btn1Row8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn1Row8, colorSelected, gbc_btn1Row8.gridx, gbc_btn1Row8.gridy);
				resetMarbleSlots(btn1Row8);
			}
		});
		btn1Row8.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn1Row8, gbc_btn1Row8);

		btn2Row8 = new JButton("");
		GridBagConstraints gbc_btn2Row8 = new GridBagConstraints();
		gbc_btn2Row8.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row8.gridx = 1;
		gbc_btn2Row8.gridy = 7;
		btn2Row8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn2Row8, colorSelected, gbc_btn2Row8.gridx, gbc_btn2Row8.gridy);
				resetMarbleSlots(btn2Row8);
			}
		});
		btn2Row8.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn2Row8, gbc_btn2Row8);

		btn3Row8 = new JButton("");
		GridBagConstraints gbc_btn3Row8 = new GridBagConstraints();
		gbc_btn3Row8.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row8.gridx = 2;
		gbc_btn3Row8.gridy = 7;
		btn3Row8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn3Row8, colorSelected, gbc_btn3Row8.gridx, gbc_btn3Row8.gridy);
				resetMarbleSlots(btn3Row8);
			}
		});
		btn3Row8.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn3Row8, gbc_btn3Row8);

		btn4Row8 = new JButton("");
		GridBagConstraints gbc_btn4Row8 = new GridBagConstraints();
		gbc_btn4Row8.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row8.gridx = 3;
		gbc_btn4Row8.gridy = 7;
		btn4Row8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn4Row8, colorSelected, gbc_btn4Row8.gridx, gbc_btn4Row8.gridy);
				resetMarbleSlots(btn4Row8);
			}
		});
		btn4Row8.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn4Row8, gbc_btn4Row8);

		btn1Row9 = new JButton("");
		GridBagConstraints gbc_btn1Row9 = new GridBagConstraints();
		gbc_btn1Row9.insets = new Insets(0, 0, 5, 5);
		gbc_btn1Row9.gridx = 0;
		gbc_btn1Row9.gridy = 8;
		btn1Row9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn1Row9, colorSelected, gbc_btn1Row9.gridx, gbc_btn1Row9.gridy);
				resetMarbleSlots(btn1Row9);
			}
		});
		btn1Row9.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn1Row9, gbc_btn1Row9);

		btn2Row9 = new JButton("");
		GridBagConstraints gbc_btn2Row9 = new GridBagConstraints();
		gbc_btn2Row9.insets = new Insets(0, 0, 5, 5);
		gbc_btn2Row9.gridx = 1;
		gbc_btn2Row9.gridy = 8;
		btn2Row9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn2Row9, colorSelected, gbc_btn2Row9.gridx, gbc_btn2Row9.gridy);
				resetMarbleSlots(btn2Row9);
			}
		});
		btn2Row9.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn2Row9, gbc_btn2Row9);

		btn3Row9 = new JButton("");
		GridBagConstraints gbc_btn3Row9 = new GridBagConstraints();
		gbc_btn3Row9.insets = new Insets(0, 0, 5, 5);
		gbc_btn3Row9.gridx = 2;
		gbc_btn3Row9.gridy = 8;
		btn3Row9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn3Row9, colorSelected, gbc_btn3Row9.gridx, gbc_btn3Row9.gridy);
				resetMarbleSlots(btn3Row9);
			}
		});
		btn3Row9.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn3Row9, gbc_btn3Row9);

		btn4Row9 = new JButton("");
		GridBagConstraints gbc_btn4Row9 = new GridBagConstraints();
		gbc_btn4Row9.insets = new Insets(0, 0, 5, 0);
		gbc_btn4Row9.gridx = 3;
		gbc_btn4Row9.gridy = 8;
		btn4Row9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn4Row9, colorSelected, gbc_btn4Row9.gridx, gbc_btn4Row9.gridy);
				resetMarbleSlots(btn4Row9);
			}
		});
		btn4Row9.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn4Row9, gbc_btn4Row9);

		btn1Row10 = new JButton("");
		GridBagConstraints gbc_btn1Row10 = new GridBagConstraints();
		gbc_btn1Row10.insets = new Insets(0, 0, 0, 5);
		gbc_btn1Row10.gridx = 0;
		gbc_btn1Row10.gridy = 9;
		btn1Row10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn1Row10, colorSelected, gbc_btn1Row10.gridx, gbc_btn1Row10.gridy);
				resetMarbleSlots(btn1Row10);
			}
		});
		btn1Row10.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn1Row10, gbc_btn1Row10);

		btn2Row10 = new JButton("");
		GridBagConstraints gbc_btn2Row10 = new GridBagConstraints();
		gbc_btn2Row10.insets = new Insets(0, 0, 0, 5);
		gbc_btn2Row10.gridx = 1;
		gbc_btn2Row10.gridy = 9;
		btn2Row10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn2Row10, colorSelected, gbc_btn2Row10.gridx, gbc_btn2Row10.gridy);
				resetMarbleSlots(btn2Row10);
			}
		});
		btn2Row10.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn2Row10, gbc_btn2Row10);

		btn3Row10 = new JButton("");
		GridBagConstraints gbc_btn3Row10 = new GridBagConstraints();
		gbc_btn3Row10.insets = new Insets(0, 0, 0, 5);
		gbc_btn3Row10.gridx = 2;
		gbc_btn3Row10.gridy = 9;
		btn3Row10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn3Row10, colorSelected, gbc_btn3Row10.gridx, gbc_btn3Row10.gridy);
				resetMarbleSlots(btn3Row10);
			}
		});
		btn3Row10.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn3Row10, gbc_btn3Row10);

		btn4Row10 = new JButton("");
		GridBagConstraints gbc_btn4Row10 = new GridBagConstraints();
		gbc_btn4Row10.gridx = 3;
		gbc_btn4Row10.gridy = 9;
		btn4Row10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeMarbleColor(btn4Row10, colorSelected, gbc_btn4Row10.gridx, gbc_btn4Row10.gridy);
				resetMarbleSlots(btn4Row10);
			}
		});
		btn4Row10.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
		panelGame.add(btn4Row10, gbc_btn4Row10);
	}

	/**
	 * This method changes the marble slot to the color selected
	 * @param btn
	 * @param colorSelected
	 */
	private void changeMarbleColor(JButton btn, String colorSelected, int x, int y) {
		boolean isChangable = marbleGrid[y][x];
		
		if(colorSelected != "" && isChangable != false){
			btn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/" + colorSelected)));
			Codes pickedColor = null;
            switch(colorSelected) {
            case "BlackMarble.JPG":
            	pickedColor = Codes.BLACK;
                //playerCodes.add(Codes.BLACK);
                break;
            case "BlueMarble.JPG":
            	pickedColor = Codes.BLUE;
                //playerCodes.add(Codes.BLUE);
                break;
            case "GreenMarble.JPG":
            	pickedColor = Codes.GREEN;
                //playerCodes.add(Codes.GREEN);
                break;
            case "RedMarble.JPG":
            	pickedColor = Codes.RED;
                //playerCodes.add(Codes.RED);
                break;
            case "WhiteMarble.JPG":
            	pickedColor = Codes.WHITE;
                //playerCodes.add(Codes.WHITE);
                break;
            case "YellowMarble.JPG":
            	pickedColor = Codes.YELLOW;
                //playerCodes.add(Codes.YELLOW);
                break;
        }
            colorArray[y][x] = pickedColor;

          
            for(int i = 0; i < 4; i++) {
            	System.out.println(colorArray[guiRow][i]);
            }
            //System.out.println(colorSelected);
            //System.out.println(playerCodes);
			colorSelected = "";
			
		}
	}

	/**
	 * This method will reset the marble slot to the empty slots like the beginning of the game
	 * @param btn
	 */
	private void resetMarbleSlots(JButton btn) {

			//btn.setIcon(new ImageIcon(Board.class.getResource("/marbleIcons/BlankMarble.jpg")));
	
	}
	/**
	 * This disables the current row once the submit button is hit
	 * @param guiRow
	 */
	private void disableCurrentRow(int guiRow) {
		for(int i = 0; i < 4; i++) {
			marbleGrid[guiRow][i] = false;
		}
		
	}
	
	/**
	 * This enables the next row to true so the marble slots are changeable
	 * @param guiRow
	 */
	private void enableNextRow(int guiRow) {
		System.out.println(guiRow);
<<<<<<< HEAD
		if(guiRow < 9 && !win) {
=======
		if(guiRow < 9) {
>>>>>>> 43c7ff686dbe82a1e3de24c69849745bc2a46843
			int nextGuiRow = guiRow + 1;
				for(int i = 0; i < 4; i++) {
					marbleGrid[nextGuiRow][i] = true;
				}
		}
		
	}
	
	/**
	 * This creates a 2D boolean array for the buttons
	 * Making sure they are set to true at the beginning of the game.
	 */
	private void resetMarbleGridArray() {
		for(int i = 0; i < 10; i++) {
			
			for(int j = 0; j < 4; j++) {
				marbleGrid[i][j] = false;
			}
		}
		//Sets the first row to true	
		for(int j = 0; j < 4; j++) {
			marbleGrid[0][j] = true;
		}
	}
}
