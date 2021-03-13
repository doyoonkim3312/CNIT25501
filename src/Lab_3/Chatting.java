package Lab_3;

/**
 * @author Doyoon Kim (kim3312@purdue.edu)
 */

public interface Chatting {
    void sendMessage(Message message);

    Message receiveMessage(MessageLog messageLog);

    // void removeMessage(MessageLog messageLog, Message targetMessage);
}
