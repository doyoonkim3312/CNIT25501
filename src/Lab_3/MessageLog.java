package Lab_3;

import java.util.ArrayList;
import java.util.UUID;

public class MessageLog extends Chatroom implements Chatting{
    final private UUID messageLogId = generateLogId();
    private ArrayList<Message> messages = new ArrayList<Message>();

    public MessageLog(Client user1, Client user2) {
        super(user1, user2);
    }

    public void printHistory() {
        System.out.println("CHAT HISTORY between " + getUserNickNameInChatroom());
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i) == null) {
                continue;
            } else {
                System.out.println("At ("+ messages.get(i).getStringFormatDate() + "), " + messages.get(i).getSenderNickName() + " said: "
                        + messages.get(i).getMessage());
            }
        }
    }

    // This method only removes message String.
    public void notifyChanges(Message message) {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i).getMessageId() == message.getMessageId()) {
                messages.get(i).setMessage(message.getMessage());
            } else {
                continue;
            }
        }
    }

    public UUID getMessageLogId() {
        return messageLogId;
    }

    private UUID generateLogId() {
        return UUID.randomUUID();
    }

    @Override
    public void sendMessage(Message message) {
        messages.add(message);
    }

    @Override
    public Message receiveMessage(MessageLog messageLog) {
        return null;
    }
}
