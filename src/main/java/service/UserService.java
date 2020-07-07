package service;

import model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User getUser(long id);

    User removeUserById(long id);

    void updateUser(User user);

    List<User> getUsers();
}
