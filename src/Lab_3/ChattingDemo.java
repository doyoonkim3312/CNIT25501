package Lab_3;

import java.util.Scanner;

public class ChattingDemo {
    static Scanner inputModel = new Scanner(System.in);
    static UserDB userDB = new UserDB();

    public static void main(String[] args) {
        System.out.println("Create User please");
        Client testClient = createNewClient(); //USER 1
        userDB.addItems(testClient);
        Client TA = new Client("255", "TA", "255 TA", "datadata", UserType.CLIENT); // USER2
        userDB.addItems(TA);
        Client junkUser = new Client("John", "Doe", "jDoe", "metadata", UserType.CLIENT); // Dummy User.
        userDB.addItems(junkUser);
        SenderRotation currentSender = SenderRotation.USER1;

        System.out.println("Enter the user nickname you want to talk");
        String targetNickname = inputModel.nextLine();
        User targetUser = returnTargetClient(targetNickname);

        MessageLog messageLog = new MessageLog(testClient, targetUser);
        System.out.println("LOG IN: " + testClient.getNickName());
        System.out.println("Start Message Typing message or print chat history Typing /exit");
        String usrInput = inputModel.nextLine();



        while (true) {
            if (usrInput.equals("/exit")) {
                break;
            } else {
                switch(currentSender) {
                    case USER1: {
                        messageLog.sendMessage(new Message(testClient, TA, usrInput));
                        currentSender = SenderRotation.USER2;
                        break;
                    }
                    case USER2: {
                        messageLog.sendMessage(new Message(TA, testClient, usrInput));
                        currentSender = SenderRotation.USER1;
                        break;
                    }
                }
            }
            System.out.println("CURRENT USER: " + currentSender.name());
            System.out.println("Enter Message Typing message or print chat history /exit");
            usrInput = inputModel.nextLine();
        }
        inputModel.close();

        messageLog.printHistory(junkUser);  // This line should deny access for unauthorized access.
        messageLog.printHistory(testClient);
    }


    public static Client createNewClient() {
        System.out.println("Enter the First Name");
        String firstName = inputModel.nextLine();

        System.out.println("Enter the Last Name");
        String lastName = inputModel.nextLine();

        System.out.println("Enter the Nick Name");
        String nickName = inputModel.nextLine();

        System.out.println("Enter the password");
        String passwd = inputModel.nextLine();

        return new Client(firstName, lastName, nickName, passwd, UserType.CLIENT);
    }

    // This is a method for testing
    public static User returnTargetClient(String nickName) {
        return userDB.findUser(nickName);
    }

}
