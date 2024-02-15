package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<User> readAllUsers() {
        return manager.createQuery("from User", User.class).getResultList();
    }
    @Override
    public void create(User user) {
        manager.persist(user);
    }

    @Override
    public User update(int id) {
        User existingUser = manager.find(User.class, id);
        return manager.merge(existingUser);
    }
//        if (existingUser != null) {
//            // Обновляем существующего пользователя в базе данных
//            return manager.merge(existingUser);
//        }
//        return null;
//    }

    @Override
    public User findUser(int id) {
        return manager.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        User user = manager.find(User.class, id);
        manager.remove(user);
    }
}