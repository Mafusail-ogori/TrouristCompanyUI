package adminDataTests;

import data.AdminData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogInAdminTest {
    @Test
    @DisplayName("Log in admin should work")
    public void logInAdminTest(){
        assertTrue(new AdminData().logIn("mafusaillo", "haha"));
    }
}
