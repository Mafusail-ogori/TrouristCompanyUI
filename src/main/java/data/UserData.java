package data;

import human.Human;
import human.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static graphicsText.Graphics.*;

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
    @Override
    public void signUp() {
        UserAdminDataBase userDataBase = new UserAdminDataBase();
        System.out.println(signUpText);
        Scanner scanner = new Scanner(System.in);
        String nickName, userName, password, emailAddress;
        System.out.print("Enter nickname >> ");
        nickName = scanner.next();
        if (!findSameNickName(nickName)) {
            System.out.print("Enter your name >> ");
            userName = scanner.next();
            System.out.print("Enter password >> ");
            password = scanner.next();
            System.out.print("Enter your email address >> ");
            emailAddress = scanner.next();
            userData.add(new User(nickName, userName, password, emailAddress, true));
            userDataBase.signUpUser("userinfo" ,nickName, userName, password, emailAddress);

        } else {
            System.out.println("This username is taken already!");
            signUp();
        }
    }

    @Override
    public void deleteAccount() {
        UserAdminDataBase userDataBase = new UserAdminDataBase();
        userDataBase.getDatabaseUsers(userData);
        System.out.println(deleteAccountText);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name, or email address of account you want to delete >> ");
        String userInput = scanner.next();
        if ((findSameNickName(userInput) || findSameEmailAddress(userInput))) {
            System.out.print("Enter password >> ");
            String password = scanner.next();
            if (findPassword(password) && userDataBase.existsInDatabase(findUser(userInput, password).getEmailaddress(), password, "userinfo")) {
                userDataBase.deleteFromDatabase(findUser(userInput, password).getEmailaddress(), password);
                this.userData.remove((User)findUser(userInput, password));
                System.out.println("Deleted successfully!");
            } else {
                System.out.println("Incorrect password");
            }
        } else {
            System.out.println("There is no such account in a storage!");
        }
    }

    @Override
    public void logIn() {
        UserAdminDataBase userDataBase = new UserAdminDataBase();
        userDataBase.getDatabaseUsers(userData);
        System.out.println(logInText);
        String userInput, password;
        var scanner = new Scanner(System.in);
        System.out.print("Enter nickname or email address >> ");
        userInput = scanner.next();
        if (findSameNickName(userInput) || findSameEmailAddress(userInput)) {
            System.out.print("Enter password >> ");
            password = scanner.next();
            if (findPassword(password)) {
                System.out.println("Logged in successfully!");
            } else {
                System.out.println("Incorrect password! try again!");
                logIn();
            }
        } else {
            System.out.println("Looks like you are not registered yet, sign up first!");
            signUp();
        }
    }
}