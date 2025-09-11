package com.qudopro.ch25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends JFrame {
    private JTextField enterField;              //Enters information from user
    private JTextArea displayArea;              //Display information to user
    private ObjectOutputStream outputStream;    //Output stream to server
    private ObjectInputStream intputStream;     //Input stream from server

    private String message = "";                //Message from server
    private String chatServer;                  //Host server for this app
    private Socket client;                      //Socket to communicate with server;

    //Initialize chatServer and set up GUI
    public Client(String host){
        super("Client");
        chatServer = host;                      //Set server to which this client connects
        enterField = new JTextField();
        enterField.setEditable(false);
        enterField.addActionListener(new ActionListener() {
            //Send message to server
            @Override
            public void actionPerformed(ActionEvent e) {
                sendData(e.getActionCommand());
                enterField.setText("");
            }
        });

        add(enterField, BorderLayout.NORTH);
        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300,150);
        setVisible(true);
    }

    //Connect to server & process messages from server
    public void runClient(){
        try{
            //Connect to server, get streams, process connections
            connectToServer();                  //Create a socket to make connection
            getStreams();                       //Get the input & output streams
            processConnection();                //Process connection
        }catch (EOFException e){
            displayMessage("\nClient terminated connection");
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            closeConnection();                  //Close connection
        }
    }

    //Connect to server
    private void connectToServer() throws IOException{
        displayMessage("Attempting connection\n");

        //Create Socket to make connection to server
        client = new Socket(InetAddress.getByName(chatServer), 12345);              //getByName("localhost")        || getLocalHost()

        //Display connection information
        displayMessage("Connected to: " + client.getInetAddress().getHostName());
    }

    //Get streams to send and receive data
    private void getStreams() throws IOException{
        //Set up output streams for objects
        outputStream = new ObjectOutputStream(client.getOutputStream());
        outputStream.flush();                   //Flush output buffer to send header info

        //Set up input stream for objects
        intputStream = new ObjectInputStream(client.getInputStream());
        displayMessage("\nGot I/O Streams\n");
    }

    //Process connection with server
    private void processConnection() throws IOException{
        //Enable enterField so client user can send messages
        setTextFieldEditable(true);
        do{
            //Process messages sent from servers
            try{
                //Read message and display it
                message = (String)intputStream.readObject();                //Read new message
                displayMessage("\n" + message);
            }catch(ClassNotFoundException e){
                displayMessage("\nUnknown object type received");
            }
        }while(!message.equals("Server >>> TERMINATE"));
    }

    //Close streams & sockets
    private void closeConnection(){
        displayMessage("\nClosing connection");
        setTextFieldEditable(false);
        try{
            outputStream.close();
            intputStream.close();
            client.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Send message to server
    private void sendData(String message){
        try{
            //Send object to server
            outputStream.writeObject("CLIENT >>> " + message);
            outputStream.flush();                           //Flush data to output
            displayMessage("\nCLIENT >>> " + message);
        }catch (IOException e){
            displayArea.append("\nError writing object");
        }
    }

    //Manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Updates displayArea
                displayArea.append(messageToDisplay);
            }
        });
    }

    //Manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable(final boolean editable){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Sets enterField's editable
                enterField.setEditable(editable);
            }
        });
    }
}
