package touristAttraction;

import java.util.Random;

public enum MealType {
    Breakfast,
    TwoTimes,
    ThreeTimes,
    AllInclusiveNoAlco,
    AllInclusiveAlco;
    public static String getMealType(){
        Random random = new Random();
        return values()[random.nextInt(values().length)].toString();
    }
}