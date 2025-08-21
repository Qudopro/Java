package com.qudopro.ch24;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;

public class DisplayQueryResults extends JFrame {
    public static final String DEFAULT_QUERY = "SELECT * FROM authors";
    public static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:8889/apple?";           //Protocolo:subprotocolo:localización
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    private static ResultSetTableModel tableModel;

    public DisplayQueryResults(){
        //Create ResultSetTableModel & Display database table
        try{
            //Create TableModel for results of query
            tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);

            //Set up JTextArea in which user types queries
            final JTextArea queryArea = new JTextArea(DEFAULT_QUERY, 3, 100);           //Usada desde clases internas anonimas
            queryArea.setWrapStyleWord(true);
            queryArea.setLineWrap(true);

            JScrollPane scrollPane = new JScrollPane(queryArea,
                    ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                    ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
                    );

            //Set up JButton for submitting queries
            JButton submitButton = new JButton("Submit query");

            //Create Box to manage placement of queryArea & Submit Button in GUI
            Box boxNorth = Box.createHorizontalBox();
            boxNorth.add(scrollPane);
            boxNorth.add(submitButton);

            //Create JTable based on the TableModel
            JTable resultTable = new JTable(tableModel);
            JLabel filterLabel = new JLabel("Filter: ");
            final JTextField filterText = new JTextField();                                 //Usada desde clases internas anonimas
            JButton filterButton = new JButton("Apply Filter");

            Box boxSouth = Box.createHorizontalBox();
            boxSouth.add(filterLabel);
            boxSouth.add(filterText);
            boxSouth.add(filterButton);


            //Place GUI Components on JFrame's content pane
            JFrame window = new JFrame("Displaying Query results");
            add(boxNorth, BorderLayout.NORTH);
            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxSouth, BorderLayout.SOUTH);

            //Create Event listener for submitButton
            submitButton.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //Perform a new query
                            try{
                                tableModel.setQuery(queryArea.getText());
                            }catch (IllegalStateException sqlException) {
                                JOptionPane.showMessageDialog(null, sqlException.getMessage(),
                                        "Database error", JOptionPane.ERROR_MESSAGE);

                                //Try to recover from invalid user query
                                try {
                                    tableModel.setQuery(DEFAULT_QUERY);
                                    queryArea.setText(DEFAULT_QUERY);
                                } catch (IllegalStateException sqlException1) {
                                    JOptionPane.showMessageDialog(null, sqlException1.getMessage(),
                                            "Database error", JOptionPane.ERROR_MESSAGE);

                                    tableModel.disconnectFromDatabase();
                                    System.exit(1);
                                }
                            }
                        }
                    }
            );
            final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);           //Usada desde clase interna anonima
            resultTable.setRowSorter(sorter);

            //Create listener for filterButtor
            filterButton.addActionListener(
                    new ActionListener() {
                        //Pass filter text to listener
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String text = filterText.getText();

                            if(text.length() == 0)
                                sorter.setRowFilter(null);
                            else{
                                try{
                                    sorter.setRowFilter(
                                            RowFilter.regexFilter(text)
                                    );
                                }catch (PatternSyntaxException exception){
                                    JOptionPane.showMessageDialog(null, "Bad regex Pattern",
                                            "Bad regex Pattern", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
            );

            //Ensure database is closed when user quits application
            addWindowListener(new WindowAdapter(){
                //Disconnect from database and exit when window has closed
                public void windowClosed(WindowEvent event){
                    tableModel.disconnectFromDatabase();
                    System.exit(0);
                }
            });
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public static void main(String[] args){
        DisplayQueryResults displayQueryResults = new DisplayQueryResults();
        displayQueryResults.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        displayQueryResults.setSize(500, 250);
        displayQueryResults.setVisible(true);
    }

}
