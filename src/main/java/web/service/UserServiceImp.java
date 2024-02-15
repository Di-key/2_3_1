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
    @Autowired
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

//    @Override
//    @Transactional
//    public User update(int id) {
//        return userDao.update(id);
//    }



    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
}
