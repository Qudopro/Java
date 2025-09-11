package com.qudopro.ch25;

import javax.swing.*;

public class TicTacToeServerTest {
    public static void main(String[] args){
        TicTacToeServer ticTacToeServer = new TicTacToeServer();
        ticTacToeServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToeServer.execute();
    }
}
