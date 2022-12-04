package touristAttraction;

import java.util.Random;

public enum TransportationType {
    Car,
    Bus,
    Train,
    Plane,
    Ship,
    StarShip,
    Horse;
    public static String getRandomTransport(){
        Random random = new Random();
        return values()[random.nextInt(values().length)].toString();
    }
}
