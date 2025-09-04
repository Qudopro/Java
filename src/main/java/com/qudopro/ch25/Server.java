package com.qudopro.ch25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends JFrame {
    private JTextField enterField;                  //Inputs message from user
    private JTextArea displayArea;                  //Display information to user
    private ObjectOutputStream outputStream;        //OutputStream to Client
    private ObjectInputStream inputStream;          //InputStream from Client
    private ServerSocket serverSocket;              //Server socket
    private Socket connection;                      //Connection to client
    private int counter = 1;                        //Number of connection

    //Set up GUI
    public Server(){
        super("Server");
        enterField = new JTextField();
        enterField.setEditable(false);
        enterField.addActionListener(new ActionListener() {
            //Send message to client
            @Override
            public void actionPerformed(ActionEvent e) {
                sendData(e.getActionCommand());
                enterField.setText(" ");
            }
        });

        add(enterField, BorderLayout.NORTH);
        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(300, 150);          //Set size of window
        setVisible(true);                        //Show window
    }

    //Set up and run server
    public void runServer(){
        try{
            //Set up server to receive connections
            serverSocket = new ServerSocket(12345, 100);            //Create server socket
            while(true){
                try{
                    waitForConnection();                                        //Wait for a connection
                    getStreams();                                               //Get input & output streams
                    processConnection();                                        //Process connection
                }catch (EOFException e){
                    displayMessage("\nServer terminated connection");
                }finally{
                    closeConnection();                                          //Close connection
                    ++counter;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //Wait for connection to arrive, then display connection info
    private void waitForConnection() throws IOException{
        displayMessage("Waiting for Connection\n");
        connection = serverSocket.accept();                     //Allow server to accept connections
        displayMessage("Connection " + counter + " received from: " + connection.getInetAddress().getHostName());
    }

    //Get streams to send and receive data
    private void getStreams() throws IOException{
        //Set up output stream for objects
        outputStream = new ObjectOutputStream(connection.getOutputStream());
        outputStream.flush();               //Flush output buffer to send header info

        //Set up input stream for objects
        inputStream = new ObjectInputStream(connection.getInputStream());
        displayMessage("\nGot I/O Streams\n");
    }

    //Process connection with client
    private void processConnection() throws IOException{
        String message = "Connection successful";
        sendData(message);

        //Enable enterField so server user can send message
        setTextFieldEditable(true);

        do{
            //Process messages sent from client
            try{
                //Read message and display it
                message = (String) inputStream.readObject();            //Read new message
                displayMessage("\n" + message);
            }catch (ClassNotFoundException e){
                displayMessage("\nUnknown object type received");
            }
        }while(!message.equals("Client >>> TERMINATE"));
    }

    //Close streams and socket
    private void closeConnection(){
        displayMessage("\nTerminating connection\n");
        setTextFieldEditable(false);                              //Disable enterField
        try{
            outputStream.close();
            inputStream.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Send message to client
    private void sendData(String message){
        try{
            //Send object to client
            outputStream.writeObject("SERVER >>> " + message);
            outputStream.flush();               //Flush output to client
            displayMessage("\nSERVER >>> " + message);
        }catch(IOException e){
            displayMessage("\nError writing object");
        }
    }

    //Crea hilos seguros de componentes SWING GUI ->

    //Manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Updates displayArea
                displayArea.append(messageToDisplay);               //Append message
            }
        });
    }

    //Manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable(final boolean editable){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Sets enterField's editability
                enterField.setEditable(editable);
            }
        });
    }
}
