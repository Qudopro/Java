package com.qudopro.ch24;

import java.sql.*;

public class DisplayAuthors {
    public static void main(String[] args){
        final String SELECT_QUERY = "SELECT authorID, firstName, lastName FROM authors";
        final String DATABASE_URL = "jdbc:mysql://127.0.0.1:8889/apple?";           //Protocolo:subprotocolo:localización

        //Try with resources to connect and query the database
        try(
            Connection connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_QUERY);
        ) {
            //Get resultSet's metadata
            ResultSetMetaData metadaData = resultSet.getMetaData();
            int numberOfColumns = metadaData.getColumnCount(); 
            System.out.printf("Authors Table of Books database%n%n");

            //Display the name of the columns in the ResultSet
            for(int i = 1; i <= numberOfColumns; i++)
                System.out.printf("%-8s\t", metadaData.getColumnName(i));

            System.out.println("\n-------------------------------------");

            //Display Query results
            while(resultSet.next()){
                for(int i = 1; i <= numberOfColumns; i++)
                    System.out.printf("%-8s\t", resultSet.getObject(i));

                System.out.println();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}


/*
    MySQL =         jdbc:mysql://hostname:portNumber/databaseName
    Oracle =        jdbc:oracle:thin:@hostname:portNumber:databasName
    DB2 =           jdbc:db2:hostname:portNumber/databaseName
    PostgreSQL =    jdbc:postgresql://hostname:portNumber/databaseName
    Java DB/Derby = jdbc:derby://hostname:portNumber/databaseName
    SqlServer =     jdbc:sqlserver://hostname:portNumber/databaseName=databaseName
    Sybase =        jdbc:sybase:Tds:hostname:portNumber/databaseName
 */