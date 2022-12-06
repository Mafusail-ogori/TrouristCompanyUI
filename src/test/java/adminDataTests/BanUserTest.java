package adminDataTests;

import human.User;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import static data.AdminData.banUser;
import static data.AdminData.unBanUser;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BanUserTest {
    @Mock
    User user = new User("mafusaillo", "dan", "haha", "dpo.prots@gmail.com", false);

    @Test
    @DisplayName("Banning user should work properly")
    public void banUserTest(){
        assertTrue(banUser(user));
    }

    @Test
    @DisplayName("Unbanning user should work properly")
    public void unBanUserTest(){
        assertFalse(unBanUser(user));
    }
}
