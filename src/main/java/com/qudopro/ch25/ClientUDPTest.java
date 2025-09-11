package com.qudopro.ch25;

import javax.swing.*;

public class ClientUDPTest {
    public static void main(String[] args){
        ClientUDP clientUDP = new ClientUDP();
        clientUDP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clientUDP.waitForPackets();
    }
}
