package com.qudopro.ch25;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicTacToeServer extends JFrame {
    private String[] board = new String[9];                 //Tic-Tac-Toe board
    private JTextArea outputArea;                           //For outputting moves
    private Player[] players;                               //Array of players
    private ServerSocket server;                            //ServerSocket to connect with clients
    private int currentPlayer;                              //Keeps track of player with current move
    private final static int PLAYER_X = 0;                  //Constant for first player
    private final static int PLAYER_O = 1;                  //Constant for second player
    private final static String[] MARKS = {"X","O"};
    private ExecutorService runGame;                        //Will run players
    private Condition otherPlayerConnected;                 //To wait for other players
    private Condition otherPlayerTurn;                      //To wait for other player's turn
    private Lock gameLock;
    //Set up tic-tac-toe server and GUI  that displays messages
    public TicTacToeServer(){
        super("TicTacToe Server");                      //Set title of window

        //Create ExecutorService with a thread for each player
        runGame = Executors.newFixedThreadPool(2);
        gameLock = new ReentrantLock();                     //Create lock for game

        //Condition variable for both players being connected
        otherPlayerConnected = gameLock.newCondition();

        //Condition variable for the other player's turn
        otherPlayerTurn = gameLock.newCondition();

        for(int i = 0; i < 9; i++)
            board[i] = new String(" ");              //Create tic-tac-toe board

        players = new Player[2];                            //Create array of players
        currentPlayer = PLAYER_X;                           //Set current player to first playres

        try{
            server = new ServerSocket(12345, 2);    //Set up Server Socket
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }

        outputArea = new JTextArea();                   //Create JTextArea for output
        add(outputArea, BorderLayout.CENTER);
        outputArea.setText("Server awaiting connections\n");
        setSize(300,300);
        setVisible(true);
    }

    //Wait for 2 connections, so game can be played
    public void execute(){
        //Wait for each client to connect
        for(int i = 0; i < players.length; i++){
            try{
                //Wait for connection, create player, start runnable
                players[i] = new Player(server.accept(), i);
                runGame.execute(players[i]);                            //Execute player runnable
            }catch (IOException e){
                e.printStackTrace();
                System.exit(1);
            }
        }

        gameLock.lock();                //Lock game to signal player X's thread
        try{
            players[PLAYER_X].setSuspended(false);               //Resume player X
            otherPlayerConnected.signal();                      //Wake up player X's thread
        }finally{
            gameLock.unlock();                                  //Unlock game after signalling player X
        }
    }

    //Display message in outputArea
    private void displayMessage(final String messageToDisplay){
        //Display message from event-dispatch thread of execution
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Updates outputArea
                outputArea.append(messageToDisplay);                //Add message
            }
        });
    }

    //Determine if move is valid
    public boolean validateAndMove(int location, int player){
        //While not current player, must wait for turn
        while(player != currentPlayer){
            gameLock.lock();                    //Lock game to wait for other player to go
            try{
                otherPlayerTurn.await();        //Wait for player's turn
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                gameLock.unlock();              //Unlock game after waiting
            }
        }

        //If location not occupied, make move
        if(!isOccupied(location)){
            board[location] = MARKS[currentPlayer];             //Set move on board
            currentPlayer = (currentPlayer + 1) % 2;             //Change player

            //Let new current player know that move occurred
            players[currentPlayer].otherPlayerMoved(location);
            gameLock.lock();                                    //Lock game to signal other player to go

            try{
                otherPlayerTurn.signal();                       //Signal other player to continue
            }finally {
                gameLock.unlock();                              //Unlock game after sinaling
            }

            return true;                    //notify player that move was valid
        }else{
            return false;                   //Notify player that move was invalid
        }
    }

    //Determine whether location is occupied
    public boolean isOccupied(int location){
        if(board[location].equals(MARKS[PLAYER_X]) ||
        board[location].equals(MARKS[PLAYER_O]))
            return true;                //Location is occupied
        else
            return false;               //Location isn't occupied
    }

    //place code in this method to determine whether game over
    public boolean isGameOver() {
        return false;
    }

    //Private inner class Player manages each Player as a Runnable
    private class Player implements Runnable{
        private Socket connection;              //Connection to client
        private Scanner input;                  //Input from client
        private Formatter output;               //Output to client
        private int playerNumber;               //Tracks which player this is
        private String mark;                    //Mark for this player
        private boolean suspended = true;       //Whether thread is suspended

        //Set up player thread
        public Player(Socket socket, int number){
            playerNumber = number;              //Stores this player's number
            connection = socket;                //Store socket for client
            mark = MARKS[playerNumber];         //Specify player's mark

            try{
                //Obtain stream from socket
                input = new Scanner(connection.getInputStream());
                output = new Formatter(connection.getOutputStream());
            }catch(IOException e){
                e.printStackTrace();
                System.exit(1);
            }
        }

        //Send message that other player moved
        public void otherPlayerMoved(int location){
            output.format("Opponent moved\n");
            output.format("%d\n", location);            //Send location of move
            output.flush();             //Flush output
        }

        //Control thread's execution
        @Override
        public void run(){
            //Send client its mark (X or O), process messages from client
            try{
                displayMessage("Player " + mark + " connected\n");
                output.format("%s\n", mark);                //Send player's mark
                output.flush();

                //If player X, wait for another player to arrive
                if(playerNumber == PLAYER_X){
                    output.format("%s\n%s", "Player X connected", "waiting for another player\n");
                    output.flush();
                    gameLock.lock();                //Lock game to wait for second player

                    try{
                        while(suspended){
                            otherPlayerConnected.await();           //Wait for player O
                        }
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        gameLock.unlock();              //Unlock game after second player
                    }

                    //Send message that other player connected
                    output.format("Other player connected. Your move\n");
                    output.flush();
                }else{
                    output.format("Player O connected. Please wait\n");
                    output.flush();
                }
                //While game not over
                while(!isGameOver()){
                    int location = 0;           //Initialize move location
                    if(input.hasNext())
                        location = input.nextInt();         //Get move location

                    //Check for valid move
                    if(validateAndMove(location, playerNumber)){
                        displayMessage("\nLocation: " + location);
                        output.format("Valid move\n");
                        output.flush();
                    }else {
                        //Move was invalid
                        output.format("Invalid move, try again\n");
                        output.flush();
                    }
                }
            }finally {
                try{
                    connection.close();         //Close connection to client
                }catch (IOException e){
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }

        //Set whether or not thread is suspended
        public void setSuspended(boolean status){
            suspended = status;             //Set value of suspended
        }
    }
}
