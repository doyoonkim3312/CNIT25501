package Lab_3;

public class Client  extends User {
    private UserType userType;

    // Default constructor for guest user.
    public Client() {
        super("Guest", "", "guest", "0000");
        userType = UserType.GUEST;
    }

    // Recommended Constructor
    public Client(String firstName, String lastName, String nickName, String userPw, UserType userType) {

        // Calling superclass constructor
        super(firstName, lastName, nickName, userPw);
        this.userType = userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    
}
