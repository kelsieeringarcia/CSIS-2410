package flights;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.NumberFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Gui class for our Flight Database.
 * @author Kelsie Garcia and Aiden Van Dyke
 *
 */
@SuppressWarnings("serial")
public class GUI extends JFrame {
    // SQL Connection
    private static final String databaseURL =
            "jdbc:derby:FlightsDB;create=true";

    // GUI Components
    private JPanel panelTop;
    private JPanel panelBottom;

    private JTable table;
    private DefaultTableModel tableModel;

    private JComboBox<String> inputSort;
    private JComboBox<String> inputAirline;
    private JFormattedTextField inputNumber;
    private JComboBox<String> inputAirport;
    private JComboBox<String> inputStatus;
    private JComboBox<String> inputGate;
    private JTextField inputDate;
    private JTextField inputTime;
    private JFormattedTextField inputDuration;
    private JButton btnAddFlight;
    private JButton btnRemoveFlight;
    private JButton btnUpdateFlight;
    private JTextField inputSearch;
    private JComboBox<String> inputSearchColumn;
    private int selectedFlightId;
    private int currentRow;
    private int colNo;

    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                GUI frame = new GUI();
                frame.setVisible(true);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    @SuppressWarnings("unused")
	GUI() {
    	try (Connection connection = DriverManager.getConnection("jdbc:derby:FlightsDB;create=true");
                Statement statement = connection.createStatement()) {

           // Reset data in between testing
           SqlGeneric.resetTables();

           // Window
           this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           this.setLayout(new BorderLayout());
           JPanel topPanel = new JPanel(new BorderLayout());
           JPanel bottomPanel = new JPanel(new BorderLayout());

           // Contents
           createPanelTop();
           createJTable();
           JScrollPane pane = new JScrollPane(table);
           pane.setBorder(new EmptyBorder(0,10,10,0));
           // Makes sure only one row can be selected at a time
           table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
           this.add(pane, BorderLayout.CENTER);
           createPanelBottom();

           // Finally
           this.pack();
       }
       catch (SQLException e) {
           e.printStackTrace();
       }
    }

    /**
     * Bottom panel
     */
	private void createPanelBottom() {
		 panelBottom = new JPanel(new FlowLayout());
	        panelBottom.setBackground(Color.CYAN);
	        this.add(panelBottom, BorderLayout.SOUTH);

			inputAirline = new JComboBox<String>();
			NumberFormat numberFormat = NumberFormat.getNumberInstance();
			numberFormat.setGroupingUsed(false);
			inputNumber = new JFormattedTextField(numberFormat);
			inputNumber.setValue(0);
			inputNumber.setColumns(4);
			inputNumber.setPreferredSize(new Dimension(40,26));
			inputAirport = new JComboBox<String>();
			inputStatus = new JComboBox<String>();
			inputGate = new JComboBox<String>();
			inputDate = new JTextField("Jan 01");
			inputDate.setPreferredSize(new Dimension(56,26));
			inputTime = new JTextField("00:00");
			inputTime.setPreferredSize(new Dimension(56,26));
			inputDuration = new JFormattedTextField(numberFormat);
	        inputDuration.setValue(0);
	        inputDuration.setColumns(4);
			inputDuration.setPreferredSize(new Dimension(56,26));
			
			btnAddFlight = new JButton("Add Flight");
			btnRemoveFlight = new JButton("Remove Flight");
			btnUpdateFlight = new JButton("Update Flight");

			panelBottom.add(inputAirline);
			panelBottom.add(inputNumber);
			panelBottom.add(inputAirport);
			panelBottom.add(inputStatus);
			panelBottom.add(inputGate);
			panelBottom.add(inputDate);
			panelBottom.add(inputTime);
			panelBottom.add(inputDuration);

			panelBottom.add(btnAddFlight);
			panelBottom.add(btnUpdateFlight);
	        panelBottom.add(btnRemoveFlight);

	        btnAddFlight.addActionListener(e -> addFlight());
	        btnUpdateFlight.addActionListener(e -> updateFlight());
	        btnRemoveFlight.addActionListener(e -> removeFlight());

			fillBottomComboboxes();
	}

