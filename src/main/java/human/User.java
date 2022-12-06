package human;

public class User extends Human {
    boolean isBanned;
    public User (String nickName, String realName, String password, String emailAddress, boolean isBanned) {
        super(nickName, realName, password, emailAddress);
        this.isBanned = isBanned;
    }

    @Override
    public String toString() {
        return nickName + " " + realName + " " + password;
    }

    public boolean getIsBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }
}