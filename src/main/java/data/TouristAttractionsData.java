package data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import touristAttraction.*;

import java.util.*;


public class TouristAttractionsData {

    public List<TouristTicket> getTouristTickets() {
        return touristTickets;
    }

    List<TouristTicket> touristTickets = new ArrayList<>();


    public static void touristTicketGenerator() {
        Random random = new Random();
        for (var i = 0; i < 70000; i++) {
            new TouristAttractionDataBase().addToDataBase(TouristTicketTitle.getRandomTitle().toString(), random.nextInt(3, 28),
                    random.nextInt(1, 11), String.valueOf(random.nextBoolean()),
                    String.valueOf(random.nextBoolean()), String.valueOf(random.nextBoolean()), String.valueOf(random.nextBoolean()), TicketType.getTicketType().toString(),
                    random.nextDouble(250.5, 12000), random.nextInt(1, 6), TransportationType.getRandomTransport().toString(), MealType.getMealType().toString());
        }
    }

    public boolean isSame(String choice, boolean real) {
        return choice.equalsIgnoreCase("yes") == real;
    }

    public boolean isSameTransport(String choice, TransportationType transportationType) {
        return choice.equalsIgnoreCase(transportationType.toString());
    }

    public boolean isSameResortType(String choice, TicketType ticketType) {
        return choice.equalsIgnoreCase(ticketType.toString());
    }

    public boolean isSameMeal(String choice, MealType mealType){
        return choice.equalsIgnoreCase(mealType.toString());
    }

    public void sortByPrice() {
        touristTickets.sort(Comparator.comparingInt(TouristTicket::getPrice));
    }

    public void sortByRating() {
        touristTickets.sort(Comparator.comparingInt(TouristTicket::getHotelRating));
    }

    public void sortByPeriod() {
        touristTickets.sort(Comparator.comparingInt(TouristTicket::getPeriod));
    }

    public ObservableList<TouristTicket> quiz(String answers) {
        new TouristAttractionDataBase().getFromDataBase(touristTickets);
        var answersArray = answers.split(" ");
        ObservableList<TouristTicket> suitableTickets = FXCollections.observableArrayList();
        for (var ticket : touristTickets) {
            if ((Integer.parseInt(answersArray[0]) == ticket.getPeriod()) &&
                    isSame(answersArray[1], ticket.isHasChild()) &&
                    isSameTransport(answersArray[2], ticket.getTransportationType()) &&
                    isSameResortType(answersArray[3], ticket.getType()) &&
                    isSame(answersArray[4], ticket.isHasAnimal()) &&
                    isSame(answersArray[5], ticket.isNeedNoiseReduction()) &&
                    isSame(answersArray[6], ticket.isIncludesParty()) &&
                    isSameMeal(answersArray[7], ticket.getMealType()))
            {
                suitableTickets.add(ticket);
            }
        }
        return suitableTickets;
    }
}