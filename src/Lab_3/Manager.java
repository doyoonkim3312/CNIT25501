package Lab_3;

public class Manager extends User {
    private UserType userType = UserType.MANAGER;

    public Manager(String firstName, String lastName, String nickName, String passwd) {
        super(firstName, lastName, nickName, passwd);
    }

    public UserType getUserType() {
        return userType;
    }
}
