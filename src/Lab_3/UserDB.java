package Lab_3;

/**
 * @author Doyoon Kim (kim3312@purdue.edu)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class UserDB {
    private ArrayList<Client> UserList = new ArrayList<Client>();

    public void addItems(Client user) {
        //Client item = new Client(user);
        UserList.add(user);
    }


    public void removeItems(Client client) {
        for (int i = 0; i < UserList.size(); i++) {
            if (client.getUserUniqueId() == UserList.get(i).getUserUniqueId()) {
                UserList.remove(i);
            }
        }
    }


    public Client findUser(String nickName) {
        Client targetClient = new Client();
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getNickName().equals(nickName)) {
                targetClient = new Client(UserList.get(i));
            }
        }
        return targetClient;
    }

    // Overloaded
    public Client findUser(String nickName, Scanner inputModel) {
        while (true) {
            for (Client client: UserList) {
                if (client.getNickName().equals(nickName)) {
                    return client;
                } else {
                    continue;
                }
            }
            System.out.println("No User Found. Please enter valid nickname");
            nickName = inputModel.nextLine();
        }
    }

    public boolean nickNameValidation(String nickName) {
        boolean validataion = false;
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getNickName().equals(nickName)) {
                System.out.println(UserList.get(i).getNickName());
                validataion = true;
                break;
            } else {
                continue;
            }
        }
        return validataion;
    }


}
