package touristAttraction;

import java.util.Random;
public enum TicketType {
    Resort,
    Excursion,
    Healing,
    Shopping,
    Cruise;
    public static String getTicketType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)].toString();
    }
}