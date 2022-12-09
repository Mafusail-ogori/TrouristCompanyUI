package data;

import human.Human;
import human.User;

public class UserData extends HumanData<User> {
    public boolean signUp(String nickName, String realName, String password, String emailAddress) {
        UserAdminDataBase userDataBase = new UserAdminDataBase();
        userDataBase.getDatabaseUsers(humanData);
        if (!findSameNickName(nickName) && validateEmail(emailAddress) && standartValidator(nickName)) {
            humanData.add(new User(nickName, realName, password, emailAddress, false));
            userDataBase.signUpUser("userinfo", nickName, realName, password, emailAddress);
            return true;

        } else {
            return false;
        }
    }


    public boolean deleteAccount(String userInput, String password) {
        UserAdminDataBase userDataBase = new UserAdminDataBase();
        userDataBase.getDatabaseUsers(humanData);
        if ((findSameNickName(userInput) || findSameEmailAddress(userInput))) {
            if (findPassword(password) && userDataBase.existsInDatabase(findUser(userInput, password).getEmailaddress(), password, "userinfo")) {
                userDataBase.deleteFromDatabase("userinfo", findUser(userInput, password).getEmailaddress(), password);
                this.humanData.remove((User) findUser(userInput, password));
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isBanned(String userInput, String password){
        for (var user : humanData){
            if (user.getNickName().equalsIgnoreCase(userInput) && user.getPassword().equals(password) && user.getIsBanned()){
                return true;
            }
        }
        return false;
    }

    public boolean logIn(String userInput, String password) {
        UserAdminDataBase userDataBase = new UserAdminDataBase();
        userDataBase.getDatabaseUsers(humanData);
        if ((findSameNickName(userInput) || findSameEmailAddress(userInput)) && !isBanned(userInput, password) ) {
            return findPassword(password);
        } else {
            return false;
        }
    }
}