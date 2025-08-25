package com.qudopro.ch24;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class AuthorsPrepareStatementTest extends JFrame {
    private Person currentEntry;
    private PersonQueries personQueries;
    private List<Person> results;

    private int numberOfEntries = 0;
    private int currentEntryIndex = 0;

    private JButton browserButton;
    private JLabel firstNameLabel;
    private JTextField firstNameTextField;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;


   private JTextField indexTextField;
   private JTextField maxTextField;
   private JButton nextButton;
   private JLabel ofLabel;
   private JButton previousButton;
   private JButton queryButton;
   private JLabel queryLabel;
   private JPanel queryPanel;
   private JPanel navigatePanel;
   private JPanel displayPanel;
   private JTextField queryTextField;
   private JButton insertButton;

   public AuthorsPrepareStatementTest(){
       super("Authors Book");

       //Establish database connection & set up prepared statements
       personQueries = new PersonQueries();

       //Create GUI
       navigatePanel = new JPanel();
       previousButton = new JButton();
       indexTextField = new JTextField(2);
       ofLabel = new JLabel();
       maxTextField = new JTextField(2);
       nextButton = new JButton();
       displayPanel = new JPanel();

       firstNameLabel = new JLabel();
       firstNameTextField = new JTextField(10);
       lastNameLabel = new JLabel();
       lastNameTextField = new JTextField(10);

       queryPanel = new JPanel();
       queryLabel = new JLabel();
       queryTextField = new JTextField(10);
       queryButton = new JButton();
       browserButton = new JButton();
       insertButton = new JButton();

       setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
       setSize(400, 400);
       setResizable(false);

       navigatePanel.setLayout(
               new BoxLayout(navigatePanel, BoxLayout.X_AXIS)
       );

       previousButton.setText("Previous");
       previousButton.setEnabled(false);
       previousButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               previousButtonActionPerformed(e);
           }
       });

       navigatePanel.add(previousButton);
       navigatePanel.add(Box.createHorizontalStrut(10));

       indexTextField.setHorizontalAlignment(JTextField.CENTER);
       indexTextField.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               indexTextFieldActionPerformed(e);
           }
       });

       navigatePanel.add(indexTextField);
       navigatePanel.add(Box.createHorizontalStrut(10));

       ofLabel.setText("of");
       navigatePanel.add(ofLabel);
       navigatePanel.add(Box.createHorizontalStrut(10));

       maxTextField.setHorizontalAlignment(JTextField.CENTER);
       maxTextField.setEditable(false);
       navigatePanel.add(maxTextField);
       navigatePanel.add(Box.createHorizontalStrut(10));

       nextButton.setText("Next");
       nextButton.setEnabled(true);
       nextButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               nextButtonActionPerformed(e);
           }
       });

       navigatePanel.add(nextButton);
       add(navigatePanel);

       displayPanel.setLayout(new GridLayout(5,2,4,4));
       firstNameLabel.setText("First name: ");
       displayPanel.add(firstNameLabel);
       displayPanel.add(firstNameTextField);

       lastNameLabel.setText("Last name: ");
       displayPanel.add(lastNameLabel);
       displayPanel.add((lastNameTextField));

       add(displayPanel);

       queryPanel.setLayout(
               new BoxLayout(queryPanel, BoxLayout.X_AXIS)
       );
       queryPanel.setBorder(BorderFactory.createTitledBorder("Find an Entry by last name"));
       queryLabel.setText("Last name");
       queryPanel.add(Box.createHorizontalStrut(5));
       queryPanel.add(queryLabel);
       queryPanel.add(Box.createHorizontalStrut(10));
       queryPanel.add(queryTextField);
       queryPanel.add(Box.createHorizontalStrut(10));

       queryButton.setText("Find");
       queryButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               queryButtonActionPerformed(e);
           }
       });

       queryPanel.add(queryButton);
       queryPanel.add(Box.createHorizontalStrut(5));
       add(queryPanel);

       browserButton.setText("Browse All Entries");
       browserButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               browserButtonActionPerformed(e);
           }
       });
       add(browserButton);

       insertButton.setText("Insert New Entry");
       insertButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               insertButtonActionPerformed(e);
           }
       });
       add(insertButton);

       addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
                personQueries.close();          //Close database connection
                System.exit(0);
           }
       });

       setVisible(true);
   }

   //Handles all when previousButton is clicked
    private void previousButtonActionPerformed(ActionEvent e){
       currentEntryIndex--;

       if(currentEntryIndex < 0)
           currentEntryIndex = numberOfEntries - 1;
       indexTextField.setText("" + (currentEntryIndex + 1));
       indexTextFieldActionPerformed(e);
    }

    //Handles all when nextButton is clicked
    private void nextButtonActionPerformed(ActionEvent e){
       currentEntryIndex++;
       if(currentEntryIndex >= numberOfEntries)
           currentEntryIndex = 0;

       indexTextField.setText("" + (currentEntryIndex + 1));
       indexTextFieldActionPerformed(e);
    }

    //Handles call when queryButton is clicked
    private void queryButtonActionPerformed(ActionEvent e){
       results = personQueries.getPeopleByLastName(
               queryTextField.getText()
       );
       numberOfEntries = results.size();

       if(numberOfEntries != 0){
           currentEntryIndex = 0;
           currentEntry = results.get(currentEntryIndex);
           firstNameTextField.setText(currentEntry.getFirstName());
           lastNameTextField.setText(currentEntry.getLastName());
           maxTextField.setText("" + numberOfEntries);
           indexTextField.setText("" + (currentEntryIndex + 1));
           previousButton.setEnabled(true);
      }else{
           browserButtonActionPerformed(e);
       }
    }

    //Handles call when a new value is entered in indexTextField
    private void indexTextFieldActionPerformed(ActionEvent e){
       currentEntryIndex = (Integer.parseInt(indexTextField.getText()) - 1);

       if(numberOfEntries != 0 && currentEntryIndex < numberOfEntries){
           currentEntry = results.get(currentEntryIndex);
           firstNameTextField.setText(currentEntry.getFirstName());
           lastNameTextField.setText(currentEntry.getLastName());
           maxTextField.setText("" + numberOfEntries);
           indexTextField.setText("" + (currentEntryIndex + 1));
       }
    }

    //Handles call when browserButton is clicked
    private void browserButtonActionPerformed(ActionEvent e){
       try {
           results = personQueries.getAllPeople();
           numberOfEntries = results.size();

           if(numberOfEntries != 0){
               currentEntryIndex = 0;
               currentEntry = results.get(currentEntryIndex);
               firstNameTextField.setText(currentEntry.getFirstName());
               lastNameTextField.setText(currentEntry.getLastName());
               maxTextField.setText("" + numberOfEntries);
               indexTextField.setText("" + (currentEntryIndex + 1));
               maxTextField.setText("" + numberOfEntries);
               indexTextField.setText("" + (currentEntryIndex + 1));
               nextButton.setEnabled(true);
               previousButton.setEnabled(true);
           }
       }catch (Exception e1){
           e1.printStackTrace();
       }
    }

    //Handles call when insertButton is clicked
    private void insertButtonActionPerformed(ActionEvent e){
       int result = personQueries.addPerson(firstNameTextField.getText(), lastNameTextField.getText());

       if(result == 1){
           JOptionPane.showMessageDialog(this, "Person added!", "Person Added", JOptionPane.PLAIN_MESSAGE);
       }else{
           JOptionPane.showMessageDialog(this, "Person not added!", "Error", JOptionPane.ERROR_MESSAGE);
       }

       browserButtonActionPerformed(e);
    }

    //Main method
    public static void main(String[] args){
       new AuthorsPrepareStatementTest();
    }
}


