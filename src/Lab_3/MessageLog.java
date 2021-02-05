package Lab_3;

import java.util.ArrayList;
import java.util.UUID;

public class MessageLog extends Chatroom implements Chatting{
    final private UUID messageLogId = generateLogId();
    private ArrayList<Message> messages = new ArrayList<Message>();
    private boolean isIdGenerated = false;

    public MessageLog(Client user1, Client user2) {
        super(user1, user2);
    }

    public void printHistory() {
        System.out.println("CHAT HISTORY between [" + getUser1NickName() +"] [" + getUser2NickName() +"]" );
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i) == null) {
                continue;
            } else {
                System.out.println("At ("+ messages.get(i).getStringFormatDate() + "), " + messages.get(i).getSenderNickName() + " said: "
                        + messages.get(i).getMessage());
            }
        }
    }


    private UUID generateLogId() {
        return UUID.randomUUID();
    }

    @Override
    public void sendMessage(Client sender, Client receiver, String message) {
        messages.add(new Message(sender, receiver, message));
    }

    @Override
    public Message receiveMessage() {
        return null;
    }
}
