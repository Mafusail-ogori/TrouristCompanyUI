package userDataFunctionsTests;

import data.UserData;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import human.User;

import static org.junit.Assert.assertTrue;

public class FindSameNickNameTest {
    @Mock
    UserData userData = new UserData();

    @Mock
    User user = new User("mafusaillo", "dan", "haha", "dpo.prots@gmail.com", false);

    @Test
    @DisplayName("Find same nickName should work!")
    public void findSameNickNameTest(){
        userData.getHumanData().add(user);
        assertTrue(userData.findSameNickName("mafusaillo") && !userData.findSameNickName("mamma"));
    }

}
