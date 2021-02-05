package Lab_3;

import java.util.Date;
import java.util.UUID;

public class Message {
    private UUID messageId;
    private String message;
    private Client sender, receiver;
    private Date date;
    private boolean isIdGenerated = false;

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

    private void setMessageId() {
        if (!isIdGenerated) {
            this.messageId = UUID.randomUUID();
            isIdGenerated = true;
        }
    }

}