	/**
	 * Top panel
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void createPanelTop() {
        panelTop = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelTop.setBackground(Color.CYAN);
        this.add(panelTop, BorderLayout.NORTH);

        // Sort portion
        JLabel lblSort = new JLabel("Sort: ");
        inputSort = new JComboBox(new String[]{
                "Airline",
                "Flight Number",
                "City",
                "Status",
                "Gate",
                "Date",
                "Time",
                "Duration"
        });
        inputSort.addActionListener(e -> sortJPanel());
        panelTop.add(lblSort);
        panelTop.add(inputSort);

        // Search portion
        // Not searching for numbers, too much effort
        inputSearch = new JTextField();
        inputSearchColumn = new JComboBox(new String[]{
                "Airline",
                "City",
                "Status",
                "Gate",
                "Date",
                "Time",
        });
        inputSearch.setPreferredSize(new Dimension(260,26));
        JButton btnSearch = new JButton("Search");
        panelTop.add(new JLabel(" In "));
        panelTop.add(inputSearchColumn);
        panelTop.add(inputSearch);
        panelTop.add(btnSearch);
        btnSearch.addActionListener(e -> searchJPanel());
    }

    /**
     * This method is meant to pull the data from the database and add to the JComboBox
     * Starting with airline ID 
     */
    private void fillBottomComboboxes() {
    	try (Connection connection = DriverManager.getConnection(databaseURL);
             Statement statement = connection.createStatement()) {
    		
    		//Retrieving column fields and adding to the combo boxes
            ResultSet rs = statement.executeQuery(SqlAirline.getAll());
            while(rs.next()) {
            	inputAirline.addItem(rs.getString("Id"));
            }
            rs = statement.executeQuery(SqlAirport.getAll());
            while(rs.next()) {
            	inputAirport.addItem(rs.getString("Id"));
            }
            rs = statement.executeQuery(SqlStatus.getAll());
            while(rs.next()) {
            	inputStatus.addItem(rs.getString("Description"));
            }
            rs = statement.executeQuery(SqlGate.getAll());
            while(rs.next()) {
            	inputGate.addItem(rs.getString("Id"));
            }
            
    	}catch (SQLException e) {
            System.err.println("There was a problem filling combo boxes.");
            e.printStackTrace();
        }
    }
    
    

    private void addFlight() {
        //Plugging into the prepared statement
        String update =  "INSERT INTO Flight (Airline, Number, Destination, Status, Gate, Date, Time, Duration) "
                + "VALUES ('" + inputAirline.getSelectedItem() + "', " + inputNumber.getText() + ", '" 
        		+ inputAirport.getSelectedItem() + "', " + SqlStatus.getId((String) inputStatus.getSelectedItem())
        		+ ", '" + inputGate.getSelectedItem() + "', '" + inputDate.getText() + "', '" + inputTime.getText() + "', " + inputDuration.getText() +")";
        
        try (Connection connection = DriverManager.getConnection(databaseURL);
				PreparedStatement statement = connection.prepareStatement(update)) {
			statement.executeUpdate();
			connection.close();
	        // Confirmation dialog
	        JOptionPane.showMessageDialog(null,"Flight added successfully.");
        } catch (SQLException e) {
            System.err.println("There was a problem adding the flight.");
            e.printStackTrace();
        }

        // Refresh the table display
        sortJPanel();
    }
    /**
     * This takes what is selected from the JTable and deletes the flight selected
     * from the table and the database
     */
	private void removeFlight() {
		// check for selected row first
		if (table.getSelectedRow() != -1) {
			// remove selected row from the model
			tableModel.removeRow(table.getSelectedRow());
		}
		String update = "DELETE "
    			+"FROM Flight "
    			+ "WHERE Flight.Id = " + selectedFlightId;
		try (Connection connection = DriverManager.getConnection(databaseURL);
				PreparedStatement statement = connection.prepareStatement(update)) {
			statement.executeUpdate();
			connection.close();
			//confirmation dialog
			JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
		} catch (SQLException e) {
			System.err.println("There was a problem deleting the flight.");
			e.printStackTrace();
		}
	}
	/**
	 * This method takes the current selected flight on the JTable and updates the fields
	 * and database when the button "update" is pressed
	 */
	private void updateFlight() { 
        //Updates the values on the JTable
        int i = table.getSelectedRow();
        table.setValueAt(SqlAirline.getId((String) inputAirline.getSelectedItem()), i, 1);
        System.out.println(SqlAirline.getId((String) inputAirline.getSelectedItem()));
        table.setValueAt(inputNumber.getText(), i, 2);
        table.setValueAt(SqlAirport.getId((String) inputAirport.getSelectedItem()), i, 3);
        table.setValueAt(SqlStatus.getId((String) inputStatus.getSelectedItem()), i, 4);
        table.setValueAt(inputGate.getSelectedItem(), i, 5);
        table.setValueAt(inputDate.getText(), i, 6);
        table.setValueAt(inputTime.getText(), i, 7);
        table.setValueAt(inputDuration.getText(), i, 8);
        //Plugging into prepared statement
        String update = "UPDATE Flight "
        	  + "SET Airline = '" + inputAirline.getSelectedItem() + "', Number = " + inputNumber.getText() + ", Destination = '" + inputAirport.getSelectedItem()
        	  + "', Status = " + SqlStatus.getId((String) inputStatus.getSelectedItem()) + ", Gate = '" + inputGate.getSelectedItem() 
        	  + "', Date = '" + inputDate.getText() + "', Time = '" + inputTime.getText() + "', Duration = " 
        	  + inputDuration.getText()  
        	  +" WHERE Flight.Id = " + selectedFlightId;
        			try (Connection connection = DriverManager.getConnection(databaseURL);
        					PreparedStatement statement = connection.prepareStatement(update)) {
        				statement.executeUpdate();
        				connection.close();
        		        // Confirmation dialog
        		        JOptionPane.showMessageDialog(null,"Flight updated successfully.");
        			} catch (SQLException e) {
        				System.err.println("There was a problem updating the flight.");
        				e.printStackTrace();
        			}

        // Refresh the table display
        sortJPanel();

    }
       	
