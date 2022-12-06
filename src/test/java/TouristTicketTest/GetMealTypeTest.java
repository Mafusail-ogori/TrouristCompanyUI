package TouristTicketTest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import touristAttraction.MealType;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GetMealTypeTest {

    @Test
    @DisplayName("MealType should get a value")
    public void getMealTypeTest(){
        assertFalse(MealType.getMealType().isEmpty());
    }
}
