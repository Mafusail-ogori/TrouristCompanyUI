package data;

import human.Admin;
import human.Human;
import human.User;

import java.util.List;
import java.util.Scanner;

import static graphicsText.Graphics.*;

public class AdminData extends HumanData {

    protected List<Admin> adminData;

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
            adminData.add(new Admin(nickName, userName, password, emailAddress));
            userDataBase.signUpUser("admininfo" ,nickName, userName, password, emailAddress);

        } else {
            System.out.println("This username is taken already!");
            signUp();
        }
    }

    @Override
    public void deleteAccount() {
        UserAdminDataBase userDataBase = new UserAdminDataBase();
//        userDataBase.getDatabaseUsers(adminData);
        System.out.println(deleteAccountText);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user name, or email address of account you want to delete >> ");
        String userInput = scanner.next();
        if ((findSameNickName(userInput) || findSameEmailAddress(userInput))) {
            System.out.print("Enter password >> ");
            String password = scanner.next();
            if (findPassword(password) && userDataBase.existsInDatabase(findUser(userInput, password).getEmailaddress(), password, "admininfo")) {
                userDataBase.deleteFromDatabase(findUser(userInput, password).getEmailaddress(), password);
                this.adminData.remove(((Admin)findUser(userInput, password)));
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
//        UserAdminDataBase userDataBase = new UserAdminDataBase();
//        userDataBase.getDatabaseUsers(userData);
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
