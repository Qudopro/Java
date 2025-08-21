package com.qudopro.ch24;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;


public class JdbcRowSetTest {
    //JDBC Driver name & database URL
    public static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:8889/apple?";           //Protocolo:subprotocolo:localización
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args){
        //Try to connect to database
        try(JdbcRowSet rowSetConnected = RowSetProvider.newFactory().createJdbcRowSet()){
            //Specify JdbcRowSet Properties
            rowSetConnected.setUrl(DATABASE_URL);
            rowSetConnected.setUsername(USERNAME);
            rowSetConnected.setPassword(PASSWORD);
            rowSetConnected.setCommand("SELECT * FROM authors");        //Set query
            rowSetConnected.execute();                                  //Execute query

            //Process query results
            ResultSetMetaData metaData = rowSetConnected.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Authors table of Books database: %n%n");

            //Display rowset header
            for(int i = 1; i <= numberOfColumns; i++)
                System.out.printf("%-8s\t", metaData.getColumnName(i));

            System.out.println();

            //Display each row
            while(rowSetConnected.next()){
                for(int i = 1; i <= numberOfColumns; i++)
                    System.out.printf("%-8s\t", rowSetConnected.getObject(i));

                System.out.println();
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}
