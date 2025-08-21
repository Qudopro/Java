package com.qudopro.ch24;

import javax.swing.table.AbstractTableModel;
import java.sql.*;

public class ResultSetTableModel extends AbstractTableModel {
    private final Connection connection;
    private final Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    private int numberOfRows;
    private boolean connectedToDatabase = false;

    public ResultSetTableModel(String url, String username, String password, String query) throws SQLException {
        //Connect to database
        connection = DriverManager.getConnection(url, username, password);

        //Create statement to query database
        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );

        //Update database connection status
        connectedToDatabase = true;

        //Set query & execute it
        setQuery(query);
    }

    //Get class that represents column type. Overrride TableModel method
    public Class getColumnClass(int column) throws IllegalStateException{
        //Ensure database connection is avalaible
        if(!connectedToDatabase){
            throw new IllegalStateException("Not connected to Database");
        }

        //Determine Java class of column
        try{
            String className = resultSetMetaData.getColumnClassName(column + 1);

            //Return class object
            return Class.forName(className);
        }catch (Exception e){
            e.printStackTrace();
        }

        return Object.class;            //If problems occur, assume type Object
    }

    //Get number of columns in ResultSet
    @Override
    public int getColumnCount() throws IllegalStateException{
        //Ensure database connection is avalaible
        if(!connectedToDatabase)
            throw new IllegalStateException("Not connected to database");

        //Determine number of columns
        try{
            return resultSetMetaData.getColumnCount();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return 0;           //If problems occur, return 0 for number of columns
    }

    //Get column name. Overrides TableModel method
    public String getColumnName(int column) throws IllegalStateException{
        //Ensure database connection is avalaible
        if(!connectedToDatabase)
            throw new IllegalStateException("Not connected to Database");

        //Determine column name
        try{
            return resultSetMetaData.getColumnName(column + 1);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return "";          //If problems occur, return empty string for column name
    }

    //Return number of rows
    @Override
    public int getRowCount() throws  IllegalStateException{
        //Ensure database connectioon is avalaible
        if(!connectedToDatabase)
            throw new IllegalStateException("Not connected to database");

        return numberOfRows;
    }

    //Obtain value in particular row & column
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) throws IllegalStateException{
        //Ensure database connections is avalaible
        if(!connectedToDatabase){
            throw new IllegalStateException("Not connected to database");
        }

        //Obtain value
        try{
            resultSet.absolute(rowIndex + 1);
            return resultSet.getObject(columnIndex + 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "";                  //If problems occur, return empty string object
    }

    //Set new database query string
    public void setQuery(String query) throws  IllegalStateException{
        //Ensure database connection is avalaible
        if(!connectedToDatabase){
            throw new IllegalStateException("Not connected to database");
        }
        try {
            //Specify query and execute it
            resultSet = statement.executeQuery(query);

            //Obtain metadata for resultSet
            resultSetMetaData = resultSet.getMetaData();

            //Determine number of rows in ResultSet
            resultSet.last();               //Move to Last row
            numberOfRows = resultSet.getRow();          //Get row number

            //Notify JTable that model has changed
            fireTableStructureChanged();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Close statement & connections
    public void disconnectFromDatabase(){
        if(connectedToDatabase){
            //Close statement & connection
            try{
                resultSet.close();
                statement.close();
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }finally {
                connectedToDatabase = false;         //Update database connection status
            }
        }
    }
}