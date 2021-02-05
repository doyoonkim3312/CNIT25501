package Lab_3;

import java.util.UUID;

public class User {
    private String firstName;
    private String lastName;
    private String nickName;
    private String userPw;
    private UUID userUniqueId;
    private boolean isIdGenerated = false;

    public User(String firstName, String lastName, String nickName, String userPw) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.userPw = userPw;
        setUserUniqueId();
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

    public UUID getUserUniqueId() {
        return this.userUniqueId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    public void setUserUniqueId() {
        if (!isIdGenerated) {
            this.userUniqueId = generateUUID();
        }
    }
    
    private UUID generateUUID() {
        isIdGenerated = true;
        return UUID.randomUUID();
    }
}
