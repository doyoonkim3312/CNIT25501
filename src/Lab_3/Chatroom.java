package Lab_3;

import java.util.UUID;

public class Chatroom {
    private UUID chatroomId;
    private Client user1;
    private Client user2;
    private String chatroomName = "";
    private boolean isIdGenerated = false;

    public Chatroom (Client user1, Client user2) {
        this.user1 = user1;
        this.user2 = user2;
        setChatroomId();
    }

    private void setChatroomId() {
        if (!isIdGenerated) {
            this.chatroomId = UUID.randomUUID();
            isIdGenerated = true;
        }
    }

    public String getUser1NickName() {
        return user1.getNickName();
    }

    public String getUser2NickName() {
        return user2.getNickName();
    }

}
