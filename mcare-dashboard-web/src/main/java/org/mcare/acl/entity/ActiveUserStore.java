/**
 * 
 */
package org.mcare.acl.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.stereotype.Service;

/**
 * @author nursat
 *
 */
@Service
@Entity
public class ActiveUserStore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activeUserStore_id_seq")
    @SequenceGenerator(name = "activeUserStore_id_seq", sequenceName = "activeUserStore_id_seq", allocationSize = 1)
    private int id;

    @OneToMany(fetch=FetchType.EAGER)
    public List<ActiveUser> users;

    public ActiveUserStore() {
        users = new ArrayList<ActiveUser>();
    }

    public List<ActiveUser> getUsers() {
        return users;
    }

    public void setUsers(List<ActiveUser> users) {
        this.users = users;
    }
    
    public ActiveUser getActiveUserByUsername(String userName) {
        ActiveUser activeUser = new ActiveUser();
        for (ActiveUser au : users) {
            if(userName.equalsIgnoreCase(au.getUserName())) {
                activeUser = au;
            }
        }
        return activeUser;
    }

}
