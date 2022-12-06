package TouristTicketTest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import touristAttraction.TouristTicketTitle;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GetTicketTitle {
    @Test
    @DisplayName("Ticket title should get a value")
    public void getTicketTitleTest(){
        assertFalse(TouristTicketTitle.getRandomTitle().isEmpty());
    }
}
