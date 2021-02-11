package Lab_3;

import java.util.ArrayList;

public class UserDB {
    private ArrayList<User> UserList = new ArrayList<>();

    public void addItems(User user) {
        User item = new User(user);
        UserList.add(item);
    }

    public void addItems(Manager manager) {
        User item = new User(manager);
        UserList.add(item);
    }

    public void removeItems(Client client) {
        for (int i = 0; i < UserList.size(); i++) {
            if (client.getUserUniqueId() == UserList.get(i).getUserUniqueId()) {
                UserList.remove(i);
            }
        }
    }

    public void removeItems(Manager manager) {
        for (int i = 0; i < UserList.size(); i++) {
            if (manager.getUserUniqueId() == UserList.get(i).getUserUniqueId()) {
                UserList.remove(i);
            }
        }
    }

    public boolean nickNameValidation(String nickName) {
        boolean validataion = false;
        for (int i = 0; i < UserList.size(); i++) {
            if (UserList.get(i).getNickName().equals(nickName)) {
                validataion = true;
            } else {
                continue;
            }
        }
        return validataion;
    }

}
