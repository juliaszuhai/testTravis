package edu.msg.ro.persistence.user.dao;

import edu.msg.ro.persistence.user.entity.Role;
import edu.msg.ro.persistence.user.entity.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless(name="UserManagementImpl", mappedName="UserManagementImpl")
public class UserManagementImpl implements UserManagement {

    private static final long serialVersionUID=1L;

    @PersistenceContext(unitName = "jbugs-persistence")
    EntityManager em;

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User updateUser(User user) {
        em.merge(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Query q =em.createQuery("select u from User u");
        return q.getResultList();
    }

    @Override
    public User getUserForUsername(String username) {
        Query q =em.createQuery("select u from User u where u.username="+username);
        return (User) q.getResultList();
    }

    @Override
    public void deactivateUser(long id) {
            User user=em.find(User.class,id);
            user.setStatus("close");
            em.merge(user);
    }

    @Override
    public void addRole(Role role) {
        em.persist(role);

    }

    @Override
    public void removeRole(Role role) {

        em.remove(role);
    }

    @Override
    public Role updateRole(Role role) {
        em.merge(role);
        return role;
    }

    @Override
    public Role getRoleForId(long id) {
        return em.find(Role.class,id);
    }

    @Override
    public List<Role> getAllRoles() {
        Query q =em.createQuery("select r from Role r");
        return q.getResultList();
    }
}
