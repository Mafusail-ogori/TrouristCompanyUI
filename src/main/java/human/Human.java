package human;

public class Human {
    protected String nickName;
    protected String realName;
    protected String password;
    protected String emailaddress;


    public Human(String nickName, String realName, String password, String emailaddress) {
        this.nickName = nickName;
        this.realName = realName;
        this.password = password;
        this.emailaddress = emailaddress;
    }

    public String getNickName() {
        return nickName;
    }

    public String getRealName() {
        return realName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailaddress() {
        return emailaddress;
    }
}