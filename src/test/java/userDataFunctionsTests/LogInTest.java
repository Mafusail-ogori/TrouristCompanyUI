package userDataFunctionsTests;

import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.Assert.*;

public class LogInTest {
    @Mock
    UserData userData = new UserData();

    @Test
    @DisplayName("Log in should work")
    public void logInTest() throws IOException {
        assertTrue(userData.logIn("mafusaillo", "haha"));
    }
}