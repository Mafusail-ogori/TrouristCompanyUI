package userDataFunctionsTests;

import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import java.io.IOException;

import static org.junit.Assert.assertFalse;

public class SignUpTest {
    @Mock
    UserData userData = new UserData();

    @Test
    @DisplayName("Sign up should work")
    public void signUpTest() throws IOException {
        assertFalse( userData.signUp("pokohontas", "poko", "pokorio", "Poko"));
    }
}