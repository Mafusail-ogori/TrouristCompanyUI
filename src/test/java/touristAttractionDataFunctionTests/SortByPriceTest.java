package touristAttractionDataFunctionTests;

import data.TouristAttractionDataBase;
import data.TouristAttractionsData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;

public class SortByPriceTest {
    @Mock
    TouristAttractionsData touristAttractionsData = new TouristAttractionsData();

    boolean isSorted(TouristAttractionsData ticketsDataBase){
        for(int i = 0; i < ticketsDataBase.getTouristTickets().toArray().length - 1; i++){
            if(!(ticketsDataBase.getTouristTickets().get(i).getPrice() <= ticketsDataBase.getTouristTickets().get(i+1).getPrice())){
                return false;
            }
        }
        return true;
    }

    @Test
    @DisplayName("Sort by price should work")
    public void sortByPriceTest(){
        new TouristAttractionDataBase().getFromDataBase(touristAttractionsData.getTouristTickets());
        touristAttractionsData.sortByPrice();
        assertTrue(isSorted(touristAttractionsData));
    }
}
