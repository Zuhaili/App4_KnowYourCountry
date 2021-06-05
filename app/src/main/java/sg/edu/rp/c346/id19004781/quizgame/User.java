package sg.edu.rp.c346.id19004781.quizgame;

public class User {
    private int id;
    private String userName;
    private String userPass;

    public User(int id, String userName, String userPass) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return userName;
    }
    public void setName(String userName) {
        this.userName = userName;
    }
    public String getUserPass() {
        return userPass;
    }
    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
