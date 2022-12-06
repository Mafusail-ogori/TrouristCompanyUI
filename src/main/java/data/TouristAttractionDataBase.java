package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import touristAttraction.TouristTicket;

import java.sql.*;
import java.util.List;

public class TouristAttractionDataBase {
    Connection connection;

    public TouristAttractionDataBase() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TouristCompanyDatabase",
                    "postgres",
                    "Hajaomija123");
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            exception.printStackTrace();
        }
    }

    public boolean addToDataBase(String title, int period, int peopleAmount, String hasChild, String hasAnimal,
                              String needNoiseReduction, String includesParty, String ticketType, double price,
                              int hotelRating, String transportationType, String mealType) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into touristattraction(title, " +
                    "period, peopleamount, haschild," +
                    "hasanimal, neednoisereduction, includesparty, tickettype, price, hotelrating, " +
                    "transportationtype, mealtype) values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, title);
            preparedStatement.setInt(2, period);
            preparedStatement.setInt(3, peopleAmount);
            preparedStatement.setString(4, hasChild);
            preparedStatement.setString(5, hasAnimal);
            preparedStatement.setString(6, needNoiseReduction);
            preparedStatement.setString(7, includesParty);
            preparedStatement.setString(8, ticketType);
            preparedStatement.setDouble(9, price);
            preparedStatement.setInt(10, hotelRating);
            preparedStatement.setString(11, transportationType);
            preparedStatement.setString(12, mealType);
            preparedStatement.executeUpdate();
            connection.close();
            return true;
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            exception.printStackTrace();
            return false;
        }
    }

    public void deleteFromDataBase(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from touristattraction where touristattractionid = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            exception.printStackTrace();
        }
    }

    public ObservableList<TouristTicket> getFromDataBase(List<TouristTicket> touristTicketList) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select touristattractionid,  title, " +
                    "period, peopleamount, haschild, hasanimal, neednoisereduction, includesparty, " +
                    "tickettype, price, hotelrating, transportationtype, mealtype from touristattraction");
            var resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                touristTicketList.add(new TouristTicket(
                        resultSet.getInt("touristattractionid"),
                        resultSet.getString("title"),
                        resultSet.getInt("period"), resultSet.getInt("peopleamount"),
                        Boolean.parseBoolean(resultSet.getString("haschild")),
                        Boolean.parseBoolean(resultSet.getString("hasanimal")),
                        Boolean.parseBoolean(resultSet.getString("neednoisereduction")),
                        Boolean.parseBoolean(resultSet.getString("includesparty")),
                        resultSet.getString("tickettype"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("hotelrating"),
                        resultSet.getString("transportationtype"),
                        resultSet.getString("mealtype")));
            }

        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            exception.printStackTrace();
        }
        return FXCollections.observableList(touristTicketList);
    }
}

