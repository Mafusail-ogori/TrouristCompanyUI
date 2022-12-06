package TouristTicketTest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import touristAttraction.TicketType;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GetTicketTypeTest {
    @Test
    @DisplayName("Ticket Type should get a value")
    public void getTicketTypeTest(){
        assertFalse(TicketType.getTicketType().isEmpty());
    }
}
