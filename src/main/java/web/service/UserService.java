package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> readAllUsers();
    void create(User user);
    User update(User user);

    public User findUser(int id);

    void delete(int id);
}
