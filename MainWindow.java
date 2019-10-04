package com.testgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainWindow extends JFrame {

    private JTextField searchTextField;
    private JTable ticketTable;
    private JCheckBox a1CheckBox;
    private JCheckBox a2CheckBox;
    private JCheckBox a3CheckBox;
    private JButton addTicketButton;
    private JCheckBox a4CheckBox;
    private JCheckBox a5CheckBox;
    private JCheckBox a6CheckBox;
    private JCheckBox a7CheckBox;
    private JCheckBox a8CheckBox;
    private JCheckBox a9CheckBox;
    private JCheckBox a10CheckBox;
    private JCheckBox criticalCheckBox;
    private JCheckBox newCheckBox;
    private JCheckBox openCheckBox;
    private JCheckBox closedCheckBox;
    private JCheckBox routineCheckBox;
    private JCheckBox urgentCheckBox;
    private JPanel mainPanel;
    private JScrollPane tableScrollPane;
    private JPanel tablePanel;
    private JSplitPane splitPane;
    private JLabel priorityLabel;

    public MainWindow() {
        add(mainPanel);
        initTable();
        setTitle("Ticket Manager");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        addTicketButton.addActionListener(actionEvent -> {
            new AddTicket().setVisible(true);
        });

        ticketTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    new TicketView().setVisible(true);
                }
            }
        });
    }

    private void initTable() {
        String[] header = {"Title", "Status", "Priority", "Severity", "Assigned To"};

        Object[][] data = {
                {"Ticket 1", "Open", "10", "Urgent", "Juan Rincon"},
                {"Ticket 2", "Open", "3", "Routine", "Alex Ortega"},
                {"Ticket 3", "Open", "7", "Routine", "Daniel Maynez"},
                {"Ticket 4", "Open", "7", "Routine", "Daniel Villa"},
                {"Ticket 5", "Open", "5", "Critical", "George Juarez"},
                {"Ticket 6", "Open", "4", "Routine", "Miguel Camarillo"},
                {"Ticket 7", "Open", "2", "Urgent", "Paulina Cervantes"},
                {"Ticket 8", "Open", "9", "Critical", "Sam Tinevra"},
        };

        ticketTable = new JTable(data, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ticketTable.setPreferredScrollableViewportSize(new Dimension(500, 50));
        ticketTable.setFillsViewportHeight(true);
        ticketTable.setRowHeight(25);
        ticketTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
        ticketTable.setFont(new Font("Tahoma", Font.PLAIN, 12));
        ticketTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tableScrollPane.setViewportView(ticketTable);
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeLater(() -> {
            new MainWindow().setVisible(true);
        });
    }
}
