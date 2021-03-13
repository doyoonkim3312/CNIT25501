package Lab_3;

/**
 * @author Doyoon Kim (kim3312@purdue.edu)
 */

import java.util.Scanner;

public class ChattingDemo {
    static Scanner inputModel = new Scanner(System.in);
    static UserDB userDB = new UserDB();

    public static void main(String[] args) {
        Client TA = new Client("255", "TA", "255 TA", "datadata", UserType.CLIENT); // USER2
        userDB.addItems(TA);
        Client junkUser = new Client("John", "Doe", "jDoe", "metadata", UserType.CLIENT); // Dummy User.
        userDB.addItems(junkUser);

        System.out.println("Create User please");
        Client testClient = Client.createNewClient(inputModel, userDB); //USER 1
        userDB.addItems(testClient);


        System.out.println("Enter the sender nickname");
        Client sender = userDB.findUser(inputModel.nextLine(), inputModel);

        System.out.println("Enter the receiver nickname");
        Client receiver = userDB.findUser(inputModel.nextLine(), inputModel);

        MessageLog messageLog = new MessageLog(sender, receiver);
        String usrInput;

        while (true) {
            System.out.println("LOG IN: " + sender.getNickName());
            System.out.println("Start Message Typing message or print chat history Typing /exit\nOr Type /history to get history");
            usrInput = inputModel.nextLine();
            if (usrInput.equals("/exit")) {
                break;
            } else if (usrInput.equals("/history")) {
                System.out.println("Please enter the sender and receiver with spacing. If you want to print all");
                String[] option = inputModel.nextLine().split(" ");

                try {
                    messageLog.printHistory((option[0]), option[1]);
                } catch (Exception e) {
                    messageLog.printHistory();
                }

            } else {
                messageLog.sendMessage(new Message(sender, receiver, usrInput));
            }

            System.out.println("Type any key to continue, or type /exit");
            String checkPoint = inputModel.nextLine();
            if (checkPoint.equals("/exit")) {
                break;
            } else {
                System.out.println("Enter the sender nickname");
                sender = userDB.findUser(inputModel.nextLine(), inputModel);
                if (!messageLog.clientValidation(sender)) {
                    messageLog.addUser(sender);
                }

                System.out.println("Enter receiver nickname");
                receiver = userDB.findUser(inputModel.nextLine(), inputModel);
                if (!messageLog.clientValidation(receiver)) {
                    messageLog.addUser(receiver);
                }
            }
        }

        inputModel.close();

    }
}
