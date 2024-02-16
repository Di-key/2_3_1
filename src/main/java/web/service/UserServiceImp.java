package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.models.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService{
    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    @Transactional
    public List<User> readAllUsers() {
        return userDao.readAllUsers();
    }

    @Override
    @Transactional
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    public User findUser(int id) {
        return userDao.findUser(id);
    }

    @Override
    @Transactional
    public User update(User user) {
       return userDao.update(user);
    }



    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }

}
