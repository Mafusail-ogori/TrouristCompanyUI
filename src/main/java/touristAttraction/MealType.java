package touristAttraction;

import java.util.Random;

public enum MealType {
    Breakfast,
    TwoTimes,
    ThreeTimes,
    AllInclusiveNoAlco,
    AllInclusiveAlco;
    public static MealType getMealType(){
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
    public static MealType getSameMealType(String neededType){
        for (var type: values()) {
            if(type.toString().equalsIgnoreCase(neededType)){
                return type;
            }
        }
        return null;
    }
}