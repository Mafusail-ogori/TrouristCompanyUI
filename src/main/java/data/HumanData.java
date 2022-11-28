package data;

import human.Human;
import human.User;

import java.util.ArrayList;
import java.util.List;

public class HumanData{
    List<Human> humanData = new ArrayList<>();

    public boolean findSameEmailAddress(String emailAddress) {
        for (var human : humanData) {
            if (human.getEmailaddress().equalsIgnoreCase(emailAddress)) {
                return true;
            }
        }
        return false;
    }

    public boolean findSameNickName(String nickName) {
        for (var human : humanData) {
            if (human.getNickName().equalsIgnoreCase(nickName)) {
                return true;
            }
        }
        return false;
    }

    public boolean findPassword(String password) {
        for (var human : humanData) {
            if (human.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public Human findUser(String userInput, String password) {
        for (var human : humanData) {
            if ((human.getNickName().equalsIgnoreCase(userInput) || human.getEmailaddress().equalsIgnoreCase(userInput)) && human.getPassword().equals(password)) {
                return human;
            }
        }
        return null;
    }

    public void signUp(){};

    public void logIn(){};

    public void deleteAccount(){};
}