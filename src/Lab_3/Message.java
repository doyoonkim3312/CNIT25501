package Lab_3;

/**
 * @author Doyoon Kim (kim3312@purdue.edu)
 */

import java.util.Date;
import java.util.UUID;

public class Message {
    final private UUID messageId = setMessageId();
    private String message;
    final private Client sender, receiver;
    final Date date;

    public Message (Client sender, Client receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.date = new Date();
    }

    public String getMessage() {
        return message;
    }

    public String getSenderNickName() {
        return sender.getNickName();
    }

    public String getReceiverNickName() {
        return receiver.getNickName();
    }

    public String getStringFormatDate() {
        return date.toString();
    }

    public void setMessage(String messge) {
        this.message = messge;
    }

    public UUID getMessageId() {
        return messageId;
    }

    private UUID setMessageId() {
        return UUID.randomUUID();
    }

}
