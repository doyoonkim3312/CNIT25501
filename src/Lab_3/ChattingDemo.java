package Lab_3;

import java.util.Scanner;

public class ChattingDemo {
    static Scanner inputModel = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Create User please");
        Client testClient = createNewClient(); //USER 1
        Client TA = new Client("255", "TA", "255 TA", "datadata", UserType.CLIENT); // USER2
        SenderRotation currentSender = SenderRotation.USER1;


        MessageLog messageLog = new MessageLog(testClient, TA);
        System.out.println("LOG IN: " + testClient.getNickName());
        System.out.println("Start Message Typing message or print chat history Typing /exit");
        String usrInput = inputModel.nextLine();

        while (true) {
            if (usrInput.equals("/exit")) {
                break;
            } else {
                switch(currentSender) {
                    case USER1: {
                        messageLog.sendMessage(testClient, TA, usrInput);
                        currentSender = SenderRotation.USER2;
                        break;
                    }
                    case USER2: {
                        messageLog.sendMessage(TA,testClient, usrInput);
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

        messageLog.printHistory();
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

}
