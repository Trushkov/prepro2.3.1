package hiber.dao;

import model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    User getUser(long id);

    User removeUserById(long id);

    void updateUser(User user);

    List<User> getUsers();
}
