package com.qudopro.ch25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientUDP extends JFrame {
    private JTextField enterField;                  //For entering messages
    private JTextArea displayArea;                  //For displaying messages
    private DatagramSocket socket;                  //Socket to connect to server

    //Set up GUI & Datagram Socket
    public ClientUDP(){
        super("Client");

        enterField = new JTextField("Type message here");
        enterField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Create & send packet
                try{
                    //Get message from JTextField
                    String message = e.getActionCommand();
                    displayArea.append("\nSending packet containing: " + message + "\n");
                    byte[] data = message.getBytes();           //Convert message to ytes

                    //Create sendPacket
                    DatagramPacket sendPacket = new DatagramPacket(
                            data,
                            data.length,
                            InetAddress.getLocalHost(),
                            5000
                    );
                    socket.send(sendPacket);                //Send packet
                    displayArea.append("Packet sent\n");
                    displayArea.setCaretPosition(displayArea.getText().length());
                }catch (IOException exception){
                    displayMessage(exception + "\n");
                    exception.printStackTrace();
                }
            }
        });

        add(enterField, BorderLayout.NORTH);
        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(300, 300);
        setVisible(true);

        try{
            //Create DatagramSocket for sending and receiving packets
            socket = new DatagramSocket();
        }catch(SocketException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    //Wait for packets to arrive from Server, display packets contents
    public void waitForPackets(){
        while(true){
            try{
                //receive packet & display contents
                byte[] data = new byte[100];                //Set up packet
                DatagramPacket receivePacket = new DatagramPacket(
                    data,
                    data.length
                );
                socket.receive(receivePacket);                  //Wait for packet

                //Display packet contents
                displayMessage("\nPacket received: " +
                        "\nFrom Host: " + receivePacket.getAddress() +
                        "\nHost port: " + receivePacket.getPort() +
                        "\nLength: " + receivePacket.getLength() +
                        "\nContaining: \n\t " + new String(receivePacket.getData(), 0, receivePacket.getLength())
                );
            }catch (IOException e){
                displayMessage(e + "\n");
                e.printStackTrace();
            }
        }
    }
    //Manipulates displayArea in the event-dispatch thread
    private void displayMessage(final String messageToDisplay){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //update displayArea
                displayArea.append(messageToDisplay);
            }
        });
    }

}
