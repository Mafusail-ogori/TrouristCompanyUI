package touristAttractionDataFunctionTests;

import data.TouristAttractionsData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuizTest {
    @Test
    @DisplayName("Quiz should work properly!")
    public void quizTest(){
        assertTrue(new TouristAttractionsData().quiz("4 Yes Plane Excursion Yes Yes Yes ThreeTimes").size() > 0);
    }
}
