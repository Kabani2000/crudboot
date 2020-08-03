package yes.kabani.crudboot.dao;

import yes.kabani.crudboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User findById(Long id);

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserByName(String name);
}
