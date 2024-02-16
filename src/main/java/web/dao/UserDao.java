package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    List<User> readAllUsers();
    void create(User user);

    User update(User user);

    User findUser(int id);

    void delete(int id);
}
