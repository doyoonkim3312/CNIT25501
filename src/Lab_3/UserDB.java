package Lab_3;

import java.util.ArrayList;

public class UserDB {
    private ArrayList<Client> UserList = new ArrayList<Client>();

    public void addItems(Client user) {
        //Client item = new Client(user);
        UserList.add(user);
    }

    /*
    public void addItems(Manager manager) {
        User item = new User(manager);
        UserList.add(item);
    }
     */

    public void removeItems(Client client) {
        for (int i = 0; i < UserList.size(); i++) {
            if (client.getUserUniqueId() == UserList.get(i).getUserUniqueId()) {
                UserList.remove(i);
            }
        }
    }

    /*
    public void removeItems(Manager manager) {
        for (int i = 0; i < UserList.size(); i++) {
            if (manager.getUserUniqueId() == UserList.get(i).getUserUniqueId()) {
                UserList.remove(i);
            }
        }
    }
     */

    public Client findUser(String nickName) {
        Client targetClient = new Client();
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getNickName().equals(nickName)) {
                targetClient = new Client(UserList.get(i));
            }
        }
        return targetClient;
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
