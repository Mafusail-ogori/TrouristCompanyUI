package data;

import human.Human;
import human.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HumanData<T extends Human> {
    List<T> humanData = new ArrayList<>();

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

    public boolean validateEmail(String email) {
        var regex = "^(.+)@(.+)$";
        var pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return email.length() <= 50 && matcher.matches();
    }

    public boolean standartValidator(String toValidate) {
        var regex = "^[A-Za-z]\\w{5,29}$";
        var pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(toValidate);
        return toValidate.length() <= 50 && matcher.matches();
    }

    public List<T> getHumanData() {
        return humanData;
    }
}