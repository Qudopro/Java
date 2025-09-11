package com.qudopro.ch25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TicTacToeClient extends JFrame implements Runnable{
    private JTextField idField;                 //TextField to display player's mark
    private JTextArea displayArea;              //Display output
    private JPanel boardPanel;                  //Panel for tic-tac-toe board
    private JPanel panel2;                      //Panel to hold board
    private Square[][] board;                   //Tic-Tac-Toe board
    private Square currentSquare;
    private Socket connection;                  //Connection to server
    private Scanner input;                      //Input from server
    private Formatter output;                   //Output to server
    private String ticTacToeHost;               //Host name for server
    private String myMark;                      //This client's mark
    private boolean myTurn;                     //Determines which client's turn is
    private final String X_MARK = "X";
    private final String O_MARK = "O";

    public TicTacToeClient(String host){
        ticTacToeHost = host;               //Set name of server
        displayArea = new JTextArea(4,30);
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        boardPanel = new JPanel();          //Set up panel for squares in board
        boardPanel.setLayout(new GridLayout(3,3,0,0));
        board = new Square[3][3];           //Create board

        //Loop over the rows in the board
        for(int row = 0; row < board.length; row++){
            //Loop over the columns in the board
            for(int column = 0; column < board[row].length; column++){
                //Create square
                board[row][column] = new Square("", row*3+column);
                boardPanel.add(board[row][column]);         //Add square
            }
        }

        idField = new JTextField();
        idField.setEditable(false);
        add(idField, BorderLayout.NORTH);

        panel2 = new JPanel();          //Set up panel to contain boardPanel
        panel2.add(boardPanel, BorderLayout.CENTER);
        add(panel2, BorderLayout.CENTER);

        setSize(300,225);
        setVisible(true);
        startClient();
    }

    //Start the client thread
    public void startClient(){
        try{
            //Connect to server and get Streams
            //Make connection to server
            connection = new Socket(
                    InetAddress.getByName(ticTacToeHost),
                    12345
            );

            //Get streams for input & output
            input = new Scanner(connection.getInputStream());
            output = new Formatter(connection.getOutputStream());
        }catch (IOException e){
            e.printStackTrace();
        }

        //Create and start worker thread for this client
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(this);          //Execute client
    }
    //Control thread that allows continous update of displayArea
    @Override
    public void run() {
        myMark = input.nextLine();          //Get player's mark(X or O)

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Display player's mark
                idField.setText("You are player \"" + myMark +"\"");
            }
        });

        myTurn = myMark.equals(X_MARK);         //Determine if client's turn

        //Receive messages sent to client and output them
        while(true){
            if(input.hasNextLine())
                processMessage(input.nextLine());
        }
    }

    //Process messages received by client
    private void processMessage(String message){
        //Valid move occurred
        if(message.equals(("Valid move"))){
            displayMessage("Valid move, please wait.\n");
            setMark(currentSquare, myMark);
        }else if(message.equals("Invalid move, try again")){
            displayMessage(message + "\n");         //Display invalid move
            myTurn = true;          //Still this client's turn
        }else if(message.equals("Opponent moved")){
            int location = input.nextInt();     //Get move location
            input.nextLine();       //Skip new line after int location
            int row = location / 3; //Calculate row
            int column = location % 3;      //Calculate column

            setMark(board[row][column], myMark.equals(X_MARK) ? O_MARK : X_MARK);           //Mark Move
            displayMessage("Opponent moved. Your turn\n");
            myTurn = true;      //New this client's turn
        }else
            displayMessage(message + "\n");
    }

    //Manipulate displayArea in event-dispatch thread
    private void displayMessage(final String messageToDisplay){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                displayArea.append(messageToDisplay);       //Updates output
            }
        });
    }

    //Utility method to set mark on board in event-dispatch thread
    private void setMark(final Square squareToMark, final String mark){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                squareToMark.setMark(mark);         //Set mark in square
            }
        });
    }

    //Send message to server indicating clicked square
    public void sendClickedSquare(int location){
        //If it is my turn
        if(myTurn){
            output.format("%d\n", location);        //Send location to server
            output.flush();
            myTurn = false;     //Not my turn anymore
        }
    }

    //Set current square
    public void setCurrentSquare(Square square){
        currentSquare = square;
    }

    //Private inner class for the squares on the board
    private class Square extends JPanel{
        private String mark;            //Mark to be drawn in this square
        private int location;           //Location of square

        public Square(String squareMark, int squareLocation){
            mark = squareMark;      //Set mark for this square
            location = squareLocation;      //Set location of this square
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    setCurrentSquare(Square.this);          //Set current square
                    //Send location of this square
                    sendClickedSquare(getSquareLocation());
                }
            });
        }

        //Return preferred size of square
        public Dimension getPreferredSize(){
            return new Dimension(30, 30);
        }

        //Return minimum size of Square
        public Dimension getMinimumSize(){
            return getPreferredSize();
        }

        //Set mark for square
        public void setMark(String newMark){
            mark = newMark;     //Set mark of square
            repaint();          //Repaint square
        }

        //Return square location
        public int getSquareLocation(){
            return location;            //Return location of square
        }

        //Draw square
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawRect(0,0,29,29);      //Draw square
            g.drawString(mark, 11, 20);              //Draw mark
        }
    }
}
