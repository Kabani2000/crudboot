package yes.kabani.crudboot.service;

import yes.kabani.crudboot.model.Role;
import yes.kabani.crudboot.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    List<User> getAllUsers();

    User findById(Long id);

    void addUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    User getUserByName(String name);

    Role findByRole(String role);

    Role findByRole(Long id);

    Set<Role> findByRole(Set<Long> roleId);

    List<Role> getAllRoles();
}
