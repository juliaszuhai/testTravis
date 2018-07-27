package edu.msg.ro.persistence.user.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRole;
    private String type;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="ROLES_PERMISSIONS",joinColumns=@JoinColumn(name="idRole"),
            inverseJoinColumns={
                    @JoinColumn(name="idPermission")
            })
    List<Permission> permissionsList;

    @ManyToMany(mappedBy="rolesList")
    private List<User> usersList;

    public long getIdRole() {
        return idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
