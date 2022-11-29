package userDataFunctionsTests;

import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SignUpTest {
    @Mock
    UserData userData = new UserData();

    @Mock
    String inputString =
            "mafusaillo" +
            System.getProperty("line.separator") +
            "dan" +
            System.getProperty("line.separator") +
            "haha";

    @Test
    @DisplayName("Sign up should work")
    public void signUpTest() throws IOException {
        System.setIn(new ByteArrayInputStream(inputString.getBytes()));
        userData.signUp();
        assertEquals(1, userData.getUserData().size());
    }
}