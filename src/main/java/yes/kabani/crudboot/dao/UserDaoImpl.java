package yes.kabani.crudboot.dao;

import yes.kabani.crudboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    @Lazy
    private PasswordEncoder passwordEncoder;

    @Override
    public List getAllUsers() {
        return entityManager.createQuery("FROM User").getResultList();
    }

    @Override
    public User findById(Long id) {
        TypedQuery<User> query = entityManager.createQuery("FROM User WHERE id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        entityManager.merge(user);
    }

    @Override
    public User getUserByName(String name) {
        TypedQuery<User> query = entityManager
                .createQuery("FROM User WHERE login = :name", User.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
