package data;

import human.Admin;
import human.User;

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
            exception.printStackTrace();
        }
    }

    public void signUpUser(String databaseName, String nickName, String userName, String password, String emailAddress) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into " + databaseName + "  (nickname, realname, password, emailaddress)" +
                    "values (?, ?, ?, ?)");
            preparedStatement.setString(1, nickName);
            preparedStatement.setString(2, userName);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, emailAddress);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            exception.printStackTrace();
        }
    }

    public void getDatabaseUsers(List<User> userData) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select nickname, realname, password, emailaddress from userinfo");
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userData.add(new User(resultSet.getString("nickname"), resultSet.getString("realname"),
                        resultSet.getString("password"), resultSet.getString("emailaddress"), false));
            }

        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            exception.printStackTrace();
        }
    }

    public void getDatabaseAdmins(List<Admin> adminData) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("slelect nickname, realname, emailaddress from admininfo");
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                adminData.add(new Admin(resultSet.getString("nickname"), resultSet.getString("realname"),
                        resultSet.getString("password"), resultSet.getString("emailaddress")));
            }
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
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
            exception.printStackTrace();
        }
        return false;
    }

    public void deleteFromDatabase(String userInput, String password) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format("delete from userinfo where emailaddress = '%s' and password = '%s'", userInput, password));
            connection.close();
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            exception.printStackTrace();
        }
    }
}