package touristAttractionDataFunctionTests;

import data.TouristAttractionDataBase;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import touristAttraction.TouristTicket;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class GetFromDatabaseTest {
    @Mock
    List<TouristTicket> touristTicketList = new ArrayList<>();

    @Test
    @DisplayName("Tickets generator should work properly")
    public void generateTicketsTest() {

        new TouristAttractionDataBase().getFromDataBase(touristTicketList);
        assertTrue(touristTicketList.size() > 10000);
    }
}
