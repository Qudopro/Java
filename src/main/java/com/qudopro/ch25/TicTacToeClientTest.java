package com.qudopro.ch25;

import javax.swing.*;

public class TicTacToeClientTest {
    public static void main(String[] args){
        TicTacToeClient app;

        //If no command line args
        if(args.length==0)
            app = new TicTacToeClient("127.0.0.1");         //Localhost
        else
            app = new TicTacToeClient(args[0]);

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
