package userDataFunctionsTests;

import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.Assert.assertFalse;

public class DeleteAccountTest {
    @Mock
    UserData userData = new UserData();

    @Test
    @DisplayName("Delete account should work properly")
    public void deleteAccountTest() throws IOException {
        assertFalse(userData.deleteAccount("pokohontas", "hardo"));
    }
}