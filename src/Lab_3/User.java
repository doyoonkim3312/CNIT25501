package Lab_3;

import java.util.UUID;

public class User {
    private String firstName;
    private String lastName;
    private String nickName;
    private String userPw;
    final private UUID userUniqueId = generateUUID();

    public User(String firstName, String lastName, String nickName, String userPw) {
        setFirstName(firstName);
        setLastName(lastName);
        setNickName(nickName);
        setUserPw(userPw);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getUserPw() {
        return userPw;
    }

    public UUID getUserUniqueId() {
        return this.userUniqueId;
    }

    public void setFirstName(String firstName) {
        this.firstName = inputStringValidator(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = inputStringValidator(lastName);
    }

    public void setNickName(String nickName) {
        this.nickName = inputStringValidator(nickName);
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public String inputStringValidator(String inputString) {
        String[] stringList = inputString.split("");
        String validateString = "";

        for (int i = 0; i < stringList.length; i++) {
            try {
                if (stringList[i].equals(" ")) {
                    continue;
                } else {
                    validateString += stringList[i];
                }
            } catch (NullPointerException npe) {
                validateString = " ";
                break;
            }
        }
        return validateString;
    }

    private UUID generateUUID() {
        return UUID.randomUUID();
    }
}
