package Lab_3;

/**
 * @author Doyoon Kim (kim3312@purdue.edu)
 */

import java.util.ArrayList;
import java.util.UUID;

public class MessageLog extends Chatroom implements Chatting{
    final private UUID messageLogId = generateLogId();
    private ArrayList<Message> messages = new ArrayList<Message>();

    public MessageLog(User user1, User user2) {
        super(user1, user2);
    }

    public void printHistory(String senderNickname, String receiverNickName) {
        if (clientValidation(senderNickname) && clientValidation(receiverNickName)) {
            // System.out.println("CHAT HISTORY between " + getUserNickNameInChatroom());
            for (int i = 0; i < messages.size(); i++) {
                if (messages.get(i) == null) {
                    continue;
                } else {
                    if (messages.get(i).getSenderNickName().equals(senderNickname) &&
                            messages.get(i).getReceiverNickName().equals(receiverNickName)) {
                        System.out.println("At ("+ messages.get(i).getStringFormatDate() + "), " + messages.get(i).getSenderNickName() + " said: "
                                + messages.get(i).getMessage());
                    } else {
                        continue;
                    }
                }
            }
        } else {
            System.out.println("Access Denied.");
        }
    }

    public void printHistory() {
        for (int i = 0; i < messages.size(); i++) {
            if (messages.get(i) == null) {
                continue;
            } else {
                System.out.println("At ("+ messages.get(i).getStringFormatDate() + "), " + messages.get(i).getSenderNickName() + " said: "
                        + messages.get(i).getMessage());
            }
        }
    }

    public boolean clientValidation(Client client) {
        boolean accessValidation = false;

        switch (client.getUserType()) {
            case CLIENT: {
                for (int i = 0; i < super.getUserList().size(); i++) {
                    if (client.getUserUniqueId() == super.getUserList().get(i).getUserUniqueId()) {
                        accessValidation = true;
                    }
                }
                break;
            }
            case MANAGER: {
                accessValidation = true;
                break;
            }
            default: {
                break;
            }
        }
        return accessValidation;
    }

    public boolean clientValidation(String nickname) {
        boolean accessValidation = false;
                for (User element: super.getUserList()) {
                    if (element.getNickName().equals(nickname)) {
                        accessValidation = true;
                    }
                }
        return accessValidation;
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
