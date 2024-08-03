package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.CommonComponent;

public class mydb {
    public static boolean register(String username, String password){
        try{
            // first check if the username already exists in the database
            if(!checkUser(username)){
                // connect to the database
                Connection connection = DriverManager.getConnection(CommonComponent.url,CommonComponent.Username,CommonComponent.password);

                // create insert query
                PreparedStatement insertUser = connection.prepareStatement(
                        "INSERT INTO " +CommonComponent.tablename + "(name, password)" +
                                "VALUES(?, ?)"
                );

                // insert parameters in the insert query
                insertUser.setString(1, username);
                insertUser.setString(2, password);

                // update db with new user
                insertUser.executeUpdate();
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    // check if username already exists in the database
    // false - user doesn't exists
    // true - user exists in the database
    public static boolean checkUser(String username){
        try{
            Connection connection = DriverManager.getConnection(CommonComponent.url,CommonComponent.Username,CommonComponent.password);

            PreparedStatement checkUserExists = connection.prepareStatement(
                    "SELECT * FROM " + CommonComponent.tablename +
                            " WHERE NAME = ?"
            );
            checkUserExists.setString(1, username);

            ResultSet resultSet = checkUserExists.executeQuery();

            // check to see if the result set is empty
            // if it is empty it means that there was no data row that contains the username
            // (i.e user does not exist)
            if(!resultSet.isBeforeFirst()){
                return false;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    // validate login credentials by checking to see if username/password pair exists in the database
    public static boolean validateLogin(String username, String password){
        try{
            Connection connection = DriverManager.getConnection(CommonComponent.url,CommonComponent.Username,CommonComponent.password);

            // create select query
            PreparedStatement validateUser = connection.prepareStatement(
                    "SELECT * FROM " + CommonComponent.tablename +
                            " WHERE NAME = ? AND PASSWORD = ?"
            );
            validateUser.setString(1, username);
            validateUser.setString(2, password);

            ResultSet resultSet = validateUser.executeQuery();

            if(!resultSet.isBeforeFirst()){
                return false;
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return true;
    }

}
