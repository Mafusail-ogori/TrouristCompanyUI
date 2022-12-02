package data;

import touristAttraction.TouristTicket;

import java.sql.*;
import java.util.List;
import java.util.Locale;

import static touristAttraction.TicketType.getSameTicketType;
import static touristAttraction.TouristTicketTitle.getSameTicketTitle;
import static touristAttraction.TransportationType.getSameTransport;

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

    public void addToDataBase(String title, int period, int peopleAmount, String hasChild, String hasAnimal,
                              String needNoiseReduction, String includesParty, String ticketType, double price,
                              int hotelRating, String transportationType) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into touristattraction(title, period, peopleamount, haschild," +
                    "hasanimal, neednoisereduction, includesparty, tickettype, price, hotelrating, transportationtype) values " +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
            connection.close();
        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            exception.printStackTrace();
        }
    }

    public void deleteFromDataBase(int id){
        try{
            Statement statement= connection.createStatement();
            statement.executeUpdate(String.format("delete from touristattraction where attractionid = %d", id));
            connection.close();
        }catch (SQLException exception){
            System.out.println("Connection to database failed, contact help");
            exception.printStackTrace();
        }
    }

    public void getFromDataBase(List<TouristTicket> touristTicketList) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("select title, period, peopleamount, haschild, " +
                    "hasanimal, neednoisereduction, includesparty, tickettype, price, hotelrating, transportationtype " +
                    "from touristattraction"));
            while (resultSet.next()) {
                touristTicketList.add(new TouristTicket(
                        getSameTicketTitle(resultSet.getString("title")),
                        resultSet.getInt("period"), resultSet.getInt("peopleamount"),
                        Boolean.parseBoolean(resultSet.getString("haschild")),
                        Boolean.parseBoolean(resultSet.getString("hasanimal")),
                        Boolean.parseBoolean(resultSet.getString("neednoisereduction")),
                        Boolean.parseBoolean(resultSet.getString("includesparty")),
                        getSameTicketType(resultSet.getString("tickettype")),
                        resultSet.getDouble("price"),
                        resultSet.getInt("hotelrating"),
                        getSameTransport(resultSet.getString("transportationtype"))));
            }

        } catch (SQLException exception) {
            System.out.println("Connection to database failed, contact help");
            exception.printStackTrace();
        }
    }
}