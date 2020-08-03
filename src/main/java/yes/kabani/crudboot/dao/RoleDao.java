package yes.kabani.crudboot.dao;

import yes.kabani.crudboot.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {
    Role findByRole(String role);

    Role findByRole(Long id);

    Set<Role> findByRole(Set<Long> roleId);

    List<Role> getAllRoles();
}
