package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();
    public void saveUser(User user);
    public User updateUser(int id);

    void deleteUser(int id);
}
