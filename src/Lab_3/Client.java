package Lab_3;

import java.util.Scanner;

public class Client  extends User {
    private UserType userType;

    // Default constructor for guest user.
    public Client() {
        super("NaU", "", "NaU", "0000");
        userType = UserType.NULL;
    }

    // Recommended Constructor
    public Client(String firstName, String lastName, String nickName, String userPw, UserType userType) {

        // Calling superclass constructor
        super(firstName, lastName, nickName, userPw);
        this.userType = userType;
    }

    // Prevent Deep copy

    public Client(Client targetClient) {
        super(targetClient.getFirstName(), targetClient.getLastName(), targetClient.getNickName(), targetClient.getUserPw());
        this.userType = targetClient.getUserType();
    }


    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public static Client createNewClient(Scanner inputModel, UserDB userDB) {
        System.out.println("Enter the First Name");
        String firstName = inputModel.nextLine();

        System.out.println("Enter the Last Name");
        String lastName = inputModel.nextLine();

        System.out.println("Enter the Nick Name");
        String nickName = inputModel.nextLine();
        while(userDB.nickNameValidation(nickName)) {
            System.out.println("Nickname is already used. Enter new nickname");
            nickName = inputModel.nextLine();
        }

        System.out.println("Enter the password");
        String passwd = inputModel.nextLine();

        return new Client(firstName, lastName, nickName, passwd, UserType.CLIENT);
    }

}
