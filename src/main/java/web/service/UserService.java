package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> readAllUsers();
    void create(User user);
//    User update(int id);

    public User findUser(int id);

    void delete(int id);
}
