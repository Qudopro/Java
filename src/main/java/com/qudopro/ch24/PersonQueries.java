package com.qudopro.ch24;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonQueries {
    //JDBC Driver name & database URL
    public static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:8889/apple?";           //Protocolo:subprotocolo:localización
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";

    private Connection connection;
    private PreparedStatement selectAllPeople;
    private PreparedStatement selectPeopleByLastName;
    private PreparedStatement insertNewPerson;

    public PersonQueries(){
        try{
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            //Create Query that selects all entries in the authors
            selectAllPeople = connection.prepareStatement("SELECT * FROM authors");

            //Create Query that selects entries with a specific lastName
            selectPeopleByLastName = connection.prepareStatement("SELECT * FROM Authors WHERE lastName = ?");

            //Create insert that adds a new entry in the database
            insertNewPerson = connection.prepareStatement("INSERT INTO authors (" +
                    "firstName, lastName)"  +
                    " VALUES (?,?)"
            );
        }catch (SQLException e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    //SELECT ALL OF THE AUTHORS IN THE DATABASE
    public List<Person> getAllPeople(){
        List<Person> results = null;
        ResultSet resultSet = null;

        try{
            //ExecuteQuery returns ResultSet containing matching entries
            resultSet = selectAllPeople.executeQuery();
            results = new ArrayList<>();

            while(resultSet.next()){
                results.add(new Person(
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                resultSet.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                close();
            }
        }

        return  results;
    }

    //SELECT PERSON BY LAST NAME
    public List<Person> getPeopleByLastName(String lastName){
        List<Person> results = null;
        ResultSet resultSet = null;

        try{
            selectPeopleByLastName.setString(1, lastName);

            //ExecuteQuery returns ResultSet containing matching entries
            resultSet = selectPeopleByLastName.executeQuery();
            results = new ArrayList<>();

            while(resultSet.next()){
                results.add(new Person(
                   resultSet.getString("firstName"),
                   resultSet.getString(("lastName"))
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                resultSet.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
                close();
            }
        }

        return results;
    }

    //Add an entry
    public int addPerson(String lastName, String firstName){
        int result = 0;

        //Set parameters, then execute insertNewPerson
        try{
            insertNewPerson.setString(1, lastName);
            insertNewPerson.setString(2, firstName);

            //Insert the new entry; returns numbers of rows updated
            result = insertNewPerson.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            close();
        }

        return result;
    }

    //Close the database connection
    public void close(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
