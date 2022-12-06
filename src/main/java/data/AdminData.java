package data;

import human.Admin;
import human.User;


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

    public static boolean banUser(User user){
        if(!user.getIsBanned()){
            user.setBanned(true);
            new UserAdminDataBase().banDatabaseUser(user);
            return true;
        }
        return false;
    }

    public static boolean unBanUser(User user){
         if (user.getIsBanned()){
            user.setBanned(false);
            new UserAdminDataBase().unBanDatabaseUser(user);
            return true;
        }
         return false;
    }
}
