package edu.msg.ro.persistence.user.dao;
import edu.msg.ro.persistence.user.entity.Role;
import edu.msg.ro.persistence.user.entity.User;
import java.io.Serializable;
import java.util.List;

public interface UserManagement extends Serializable {

    void addUser(User user);

    User updateUser(User user);

    List<User> getAllUsers();

    User getUserForUsername(String username);

    void deactivateUser(long id);

    void addRole(Role role);

    void removeRole(Role role);

    Role updateRole(Role role);

    Role getRoleForId(long id);

    List<Role> getAllRoles();
}
