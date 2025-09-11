package com.qudopro.ch25;

import javax.swing.*;

public class ServerUDPTest {
    public static void main(String[] args){
        ServerUDP serverUDP = new ServerUDP();
        serverUDP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        serverUDP.waitForPackets();
    }
}
