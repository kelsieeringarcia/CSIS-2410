package flights;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.NumberFormat;

public class GUI extends JFrame {
    // SQL Connection
    private static final String databaseURL =
            "jdbc:derby:FlightsDB;create=true";

    // GUI Components
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox inputAirline;
    private JFormattedTextField inputNumber;
    private JComboBox inputAirport;
    private JComboBox inputStatus;
    private JComboBox inputGate;
    private JTextField inputDate;
    private JTextField inputTime;
    private JFormattedTextField inputDuration;
    private JButton btnAddFlight;
    private JButton btnRemoveFlight;

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

    GUI() {
        try (Connection connection = DriverManager.getConnection("jdbc:derby:FlightsDB;create=true");
             Statement statement = connection.createStatement()) {

            // Reset data in between testing
            SqlGeneric.resetTables();

            // TODO split sections into separate methods

            // Window
            this.setLayout(new BorderLayout());
            JPanel topPanel = new JPanel(new BorderLayout());
            JPanel bottomPanel = new JPanel(new BorderLayout());

            // Top Panel
            JTextField searchbar = new JTextField();
            // TODO replace with table and column names
            JComboBox comboColumn = new JComboBox(new String[]{"Destination"});
            JComboBox comboTable = new JComboBox(new String[]{"Flight Table"});
            searchbar.setPreferredSize(new Dimension(260,26));
            JButton btnSearch = new JButton("Search");
            this.add(topPanel, BorderLayout.NORTH);
            topPanel.setBackground(Color.MAGENTA);
            FlowLayout flowLayout = new FlowLayout();
            flowLayout.setAlignment(FlowLayout.RIGHT);
            topPanel.setLayout(flowLayout);

            topPanel.add(comboTable);
            topPanel.add(comboColumn);
            topPanel.add(searchbar);
            topPanel.add(btnSearch);

            // Table
            createJTable();
            JScrollPane pane = new JScrollPane(table);
            this.add(pane, BorderLayout.CENTER);

            // Bottom
            bottomPanel.setBackground(Color.YELLOW);
            this.add(bottomPanel, BorderLayout.SOUTH);
            bottomPanel.setLayout(flowLayout);
            // TODO replace hardcoded values with contents of airline and airport tables
            inputAirline = new JComboBox(new String[]{
                    "AA", "AS", "DL", "UA", "WN"});
            NumberFormat numberFormat = NumberFormat.getNumberInstance();
            inputNumber = new JFormattedTextField(numberFormat);
            inputNumber.setValue(0);
            inputNumber.setColumns(4);
            inputNumber.setPreferredSize(new Dimension(40,26));
            inputAirport = new JComboBox(new String[]{
                    "KSLC", "EGLL", "KDEN", "KJFK", "KSFO", "KLAX"});
            inputStatus = new JComboBox(new String[]{
                    "On Time", "Now Boarding", "Delayed", "Canceled"});
            inputGate = new JComboBox(new String[]{
                    "A01", "A02", "A03", "A04", "A05",
                    "B01", "B02", "B03", "B04", "B05",
                    "C01", "C02", "C03", "C04", "C05"});
            inputDate = new JTextField("Date");
            inputDate.setPreferredSize(new Dimension(56,26));
            inputTime = new JTextField("Time");
            inputTime.setPreferredSize(new Dimension(56,26));
            inputDuration = new JFormattedTextField(numberFormat);
            inputNumber.setValue(0);
            inputDuration.setPreferredSize(new Dimension(56,26));

            btnAddFlight = new JButton("Add Flight");
            btnRemoveFlight = new JButton("Remove Flight");

            bottomPanel.add(inputAirline);
            bottomPanel.add(inputNumber);
            bottomPanel.add(inputAirport);
            bottomPanel.add(inputStatus);
            bottomPanel.add(inputGate);
            bottomPanel.add(inputDate);
            bottomPanel.add(inputTime);
            bottomPanel.add(inputDuration);

            bottomPanel.add(btnAddFlight);
            btnAddFlight.addActionListener(e -> addFlight());
            bottomPanel.add(btnRemoveFlight);
            this.pack();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addFlight() {
        String airlineId = String.valueOf(inputAirline.getSelectedItem());
        int number = Integer.parseInt(inputNumber.getText());
        String airportId = String.valueOf(inputAirport.getSelectedItem());
        String statusString = String.valueOf(inputStatus.getSelectedItem());
        int status = 0;
        if (statusString.equals("Now Boarding"))
            status = 1;
        if (statusString.equals("Delayed"))
            status = 2;
        if (statusString.equals("Canceled"))
            status = 3;
        // Else status defaults to 0 which equals "On Time" status
        String gate = String.valueOf(inputGate.getSelectedItem());
        String date = String.valueOf(inputDate.getText());
        String time = String.valueOf(inputTime.getText());
        int duration = Integer.parseInt(inputDuration.getText());

        try (Connection connection = DriverManager.getConnection(databaseURL);
                    Statement statement = connection.createStatement()) {

            statement.execute(SqlFlight.insertValue(airlineId, number, airportId, status, gate, date, time, duration));
            updateJTable();
        }
        catch (SQLException e) {
            System.err.println("There was a problem adding a flight.");
            e.printStackTrace();
        }
    }

    private void createJTable() {
        try (Connection connection = DriverManager.getConnection(databaseURL);
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(SqlFlight.getAllSortedWithNames(SqlColumn.AIRLINE_NAME));
            ResultSetMetaData rsmd = rs.getMetaData();

            Object[] columnLabels;
            int colNo = rsmd.getColumnCount();
            columnLabels = new Object[colNo];
            for (int i = 0; i < colNo; i++) {
                columnLabels[i] = rsmd.getColumnLabel(i + 1);
            }

            table = new JTable(new DefaultTableModel(columnLabels, 0));
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

    private void updateJTable() {
        try (Connection connection = DriverManager.getConnection(databaseURL);
             Statement statement = connection.createStatement()) {

            ResultSet rs = statement.executeQuery(SqlFlight.getAllSortedWithNames(SqlColumn.AIRLINE_NAME));
            ResultSetMetaData rsmd = rs.getMetaData();

            Object[] columnLabels;
            int colNo = rsmd.getColumnCount();
            columnLabels = new Object[colNo];
            for (int i = 0; i < colNo; i++) {
                columnLabels[i] = rsmd.getColumnLabel(i + 1);
            }

            if (tableModel.getRowCount() > 0) {
                for (int i = tableModel.getRowCount() - 1; i > -1; i--) {
                    tableModel.removeRow(i);
                }
            }

            while (rs.next()) {
                Object[] objects = new Object[colNo];
                for (int i = 0; i < colNo; i++) {
                    objects[i] = rs.getObject(i + 1); // SQL is indexes start at 1
                }
                tableModel.addRow(objects);
            }
            tableModel.fireTableDataChanged();
            table.setModel(tableModel);
        }
        catch (SQLException e){
            System.err.println("There was a problem updating the JTable.");
            e.printStackTrace();
        }
    }
}