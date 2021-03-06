package Lab_3;


import java.util.Scanner;

public class ChattingDemo {
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
        Client testClient = createNewClient(); //USER 1
        userDB.addItems(testClient);


        System.out.println("Enter the sender nickname");
        Client sender = returnTargetClient(inputModel.nextLine());

        System.out.println("Enter the receiver nickname");
        Client receiver = returnTargetClient(inputModel.nextLine());

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
                sender = returnTargetClient(inputModel.nextLine());
                if (!messageLog.clientValidation(sender)) {
                    messageLog.addUser(sender);
                }

                System.out.println("Enter receiver nickname");
                receiver = returnTargetClient(inputModel.nextLine());
                if (!messageLog.clientValidation(receiver)) {
                    messageLog.addUser(receiver);
                }
            }

        }

        inputModel.close();

    }


    public static Client createNewClient() {
        System.out.println("Enter the First Name");
        String firstName = inputModel.nextLine();

        System.out.println("Enter the Last Name");
        String lastName = inputModel.nextLine();

        System.out.println("Enter the Nick Name");
        String nickName = inputModel.nextLine();
        System.out.println(userDB.nickNameValidation(nickName));
        while(userDB.nickNameValidation(nickName)) {
            System.out.println("Nickname is already used. Enter new nickname");
            nickName = inputModel.nextLine();
        }

        System.out.println("Enter the password");
        String passwd = inputModel.nextLine();

        return new Client(firstName, lastName, nickName, passwd, UserType.CLIENT);
    }

    // This is a method for testing
    public static Client returnTargetClient(String nickName) {
        while (true) {
            if(userDB.findUser(nickName).getNickName().equals("guest")) {
                System.out.println("No User Found; Please enter valid nickname");
                nickName = inputModel.nextLine();
            } else {
                break;
            }
        }
        return userDB.findUser(nickName);
    }

}
