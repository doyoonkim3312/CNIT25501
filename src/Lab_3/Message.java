package Lab_3;

import java.util.Date;
import java.util.UUID;

public class Message {
    private UUID sender;
    private UUID recevier;
    private String message;

    public Message(UUID sender, UUID recevier, String message) {
        this.sender = sender;
        this.recevier = recevier;
        this.message = message;
    }

    public UUID getSender() {
        return sender;
    }

    public UUID getRecevier() {
        return recevier;
    }

    public String getMessage() {
        return message;
    }

}
