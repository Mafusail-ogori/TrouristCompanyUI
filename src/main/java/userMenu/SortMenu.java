package userMenu;

import command.Command;
import command.SortByPeriodCommand;
import command.SortByPriceCommand;
import command.SortByRatingCommand;
import data.TouristAttractionsData;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static graphicsText.Graphics.sortMenuText;
import static userMenu.Menu.userChoice;

public class SortMenu {
    public static void sortMenu(TouristAttractionsData ticketsDataBase) throws IOException {
        System.out.println(sortMenuText);
        Map<Integer, Command> sortMenuCommand = new HashMap<>();
        sortMenuCommand.put(1, new SortByPeriodCommand(ticketsDataBase));
        sortMenuCommand.put(2, new SortByPriceCommand(ticketsDataBase));
        sortMenuCommand.put(3, new SortByRatingCommand(ticketsDataBase));
        sortMenuCommand.get(userChoice()).execute();
    }
}