package data;

import human.Human;
import human.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserData extends HumanData {

    protected List<User> userData = new ArrayList<>();

    public boolean findSameEmailAddress(String emailAddress) {
        for (var user : userData) {
            if (user.getEmailaddress().equalsIgnoreCase(emailAddress)) {
                return true;
            }
        }
        return false;
    }

    public boolean findSameNickName(String nickName) {
        for (var user : userData) {
            if (user.getNickName().equalsIgnoreCase(nickName)) {
                return true;
            }
        }
        return false;
    }

    public boolean findPassword(String password) {
        for (var user : userData) {
            if (user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Human findUser(String userInput, String password) {
        for (var user : userData) {
            if ((user.getNickName().equalsIgnoreCase(userInput) || user.getEmailaddress().equalsIgnoreCase(userInput))
                    && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public boolean signUp(String nickName, String realName, String password, String emailAddress) {
        UserAdminDataBase userDataBase = new UserAdminDataBase();
        userDataBase.getDatabaseUsers(userData);
        if (!findSameNickName(nickName)) {
            userData.add(new User(nickName, realName, password, emailAddress, false));
            userDataBase.signUpUser("userinfo", nickName, realName, password, emailAddress);
            return true;

        } else {
            return false;
        }
    }


    public boolean deleteAccount(String userInput, String password) {
        UserAdminDataBase userDataBase = new UserAdminDataBase();
        userDataBase.getDatabaseUsers(userData);
        Scanner scanner = new Scanner(System.in);
        if ((findSameNickName(userInput) || findSameEmailAddress(userInput))) {
            if (findPassword(password) && userDataBase.existsInDatabase(findUser(userInput, password).getEmailaddress(), password, "userinfo")) {
                userDataBase.deleteFromDatabase("useinfo", findUser(userInput, password).getEmailaddress(), password);
                this.userData.remove((User) findUser(userInput, password));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean logIn(String userInput, String password) {
        UserAdminDataBase userDataBase = new UserAdminDataBase();
        userDataBase.getDatabaseUsers(userData);
        if (findSameNickName(userInput) || findSameEmailAddress(userInput)) {
            if (findPassword(password)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}