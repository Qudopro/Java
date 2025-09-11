package com.qudopro.ch25;

import javax.swing.*;

public class ClientTest {
    public static void main(String[] args){
        Client app;                 //Declare client app

        //If no command-line args
        if(args.length == 0)
            app = new Client("127.0.0.1");              //Connect to localhost
        else
            app = new Client(args[0]);                      //Use args to connect

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.runClient();
    }
}
