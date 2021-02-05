package Lab_3;

public interface Chatting {
    void sendMessage(Client sender, Client receiver, String message);

    Message receiveMessage();
}
