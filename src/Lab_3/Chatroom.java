package Lab_3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

public class Chatroom {
    final private UUID chatroomId = setChatroomId();
    private ArrayList<Client> users = new ArrayList<Client>();
    private String chatroomName = "";

    public Chatroom (Client user1, Client user2) {
        users.add(user1);
        users.add(user2);
        setChatroomId();
    }

    private UUID setChatroomId() {
        return UUID.randomUUID();
    }

    public void setChatroomName(String chatroomName) {
        this.chatroomName = chatroomName;
    }

    public String getChatroomName() {
        return chatroomName;
    }

    public String getUserNickNameInChatroom() {
        String userInChatRoom = "";
        for (int i = 0; i < users.size(); i++) {
            try {
                userInChatRoom += " " + users.get(i).getNickName();
            } catch (Exception e) {
                continue;
            }
        }
        return userInChatRoom;
    }

    public void removeUserFromChatroom(Client targetUser) {

    }

    public UUID getChatroomId() {
        return chatroomId;
    }

}
