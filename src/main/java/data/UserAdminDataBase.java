package data;

import human.Admin;
import human.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import logger.Log;

import java.sql.*;
import java.util.List;

public class UserAdminDataBase {
    Connection connection;

    public UserAdminDataBase() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TouristCompanyDatabase",
                    "postgres",
                    "Hajaomija123");
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            Log.logMail("Fatal Error in Database");
            exception.printStackTrace();
        }
    }

    public void signUpUser(String tableName, String nickName, String userName, String password, String emailAddress) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into " + tableName + "  (nickname, realname, password, emailaddress)" +
                    "values (?, ?, ?, ?)");
            preparedStatement.setString(1, nickName);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, emailAddress);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            Log.logMail("Fatal Error in Database");
            exception.printStackTrace();
        }
    }

    public ObservableList<User> getDatabaseUsers(List<User> userData) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select nickname, realname, password, emailaddress, isbanned from userinfo");
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userData.add(new User(resultSet.getString("nickname"),
                        resultSet.getString("realname"),
                        resultSet.getString("password"),
                        resultSet.getString("emailaddress"),
                        Boolean.parseBoolean(resultSet.getString("isbanned"))));
            }

        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            Log.logMail("Fatal Error in Database");
            exception.printStackTrace();
        }
        return FXCollections.observableList(userData);
    }

    public void getDatabaseAdmins(List<Admin> adminData) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("select nickname, realname, password, emailaddress from admininfo");
            var resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                adminData.add(new Admin(resultSet.getString("nickname"),
                        resultSet.getString("realname"),
                        resultSet.getString("password"),
                        resultSet.getString("emailaddress")));
            }
        } catch (SQLException exception){
            System.out.println("Connection to database failed, contact help");
            Log.logMail("Fatal Error in Database");
            exception.printStackTrace();
        }
    }

    public boolean existsInDatabase(String userInput, String password, String dataBaseName) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from " + dataBaseName + " where emailaddress = ?" +
                    " and password = ?");
            preparedStatement.setString(1, userInput);
            preparedStatement.setString(2, password);
            var resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            Log.logMail("Fatal Error in Database");
            exception.printStackTrace();
        }
        return false;
    }

    public void deleteFromDatabase(String tableName, String userInput, String password) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from " + tableName +
                    " where emailaddress = ? and password = ?");
            preparedStatement.setString(1, userInput);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("kekeoGekai");
            connection.close();
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            Log.logMail("Fatal Error in Database");
            exception.printStackTrace();
        }
    }

    public void banDatabaseUser (User user){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update userinfo set isbanned = 'true' " +
                    "where nickname = ? and realname = ? and emailaddress = ?");
            preparedStatement.setString(1, user.getNickName());
            preparedStatement.setString(2, user.getRealName());
            preparedStatement.setString(3, user.getEmailaddress());
            preparedStatement.executeUpdate();
        } catch (SQLException exception){
            System.out.println("Connection to database failed, contact help");
            Log.logMail("Fatal Error in Database");
            exception.printStackTrace();
        }
    }

    public void unBanDatabaseUser (User user){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("update userinfo set isbanned = 'false' " +
                    "where nickname = ? and realname = ? and emailaddress = ?");
            preparedStatement.setString(1, user.getNickName());
            preparedStatement.setString(2, user.getRealName());
            preparedStatement.setString(3, user.getEmailaddress());
            preparedStatement.executeUpdate();
        } catch (SQLException exception){
            System.out.println("Connection to database failed, contact help");
            Log.logMail("Fatal Error in Database");
            exception.printStackTrace();
        }
    }
}