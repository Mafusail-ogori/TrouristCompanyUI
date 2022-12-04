package touristAttraction;

import java.util.Random;


public enum TouristTicketTitle {
    AzurePassion,
    GreatSunrise,
    ArrogantFruit,
    NatureBeauty,
    MoonlightShine,
    ProminentTime;

    public static String getRandomTitle() {
        Random random = new Random();
        return values()[random.nextInt(values().length)].toString();
    }
}
