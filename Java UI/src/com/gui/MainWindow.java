package com.gui;

import com.mock.ServerQuery;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

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
    private JButton searchButton;
    private ServerQuery serverQuery;

    private String[] header;

    public MainWindow() {
        add(mainPanel);
        setTitle("Ticket Manager");
        setSize(1200, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        serverQuery = new ServerQuery();

        initTable();
        initListeners();
    }

    // Initializes table with default values
    private void initTable() {
        header = new String[]{"Title", "Status", "Priority", "Severity", "Assigned To"};

        String[][] data = serverQuery.getDefault();
        showTable(data);

    }

    // Creates table based on data model
    private void showTable(String[][] dataModel) {
        ticketTable = new JTable(dataModel, header) {
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

    // Initializes all listeners of the window
    private void initListeners() {
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

        searchButton.addActionListener(actionEvent -> {
            String query = searchTextField.getText();
            if(!query.isEmpty()) {
                String[][] searchData = serverQuery.getSearchResults(query);
                showTable(searchData);
            } else {
                initTable();
            }
        });

        routineCheckBox.addActionListener(actionEvent -> {
            AbstractButton routineButton = (AbstractButton) actionEvent.getSource();

            boolean selected = routineButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getSeveritySearchResults("Routine");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        urgentCheckBox.addActionListener(actionEvent -> {
            AbstractButton urgentButton = (AbstractButton) actionEvent.getSource();

            boolean selected = urgentButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getSeveritySearchResults("Urgent");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        criticalCheckBox.addActionListener(actionEvent -> {
            AbstractButton criticalButton = (AbstractButton) actionEvent.getSource();

            boolean selected = criticalButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getSeveritySearchResults("Critical");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        newCheckBox.addActionListener(actionEvent -> {
            AbstractButton newButton = (AbstractButton) actionEvent.getSource();

            boolean selected = newButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getSearchResults("New");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        openCheckBox.addActionListener(actionEvent -> {
            AbstractButton openButton = (AbstractButton) actionEvent.getSource();

            boolean selected = openButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getSearchResults("Open");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        closedCheckBox.addActionListener(actionEvent -> {
            AbstractButton closedButton = (AbstractButton) actionEvent.getSource();

            boolean selected = closedButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getSearchResults("Closed");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        a1CheckBox.addActionListener(actionEvent -> {
            AbstractButton priorityButton = (AbstractButton) actionEvent.getSource();

            boolean selected = priorityButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getPrioritySearchResults("1");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        a2CheckBox.addActionListener(actionEvent -> {
            AbstractButton priorityButton = (AbstractButton) actionEvent.getSource();

            boolean selected = priorityButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getPrioritySearchResults("2");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        a3CheckBox.addActionListener(actionEvent -> {
            AbstractButton priorityButton = (AbstractButton) actionEvent.getSource();

            boolean selected = priorityButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getPrioritySearchResults("3");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        a4CheckBox.addActionListener(actionEvent -> {
            AbstractButton priorityButton = (AbstractButton) actionEvent.getSource();

            boolean selected = priorityButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getPrioritySearchResults("4");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        a5CheckBox.addActionListener(actionEvent -> {
            AbstractButton priorityButton = (AbstractButton) actionEvent.getSource();

            boolean selected = priorityButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getPrioritySearchResults("5");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        a6CheckBox.addActionListener(actionEvent -> {
            AbstractButton priorityButton = (AbstractButton) actionEvent.getSource();

            boolean selected = priorityButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getPrioritySearchResults("6");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        a7CheckBox.addActionListener(actionEvent -> {
            AbstractButton priorityButton = (AbstractButton) actionEvent.getSource();

            boolean selected = priorityButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getPrioritySearchResults("7");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        a8CheckBox.addActionListener(actionEvent -> {
            AbstractButton priorityButton = (AbstractButton) actionEvent.getSource();

            boolean selected = priorityButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getPrioritySearchResults("8");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        a9CheckBox.addActionListener(actionEvent -> {
            AbstractButton priorityButton = (AbstractButton) actionEvent.getSource();

            boolean selected = priorityButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getPrioritySearchResults("9");
                showTable(searchData);
            } else {
                initTable();
            }
        });

        a10CheckBox.addActionListener(actionEvent -> {
            AbstractButton priorityButton = (AbstractButton) actionEvent.getSource();

            boolean selected = priorityButton.getModel().isSelected();
            if(selected) {
                String[][] searchData = serverQuery.getPrioritySearchResults("10");
                showTable(searchData);
            } else {
                initTable();
            }
        });
    }
}
