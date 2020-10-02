package flights;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;


public class FlightGui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JList selectList;
	private String[] selectArr = {"*", "Airline Name", "Flight Number", "Status Description",
			"Destination", "Gate", "Date", "Time", "Duration", "Airport City", "Airport Name"};
	private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightGui frame = new FlightGui();
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
	public FlightGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{50, 0, 0, 0, 0, 102, 66, 0};
		gbl_panel_1.rowHeights = new int[]{50, -4, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		selectMethod(panel_1);
		
		fromMethod(panel_1);
		
		whereMethod(panel_1);
		
		
		addRemoveUpdate();
		
		JButton submitBtn = new JButton("Submit");
		contentPane.add(submitBtn, BorderLayout.SOUTH);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.CENTER);
	}

	private void addRemoveUpdate() {
		JPanel addRemoveUpdateBtns = new JPanel();
		GridBagConstraints gbc_addRemoveUpdateBtns = new GridBagConstraints();
		gbc_addRemoveUpdateBtns.insets = new Insets(0, 0, 5, 0);
		gbc_addRemoveUpdateBtns.fill = GridBagConstraints.BOTH;
		gbc_addRemoveUpdateBtns.gridx = 6;
		gbc_addRemoveUpdateBtns.gridy = 0;
		panel_1.add(addRemoveUpdateBtns, gbc_addRemoveUpdateBtns);
		addRemoveUpdateBtns.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton addBtn = new JButton("ADD");
		addRemoveUpdateBtns.add(addBtn);
		
		JButton updateBtn = new JButton("Update");
		addRemoveUpdateBtns.add(updateBtn);
		
		JButton removeBtn = new JButton("Remove selected");
		addRemoveUpdateBtns.add(removeBtn);
	}

	private void whereMethod(JPanel panel) {
		JLabel whereLbl = new JLabel("Where:");
		GridBagConstraints gbc_whereLbl = new GridBagConstraints();
		gbc_whereLbl.anchor = GridBagConstraints.EAST;
		gbc_whereLbl.insets = new Insets(0, 0, 5, 5);
		gbc_whereLbl.gridx = 2;
		gbc_whereLbl.gridy = 0;
		panel.add(whereLbl, gbc_whereLbl);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 3;
		gbc_list.gridy = 0;
		panel_1.add(list, gbc_list);
		
		JLabel equalsLbl = new JLabel("=");
		GridBagConstraints gbc_equalsLbl = new GridBagConstraints();
		gbc_equalsLbl.insets = new Insets(0, 0, 5, 5);
		gbc_equalsLbl.anchor = GridBagConstraints.EAST;
		gbc_equalsLbl.gridx = 4;
		gbc_equalsLbl.gridy = 0;
		panel_1.add(equalsLbl, gbc_equalsLbl);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
	}

	private void fromMethod(JPanel panel) {
	}

	private void selectMethod(JPanel panel) {
		JLabel selectLbl = new JLabel("Select:");
		GridBagConstraints gbc_selectLbl = new GridBagConstraints();
		gbc_selectLbl.insets = new Insets(0, 0, 5, 5);
		gbc_selectLbl.gridx = 0;
		gbc_selectLbl.gridy = 0;
		panel.add(selectLbl, gbc_selectLbl);
		
		
		JList selectList = new JList(selectArr);
		selectList.setVisibleRowCount(-1);
		selectList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		//selectList.setLayoutOrientation(JList.VERTICAL);
        //selectList.setSelectedIndex(0);
        
        //add(new JScrollPane(selectList));
		GridBagConstraints gbc_selectList = new GridBagConstraints();
		gbc_selectList.insets = new Insets(0, 0, 5, 5);
		//gbc_selectList.fill = GridBagConstraints.BOTH;
		gbc_selectList.gridx = 1;
		gbc_selectList.gridy = 0;
		panel.add(selectList, gbc_selectList);
	}

}
