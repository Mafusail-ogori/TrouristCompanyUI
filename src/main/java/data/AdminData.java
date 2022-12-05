package data;

import human.Admin;


public class AdminData extends HumanData<Admin> {
    public boolean signUp(String nickName, String realName, String password, String emailAddress) {
        UserAdminDataBase adminDataBase = new UserAdminDataBase();
        adminDataBase.getDatabaseAdmins(humanData);
        if (!findSameNickName(nickName) && validateEmail(emailAddress) && standartValidator(nickName) && standartValidator(realName)) {
            humanData.add(new Admin(nickName, realName, password, emailAddress));
            adminDataBase.signUpUser("admininfo", nickName, realName, password, emailAddress);
            return true;

        } else {
            return false;
        }
    }


    public boolean deleteAccount(String userInput, String password) {
        UserAdminDataBase adminDataBase = new UserAdminDataBase();
        adminDataBase.getDatabaseAdmins(humanData);
        if ((findSameNickName(userInput) || findSameEmailAddress(userInput))) {
            if (findPassword(password) && adminDataBase.existsInDatabase(findUser(userInput, password).getEmailaddress(), password, "admininfo")) {
                adminDataBase.deleteFromDatabase("admininfo", findUser(userInput, password).getEmailaddress(), password);
                this.humanData.remove((Admin) findUser(userInput, password));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean logIn(String userInput, String password) {
        UserAdminDataBase adminDataBase = new UserAdminDataBase();
        adminDataBase.getDatabaseAdmins(humanData);
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