	/**
	 * Creates the JTable with the original data
	 */
    private void createJTable() {
        try (Connection connection = DriverManager.getConnection(databaseURL);
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(SqlFlight.getAllSortedWithNames(SqlColumn.FLIGHT_AIRLINE.getColumn()));
            ResultSetMetaData rsmd = rs.getMetaData();

            Object[] columnLabels;
            int colNo = rsmd.getColumnCount();
            columnLabels = new Object[colNo];
            for (int i = 0; i < colNo; i++) {
                columnLabels[i] = rsmd.getColumnLabel(i + 1);
                
            }

            table = new JTable(new DefaultTableModel(columnLabels, 0) {
                private static final long serialVersionUID = 1L;

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                };
            });
            table.addMouseListener(new MouseAdapter() {
            	@Override
            	public void mouseClicked(MouseEvent e) {
            	    updateInputPanel();
            	}
            });
            tableModel = (DefaultTableModel) table.getModel();

            while (rs.next()) {
                Object[] objects = new Object[colNo];
                for (int i = 0; i < colNo; i++) {
                    objects[i] = rs.getObject(i + 1); // SQL is indexes start at 1
                }
                tableModel.addRow(objects);
            }
            table.setModel(tableModel);
        }
        catch (SQLException e){
            System.err.println("There was a problem updating the JTable.");
            e.printStackTrace();
        }
    }

    /**
     * Updates JTable after every action
     * @param sqlQuery
     */
    private void updateJTable(String sqlQuery) {
        try (Connection connection = DriverManager.getConnection(databaseURL);
             Statement statement = connection.createStatement()) {


            ResultSet rs = statement.executeQuery(sqlQuery);
            ResultSetMetaData rsmd = rs.getMetaData();

            // Get table labels
            Object[] columnLabels;
            colNo = rsmd.getColumnCount();
            columnLabels = new Object[colNo];
            for (int i = 0; i < colNo; i++) {
                columnLabels[i] = rsmd.getColumnLabel(i + 1);
            }

            // Remove all rows and reset
            if (tableModel.getRowCount() > 0) {
                for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                    tableModel.removeRow(i);
                }
            }

            // (Re)Add rows to table
            while (rs.next()) {
                Object[] objects = new Object[colNo];
                for (int i = 0; i < colNo; i++) {
                    objects[i] = rs.getObject(i + 1); // SQL indexes start at 1
                }
                tableModel.addRow(objects);
                
            }

            tableModel.fireTableDataChanged();
            table.setModel(tableModel);

            // Blank flight Id
            selectedFlightId = 0;
        }
        catch (SQLException e){
            System.err.println("There was a problem updating the JTable.");
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("preview")
	private void sortJPanel() {
        // Get right column to sort by
        String columnName = switch (inputSort.getSelectedItem().toString()) {
            case "Flight Number" -> "Flight.Number";
            case "City" -> "Airport.City";
            case "Status" -> "Status.Description";
            case "Gate" -> "Flight.Gate";
            case "Date" -> "Flight.Date";
            case "Time" -> "Flight.Time";
            case "Duration" -> "Flight.Duration";
            default -> "Flight.Airline";
        };
        updateJTable(SqlFlight.getAllSortedWithNames(columnName));
    }

    @SuppressWarnings("preview")
	private void searchJPanel() {
        String columnName = switch (inputSearchColumn.getSelectedItem().toString()) {
            case "City" -> "Airport.City";
            case "Status" -> "Status.Description";
            case "Gate" -> "Flight.Gate";
            case "Date" -> "Flight.Date";
            case "Time" -> "Flight.Time";
            default -> "Airline.Name";
        };
        updateJTable(SqlFlight.getAllMatching(columnName,inputSearch.getText()));
    }
    
    private void updateInputPanel() {
        //This updates the JComboBoxes with the data selected on the table
        currentRow = table.getSelectedRow();
        selectedFlightId = Integer.parseInt(tableModel.getValueAt(currentRow, 0).toString());
        inputAirline.setSelectedItem(SqlAirline.getId(tableModel.getValueAt(currentRow, 1).toString()));
        inputNumber.setText(tableModel.getValueAt(currentRow, 2).toString());
        inputAirport.setSelectedItem(SqlAirport.getId(tableModel.getValueAt(currentRow,3).toString()));
        inputStatus.setSelectedItem(tableModel.getValueAt(currentRow, 4).toString());
        inputGate.setSelectedItem(tableModel.getValueAt(currentRow,5).toString());
        inputDate.setText(tableModel.getValueAt(currentRow, 6).toString());
        inputTime.setText(tableModel.getValueAt(currentRow, 7).toString());
        inputDuration.setText(tableModel.getValueAt(currentRow, 8).toString());
    }

}