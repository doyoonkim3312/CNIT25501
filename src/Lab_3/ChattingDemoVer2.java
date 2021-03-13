package Lab_3;

/**
 * @author Doyoon Kim (kim3312@purdue.edu)
 */

import java.util.Scanner;

public class ChattingDemoVer2 {
    static Scanner inputModel = new Scanner(System.in);
    static UserDB userDB = new UserDB();

    public static void main(String[] args) {
        Client TA = new Client("255", "TA", "255 TA", "datadata", UserType.CLIENT); // USER2
        userDB.addItems(TA);
        Client junkUser = new Client("John", "Doe", "jDoe", "metadata", UserType.CLIENT); // Dummy User.
        userDB.addItems(junkUser);

        /*
        ArrayList<Client> test1 = userDB.returnUser();
        for (int i = 0; i < test1.size(); i++) {
            System.out.println(test1.get(i).getNickName());
        }
         */

        System.out.println("Create User please");
        Client testClient = Client.createNewClient(inputModel, userDB);
        userDB.addItems(testClient);



        SenderRotation currentSender = SenderRotation.USER1;


        System.out.println("Enter the user nickname you want to talk");
        String targetNickname = inputModel.nextLine();
        // Client targetUser = returnTargetClient(targetNickname);
        Client targetUser = userDB.findUser(targetNickname, inputModel);

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
                        messageLog.sendMessage(new Message(testClient, targetUser, usrInput));
                        currentSender = SenderRotation.USER2;
                        break;
                    }
                    case USER2: {
                        messageLog.sendMessage(new Message(targetUser, testClient, usrInput));
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

        messageLog.printHistory();  // Need to add access controlling.
    }

}
