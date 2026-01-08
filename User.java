package Task;

public class User {
    private String userName;
    private Task[] UserTask=new Task[10];

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public Task[] getUserTask() {
        return UserTask;
    }
}
