package com.qudopro.ch25;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerUDP extends JFrame {
    private JTextArea displayArea;                      //Displays packets received
    private DatagramSocket socket;                      //Socket to connect to client

    public ServerUDP(){
        super("Server");
        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        setSize(400,300);
        setVisible(true);

        try{
            //Create Datagram Socket for sending & receiving packets
            socket = new DatagramSocket(5000);
        }catch(SocketException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    //Wait for packets to arrive. Display data and echo packet to client
    public void waitForPackets(){
        while(true){
            try{
                //Receive packet, display contents,return copy to client
                byte[] data = new byte[100];            //Set up packet
                DatagramPacket receivePacket = new DatagramPacket(data, data.length);
                socket.receive(receivePacket);              //Wait to receive packet

                //Display information from received packet
                displayMessage("\nPacket received: " +
                        "\nFrom Host: " + receivePacket.getAddress() +
                        "\nHost port: " + receivePacket.getPort() +
                        "\nLength: " + receivePacket.getLength() +
                        "\nContaining: \n\t " + new String(receivePacket.getData(), 0, receivePacket.getLength())
                );

                sendPacketToClient(receivePacket);              //Send packet to client
            }catch(IOException e){
                displayMessage(e + "\n");
                e.printStackTrace();
            }
        }
    }

    //Echo packet to client
    private void sendPacketToClient(DatagramPacket receivePacket) throws IOException{
        displayMessage("\n\nEcho data to client...");

        //Create packet to send
        DatagramPacket sendPacket = new DatagramPacket(
            receivePacket.getData(),
            receivePacket.getLength(),
            receivePacket.getAddress(),
            receivePacket.getPort()
        );

        socket.send(sendPacket);                    //Send packet to client
        displayMessage("Packet sent\n");
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
}
